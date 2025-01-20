package app;

import java.util.HashMap;
import java.util.Map;

import ui.*;
import command.*;
import service.*;

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
