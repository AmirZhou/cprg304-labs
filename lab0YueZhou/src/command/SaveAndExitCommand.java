package command;

import service.ApplianceService;
import ui.Ui;

/**
 * Command to save appliance data to a file and exit the application.
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Injected Dependencies:
 * - Ui: Interface for user interaction (e.g., displaying messages to the user).
 * - ApplianceService: Service layer for managing appliance data, including file operations.
 * 
 * Implements:
 * - Command
 * 
 * Functionality:
 * - Saves the current appliance data to a file.
 * - Notifies the user of the success or failure of the save operation.
 * - Exits the application gracefully after saving.
 */

public class SaveAndExitCommand implements Command {
    private final ApplianceService applianceService;
    private final Ui ui;

    public SaveAndExitCommand(Ui ui, ApplianceService applianceService) {
        this.applianceService = applianceService;
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.displayMessage("Saving appliances data...");

        // Attempt to save the data
        if (applianceService.saveToFile()) {
            ui.displayMessage("Data saved successfully.");
        } else {
            ui.displayMessage("Failed to save data.");
        }

        ui.displayMessage("Exiting the application. Goodbye!");
        System.exit(0); // Gracefully terminate the application
    }
}