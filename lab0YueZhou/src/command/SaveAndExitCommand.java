package command;

import service.ApplianceService;
import ui.Ui;

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