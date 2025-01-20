package service;

import model.Appliance;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ApplianceService {
	private final FileHandler fileHandler;
	private final Appliance[] appliances = null;
	
	public ApplianceService(FileHandler fileHandler) {
		this.fileHandler = fileHandler;
	}
	
	public bool loadAppliance() {
		
	}
	
//	I don't want to manually call the loadAppliance myself, i prefer it done on service creation
	
	public Appliance checkOut(String itemNumber) {
		
	}
	
	public Appliance[] findByBrand(String brand) {
		
	}
	
	public List<Appliance> findByCriteria(Map<String, Object> criteria) {
		List<Appliance> matchingAppliances = new ArrayList<>();
		
		for (Appliance appliance : appliances) {
            if (appliance.matchesCriteria(criteria)) {
                matchingAppliances.add(appliance);
            }
        }

        return matchingAppliances;
	}
	
	public Appliance[] getRandom(int count) {
		
	}
	
	public bool saveToFile() {
		
	}
}
