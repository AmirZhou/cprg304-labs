package model;

import java.util.Map;

public class Microwave extends Appliance 
{
	private final double capacity;
	public double capacity()
	{
		return this.capacity;
	}
	
	private final String roomType;
	public String roomType()
	{
		return this.roomType;
	}
	
	private Microwave(Builder builder)
	{
		super(builder);
		this.capacity = builder.capacity;
		this.roomType = builder.roomType;
	}
	
	public static class Builder extends Appliance.Builder<Builder> 
	{
		private double capacity;
		private String roomType;
		
		public Microwave build()
		{
			return new Microwave(this);
		}
		
		public Builder capacity(double capacity)
		{
			this.capacity = capacity;
			return self();
		}
		
		public Builder roomType(String roomType)
		{
			this.roomType = roomType;
			return self();
		}
	}
	
	@Override
    public boolean matchesCriteria(Map<String, Object> criteria) {
		if (criteria.containsKey("roomType")) {
            String roomType = (String) criteria.get("roomType");
            if (this.roomType != roomType) {
                return false;
            }
        }
		return true;
	}
	
	@Override
    public String toString() {
        return super.toString() +
               "\nCapacity: " + capacity +
               "\nRoom Type: " + (roomType.equalsIgnoreCase("K") ? "Kitchen" : "Worksite");
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
                String.valueOf(capacity),
                roomType);
    }
	
}
