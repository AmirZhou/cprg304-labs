package command;

import java.util.List;

import ui.Ui;
import service.ApplianceService;
import model.Appliance;

public class FindByBrandCommand implements Command {
	private final Ui ui;
	private final ApplianceService applianceService;
	
	public FindByBrandCommand(Ui ui, ApplianceService applianceService) {
		this.ui = ui;
		this.applianceService = applianceService;
	}
	
	@Override
	public void execute() {
		String brandName = ui.getUserInput();
		List<Appliance> matchingAppliances = applianceService.findByBrand(brandName);
	}
}
