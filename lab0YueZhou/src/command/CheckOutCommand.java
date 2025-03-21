package command;

import model.Appliance;
import service.ApplianceService;
import ui.Ui;

/**
 * CheckOutCommand Class
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Description:
 * Handles the process of checking out an appliance. Allows users to specify
 * an appliance by its item number and updates its availability.
 * 
 * Injected Dependencies:
 * - `Ui`: Interface for user interactions.
 * - `ApplianceService`: Manages appliance operations.
 * 
 * Key Responsibilities:
 * - Prompt the user for an item number.
 * - Validate the item number and check availability.
 * - Update the quantity of the appliance upon successful check-out.
 * - Notify the user of the operation result.
 */

public class CheckOutCommand implements Command {
	private final Ui ui;
	private final ApplianceService applianceService;
	
	public CheckOutCommand(Ui ui, ApplianceService applianceService) {
		this.ui = ui;
		this.applianceService = applianceService;
	}
	
	@Override
	public void execute() {
		ui.displayMessage("Enter the item number of an appliance:");
		String itemNumber = ui.getUserInput();
		
		Appliance appliance = applianceService.checkOut(itemNumber);
		
		if (appliance == null) {
            // Case 1: Appliance not found
            ui.displayMessage("No appliances found with the item number: " + itemNumber + '\n');
        } else if (appliance.quantity() == 0) {
            // Case 2: Appliance is out of stock
            ui.displayMessage("The appliance is not available to be checked out.\n");
        } else {
            // Case 3: Successful check-out
            appliance.setQuantity(appliance.quantity() - 1);
            ui.displayMessage("Appliance \"" + itemNumber + "\" has been checked out.\n");
        }
	}
}
