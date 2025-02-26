package command;

import service.ApplianceService;
import ui.Ui;
import model.Appliance;

import java.util.List;

/** Command to display a random selection of appliances.
* 
* Author: Yue Zhou (Amir)
* 
* Injected Dependencies:
* - Ui: Interface for user interaction (e.g., console-based input/output).
* - ApplianceService: Service layer for managing appliance data.
* 
* Implements:
* - Command
* 
* Functionality:
* - Prompts the user to specify the number of random appliances to display.
* - Fetches a random selection of appliances using the service.
* - Displays the randomly selected appliances or an appropriate message for errors.
*/

public class RandomApplianceCommand implements Command {
    private final ApplianceService applianceService;
    private final Ui ui;

    public RandomApplianceCommand(Ui ui, ApplianceService applianceService) {
        this.applianceService = applianceService;
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.displayMessage("Enter the number of random appliances to display: ");
        int count = ui.getUserOption();

        try {
            List<Appliance> randomAppliances = applianceService.getRandom(count);
            
            if (randomAppliances.isEmpty()) {
                ui.displayMessage("No appliances available.");
                return;
            }
            
            ui.displayMessage("Random Appliances:");
            for (Appliance appliance : randomAppliances) {
                ui.displayMessage(appliance.toString() + '\n');
            }
            
        } catch (IllegalArgumentException e) {
            ui.displayMessage("Invalid count. Please try again.");
        }
    }
}