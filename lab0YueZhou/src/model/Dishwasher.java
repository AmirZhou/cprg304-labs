package model;

import java.util.Map;

public class Dishwasher extends Appliance 
{
	private final String feature;
	private final String soundRating;
	
	public String feature()
	{
		return this.feature;
	}
	
	public String soundRating()
	{
		return this.soundRating;
	}
	
	private Dishwasher(Builder builder)
	{
		super(builder);
		this.feature = builder.feature;
		this.soundRating = builder.soundRating;
	}
	
	public static class Builder extends Appliance.Builder<Builder> 
	{
		private String feature;
		private String soundRating;
		
		public Dishwasher build()
		{
			return new Dishwasher(this);
		}
		
		public Builder feature(String feature)
		{
			this.feature = feature;
			return self();
		}
		
		public Builder soundRating(String soundRating)
		{
			this.soundRating = soundRating;
			return self();
		}
	}
	
	@Override
    public boolean matchesCriteria(Map<String, Object> criteria) {
		if (criteria.containsKey("soundRating")) {
            String soundRating = (String) criteria.get("soundRating");
            if (!this.soundRating.equalsIgnoreCase(soundRating)) {
                return false;
            }
        }
		return true;
	}
	
	@Override
    public String toString() {
        return super.toString() +
               "\nFeature: " + feature +
               "\nSound Rating: " + soundRating;
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
                feature,
                soundRating);
    }
}
