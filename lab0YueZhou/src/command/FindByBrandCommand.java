package command;

import java.util.List;

import ui.Ui;
import service.ApplianceService;
import model.Appliance;

/**
 * Command to search for appliances by their brand name.
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Injected Dependencies:
 * - Ui: Interface for interacting with the user (e.g., console-based input/output).
 * - ApplianceService: Service layer handling appliance data operations.
 * 
 * Implements:
 * - Command: Enables execution of brand search functionality.
 * 
 * Functionality:
 * - Prompts the user to input a brand name.
 * - Searches for appliances matching the brand name (case-insensitive).
 * - Displays all matching appliances or a message if no match is found.
 */

public class FindByBrandCommand implements Command {
	private final Ui ui;
	private final ApplianceService applianceService;
	
	public FindByBrandCommand(Ui ui, ApplianceService applianceService) {
		this.ui = ui;
		this.applianceService = applianceService;
	}
	
	@Override
	public void execute() {
		ui.displayMessage("Enter brand to search for:");
        String brandName = ui.getUserInput().trim();
        
        List<Appliance> matchingAppliances = applianceService.findByBrand(brandName);
        
        if (matchingAppliances.isEmpty()) {
            ui.displayMessage("No appliances found for brand: " + brandName);
        } else {
            ui.displayMessage("Matching Appliances:");
            for (Appliance appliance : matchingAppliances) {
                ui.displayMessage(appliance.toString() + '\n');
            }
        }
	}
}
