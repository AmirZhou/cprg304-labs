package model;

import java.util.Map;

public class Refrigerator extends Appliance {
	
	private final int numberOfDoors;
	public int numberOfDoors() {
		return numberOfDoors;
	}
	
	private final double height;
	public double height() {
		return height;
	}
	
	private final double width;
    public double width() {
        return width;
    }
    
	private Refrigerator(Builder builder) {
		super(builder);
		this.numberOfDoors = builder.numberOfDoors;
		this.height = builder.height;
		this.width = builder.width;
	}
	
	public static class Builder extends Appliance.Builder<Builder> {
		
		private int numberOfDoors;
		private double height;
		private double width;
		
		public Refrigerator build() 
		{
            return new Refrigerator(this);
        }
		
		public Builder numberOfDoors(int numberOfDoors)
		{
			this.numberOfDoors = numberOfDoors;
			return self();
		}
		
		public Builder height(double height)
		{
			this.height = height;
			return self();
		}
		
		public Builder width(double width)
		{
			this.width = width;
			return self();
		}
	}
	
	@Override
    public boolean matchesCriteria(Map<String, Object> criteria) {
		if (criteria.containsKey("numberOfDoors")) {
            int doors = (int) criteria.get("numberOfDoors");
            if (this.numberOfDoors != doors) {
                return false;
            }
        }
		return true;
	}
	
	@Override
    public String toString() {
        return super.toString() +
               "\nNumber of Doors: " + numberOfDoors +
               "\nHeight: " + height +
               "\nWidth: " + width;
    }
	
	@Override
    public String toFileFormat() {
        return String.join(";", 
                itemNumber(), 
                brand(), 
                String.valueOf(quantity()), 
                String.valueOf(wattage()), 
                color(), 
                String.valueOf(price()), 
                String.valueOf(numberOfDoors), 
                String.valueOf(height), 
                String.valueOf(width));
    }
}
