package command;

import model.Appliance;
import service.ApplianceService;
import ui.Ui;

public class CheckOutCommand implements Command {
	private final Ui ui;
	private final ApplianceService applianceService;
	
	public CheckOutCommand(Ui ui, ApplianceService applianceService) {
		this.ui = ui;
		this.applianceService = applianceService;
	}
	
	@Override
	public void execute() {
		String itemNumber = ui.getUserInput();	
		Appliance appliance = applianceService.checkOut(itemNumber);
		
	}
}
