package service;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Manages appliances, including loading, searching, and persisting data.
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Functionality:
 * - Load appliances from a file.
 * - Search appliances by brand or criteria.
 * - Retrieve random appliances.
 * - Save appliances back to the file.
 * 
 * Injected Dependencies:
 * - FileHandler (for file operations).
 * - ApplianceParser (to parse appliance data).
 */


public class ApplianceService {
	private final FileHandler fileHandler;
	private final ApplianceParser parser;
	private final List<Appliance> appliances;
	
	public ApplianceService(FileHandler fileHandler, ApplianceParser parser) {
		this.fileHandler = fileHandler;
		this.parser = parser;
		this.appliances = new ArrayList<>();
		
		try {
            loadAppliance();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load appliances: " + e.getMessage(), e);
        }
	}
	
	// Loads appliances from the file
	public boolean loadAppliance() throws IOException {
		List<String> lines = fileHandler.getStrings();
		List<Appliance> parsedAppliances = parser.parseAppliance(lines);
		appliances.clear();
		appliances.addAll(parsedAppliances);
		return true;
	}
	
	// Retrieves an appliance by item number
	public Appliance checkOut(String itemNumber) {
	    for (Appliance appliance : appliances) {
	        if (appliance.itemNumber().equals(itemNumber)) {
	            return appliance; // Return the actual reference
	        }
	    }
	    return null; // Return null if not found
	}
	
	// Searches appliances by brand
	public List<Appliance> findByBrand(String brand) {
		List<Appliance> results = new ArrayList<>();
		
		for (Appliance appliance : appliances) {
			if(appliance.brand().equalsIgnoreCase(brand)) {
				results.add(appliance);
			}
		}
		return results;
	}
	
	// Searches appliances by type and criteria
	public List<Appliance> findByType(int type, Map<String, Object> criteria) {
		List<Appliance> result = new ArrayList<>();
		for (Appliance appliance: appliances) {
			if (applianceTypeMatches(type, appliance) && appliance.matchesCriteria(criteria)) {
				result.add(appliance);
			}
		}
		return result;
	}
	
	private boolean applianceTypeMatches(int type, Appliance appliance) {
		return switch (type) {
			case 1 -> appliance instanceof Refrigerator;
			case 2 -> appliance instanceof Vacuum;
			case 3 -> appliance instanceof Microwave;
			case 4 -> appliance instanceof Dishwasher;
			default -> false;
		};
	}
	
	// Retrieves random appliances
	public List<Appliance> getRandom(int count) {
		if (count <= 0 || count > appliances.size()) {
			throw new IllegalArgumentException("Invalid Count: " + count);
		}
		List<Appliance> shuffled = new ArrayList<>(appliances);
		Collections.shuffle(shuffled);
		return shuffled.subList(0, count);
	}
	
	// Saves appliances back to the file
	public boolean saveToFile() {
		List<String> applianceStrings = new ArrayList<>();
		for (Appliance appliance: appliances) {
			applianceStrings.add(appliance.toFileFormat());
		}
		
		try {
			fileHandler.storeStrings(applianceStrings);
			return true;
		} catch (IOException e) {
			System.err.println("Failed to save appliances: " + e.getMessage());
            return false;
		}
	}
	
}
