package command;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import model.Appliance;
import ui.*;
import service.ApplianceService;

/**
* Command to display appliances filtered by type and additional criteria.
* 
* Author: Yue Zhou (Amir)
* 
* Injected Dependencies:
* - Ui: Interface for interacting with the user (e.g., console-based input/output).
* - ApplianceService: Service layer handling appliance data operations.
* 
* Implements:
* - Command
* 
* Functionality:
* - Prompts the user to select an appliance type.
* - Collects additional filtering criteria based on the selected type.
* - Displays a list of appliances matching the selected type and criteria.
*/

public class DisplayByTypeCommand implements Command{
	private final Ui ui;
	private final ApplianceService applianceService;
	
	public DisplayByTypeCommand(Ui ui, ApplianceService applianceService) {
		this.ui = ui;
		this.applianceService = applianceService;
	}
	
	@Override
	public void execute() {
		
		// 1. Get appliance type
		ui.displayMessage("Appliance Types:");
		ui.displayMessage("1 – Refrigerators");
        ui.displayMessage("2 – Vacuums");
        ui.displayMessage("3 – Microwaves");
        ui.displayMessage("4 – Dishwashers");
        
        int type = ui.getUserOption();
        
        // 2. Get additional criteria
        Map<String, Object> criteria = new HashMap<>();
        switch (type) {
        	case 1 -> {
        		ui.displayMessage("Enter number of doors (2, 3, or 4)");
        		int doors = ui.getUserOption();
        		criteria.put("numberOfDoors", doors);
        	}
        	
        	case 2 -> {
        		ui.displayMessage("Enter battery voltage value (18 or 24)");
        		int voltage = ui.getUserOption();
        		criteria.put("batteryVoltage", voltage);	
        	}
        	
        	case 3 -> {
        		ui.displayMessage("Enter room type (K for kitchen, W for worksite)");
        		String roomType = ui.getUserInput();
        		criteria.put("roomType", roomType.toUpperCase());
        	}
        	
        	case 4 -> {
        		ui.displayMessage("Enter sound rating (Qt, Qr, Qu, or M):");
        		String soundRating = ui.getUserInput();
        		criteria.put("soundRating", soundRating.toUpperCase());
        	}
        	
        	default -> {
                ui.displayMessage("Invalid option. Please choose a valid type.");
                return;
            }
        }
        
        // 3. Search for appliances
        List<Appliance> matchingAppliances = applianceService.findByType(type, criteria);
        
        // 4. Display
        if (matchingAppliances.isEmpty()) {
        	ui.displayMessage("No appliances found matching the criteria.");
        } else {
        	
        	ui.displayMessage("Matching Appliances:");
            for (Appliance appliance : matchingAppliances) {
                ui.displayMessage(appliance.toString() + '\n');
            }
        	
        }
	}
}
