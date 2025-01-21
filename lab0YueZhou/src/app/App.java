package app;

import java.util.HashMap;
import java.util.Map;

import ui.*;
import command.*;
import service.*;

/**
 * App Class
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Description:
 * Serves as the main controller of the application, managing user interactions
 * and delegating tasks to appropriate commands based on user input.
 * 
 * Injected Dependencies:
 * - `Ui`: Interface for user interaction.
 * - `ApplianceService`: Handles appliance-related operations.
 * 
 * Interfaces:
 * - Utilizes the `Command` interface for handling user actions.
 * 
 * Key Responsibilities:
 * - Map menu options to command implementations.
 * - Manage the application lifecycle through a run loop.
 */


public class App {
	private final Ui ui;
	private final Map<Integer, Command> commands = new HashMap<>();
	
	public App(Ui ui, ApplianceService service) {
        this.ui = ui;
        commands.put(1, new CheckOutCommand(ui, service));
        commands.put(2, new FindByBrandCommand(ui, service));
        commands.put(3, new DisplayByTypeCommand(ui, service));
        commands.put(4, new RandomApplianceCommand(ui, service));
        commands.put(5, new SaveAndExitCommand(ui, service));
    }
	
	public void run() {
		boolean running = true;
		
		while (running) {
			ui.displayMenu();
			int option = ui.getUserOption();
			
			Command command = commands.get(option);
			if (command != null) {
				command.execute();
				if (option == 5) {
					running = false; //exit after saving
				}
			} else {
				ui.displayMessage("Invalid option.");
			}
		}
	}
}
