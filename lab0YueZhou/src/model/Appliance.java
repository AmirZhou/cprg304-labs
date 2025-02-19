package model;

import java.util.Map;

/**
 * Abstract superclass representing a general appliance with common attributes.
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Key Features:
 * - Encapsulates shared properties and behaviors of appliances.
 * - Provides a Builder pattern for easy and extensible construction.
 * - Abstract methods for subclass-specific behaviors (e.g., matching criteria, file format).
 * - Common utility methods for managing appliance data (e.g., checkout, formatting).
 * 
 * Subclasses:
 * - Refrigerator, Vacuum, Microwave, Dishwasher.
 */

public abstract class Appliance {
	
	// Shared attributes across all appliances
	private final String itemNumber;
	private final String brand;
	private final int wattage;
	private final String color;
	private double price;
	private int quantity;
	
	// Constructor for initializing attributes using the Builder
	protected Appliance(Builder<?> builder) {
		this.itemNumber = builder.itemNumber;
		this.brand = builder.brand;
		this.wattage = builder.wattage;
		this.color = builder.color;
		this.price = builder.price;
		this.quantity = builder.quantity;
	}
	
	/**
     * Abstract Builder class to facilitate the creation of Appliance objects.
     * 
     * @param <T> Concrete Builder type for chaining.
     */
 	public abstract static class Builder<T extends Builder<T>> {
		private String itemNumber;
        private String brand;
        private int wattage;
        private String color;
        private int quantity;
        private double price;
        
        public abstract Appliance build();
        
        @SuppressWarnings("unchecked")
        protected T self() {
        	return (T) this;
        }
        
        public T itemNumber(String itemNumber) {
            this.itemNumber = itemNumber;
            return self();
        }
        
        public T brand(String brand) {
        	this.brand = brand;
        	return self();
        }
        
        public T wattage(int wattage) {
        	this.wattage = wattage;
        	return self();
        }
        
        public T color(String color) {
        	this.color = color;
        	return self();
        }
        
        public T quantity(int quantity) {
            this.quantity = quantity;
            return self();
        }

        public T price(double price) {
            this.price = price;
            return self();
        }
	}
 	
 	public void checkOut() {
		if (this.quantity >= 1) {			
			this.quantity -= 1;
		}
    }
	
 	// Getters and Setters
	public String itemNumber() {
		return itemNumber;
	}
	
	public String brand() {
		return brand;
	}
	
	
	public int quantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int wattage() {
		return wattage;
	}
	
	public String color() {
		return color;
	}
	
	public void setPrice(double price) {
        this.price = price;
    }
	
	public double price() {
		return price;
	}
	
	
	/**
     * Abstract method for matching criteria (implemented by subclasses).
     * 
     * @param criteria A map of keys and values to match.
     * @return True if the appliance matches the given criteria.
     */
	public abstract boolean matchesCriteria(Map<String, Object> criteria);
	
	@Override
    public String toString() {
        return "Item Number: " + itemNumber +
               "\nBrand: " + brand +
               "\nQuantity: " + quantity +
               "\nWattage: " + wattage +
               "\nColor: " + color +
               "\nPrice: " + price;
    }
	
	
	/**
     * Abstract method to format appliance data for saving to a file.
     * 
     * @return A string representation suitable for file storage.
     */
	public abstract String toFileFormat();
}
