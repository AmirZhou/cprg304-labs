package model;

import java.util.Map;

public class Vacuum extends Appliance
{
	private final String grade;
	public String grade()
	{
		return this.grade;
	}
	
	private final int batteryVoltage;
	public int batteryVoltage()
	{
		return this.batteryVoltage;
	}
	
	private Vacuum(Builder builder)
	{
		super(builder);
		this.grade = builder.grade;
		this.batteryVoltage = builder.batteryVoltage;
	}
	
	public static class Builder extends Appliance.Builder<Builder> 
	{
		private String grade;
		private int batteryVoltage;
		
		public Vacuum build()
		{
			return new Vacuum(this);
		}
		
		public Builder grade(String grade)
		{
			this.grade = grade;
			return self();
		}
		
		public Builder batteryVoltage(int batteryVoltage)
		{
			this.batteryVoltage = batteryVoltage;
			return self();
		}
	}
	
	public boolean matchesCriteria(Map<String, Object> criteria) {
		if (criteria.containsKey("batteryVotage")) {
            int votage = (int) criteria.get("batteryVoltage");
            if (this.batteryVoltage != votage) {
                return false;
            }
        }
		return true;
	}
	
	@Override
	public String toString()
	{
		return "text";
	}
}
