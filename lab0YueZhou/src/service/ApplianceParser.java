package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses appliance data from raw strings into appliance objects.
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Functionality:
 * - Converts raw file lines into a list of appliances.
 * - Supports multiple appliance types (e.g., Refrigerator, Vacuum).
 */

public class ApplianceParser {
	
	// Parses lines into appliance objects
	public List<Appliance> parseAppliance(List<String> lines) {
		List<Appliance> appliances = new ArrayList<>();
		
		for (String line: lines) {
			String[] parts = line.split(";");
			int type = Integer.parseInt(parts[0].substring(0,1));
			
			Appliance appliance = switch (type) {
            case 1 -> new Refrigerator.Builder()
                    .itemNumber(parts[0])
                    .brand(parts[1])
                    .quantity(Integer.parseInt(parts[2]))
                    .wattage(Integer.parseInt(parts[3]))
                    .color(parts[4])
                    .price(Double.parseDouble(parts[5]))
                    .numberOfDoors(Integer.parseInt(parts[6]))
                    .height(Double.parseDouble(parts[7]))
                    .width(Double.parseDouble(parts[8]))
                    .build();
            case 2 -> new Vacuum.Builder()
                    .itemNumber(parts[0])
                    .brand(parts[1])
                    .quantity(Integer.parseInt(parts[2]))
                    .wattage(Integer.parseInt(parts[3]))
                    .color(parts[4])
                    .price(Double.parseDouble(parts[5]))
                    .grade(parts[6])
                    .batteryVoltage(Integer.parseInt(parts[7]))
                    .build();
            case 3 -> new Microwave.Builder()
                    .itemNumber(parts[0])
                    .brand(parts[1])
                    .quantity(Integer.parseInt(parts[2]))
                    .wattage(Integer.parseInt(parts[3]))
                    .color(parts[4])
                    .price(Double.parseDouble(parts[5]))
                    .capacity(Double.parseDouble(parts[6]))
                    .roomType(parts[7])
                    .build();
            case 4, 5 -> new Dishwasher.Builder()
                    .itemNumber(parts[0])
                    .brand(parts[1])
                    .quantity(Integer.parseInt(parts[2]))
                    .wattage(Integer.parseInt(parts[3]))
                    .color(parts[4])
                    .price(Double.parseDouble(parts[5]))
                    .feature(parts[6])
                    .soundRating(parts[7])
                    .build();
            default -> throw new IllegalArgumentException("Unknown appliance type: " + type);
			};
			appliances.add(appliance);
		}
		return appliances;
	}
}


