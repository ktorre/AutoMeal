import java.util.ArrayList;

public class Food {
	private String              name;
	private double              servingSize;
	private double              servings;
	private double              calories;
	private double              fat;
	private double              carbs;
	private double              protein;
	private String              type;
	private ArrayList< String > tags;
	
	public Food( String name, double servingSize, String type ) {
		this( new FoodBuilder( name, servingSize, type ) );
	}
	
	// Builder Constructor
	public Food( FoodBuilder builder ) {
		name = builder.name;
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		carbs = builder.carbs;
		protein = builder.protein;
		type = builder.type;
		tags = new ArrayList<>( 3 );
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public double getCalories() {
		return calories;
	}
	
	public double getFat() {
		return fat;
	}
	
	public double getCarbs() {
		return carbs;
	}
	
	public double getProtein() {
		return protein;
	}
	
	public String getType() {
		return type;
	}
	
	public String[] getTags() {
		return ( String[] ) tags.toArray();
	}
	
	// Setters
	public Food addTag( String tag ) {
		// Returns "this" to allow for method chaining
		tags.add( tag );
		return this;
	}
	
	// Output
	private String nutritionOutputFormatter( String text, double amount ) {
		// Format nutrition strings
		return String.format( "\n  |-%24s:\t%.1f", text, amount );
	}
	
	private String outputNutrition() {
		// Split up the output of the nutrition cause it's long
		String output = "";
		output += nutritionOutputFormatter( "Serving size", servingSize );
		output += " " + type;
		if ( servings > 1 ) output += nutritionOutputFormatter( "Servings per Container", servings );
		output += nutritionOutputFormatter( "Calories", calories );
		output += nutritionOutputFormatter( "Fat", fat );
		output += nutritionOutputFormatter( "Carbs", carbs );
		output += nutritionOutputFormatter( "Protein", protein );
		output += "\n";
		return output;
	}
	
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append( "> " ).append( name );
		output.append( outputNutrition() );
		output.append( "Tags: " );
		if ( tags.isEmpty() ) {
			output.append( "N/A" );
		} else {
			for ( int i = 0; i < tags.size(); i++ ) {
				output.append( tags.get( i ) );
				if ( i != ( tags.size() - 1 ) ) output.append( ", " );
			}
		}
		return output.toString();
	}
}

class FoodBuilder {
	
	// Required attributes
	final String name;
	final double servingSize;
	final String type;
	
	// Default value attributes
	double servings = 1;
	double calories = 0;
	double fat      = 0;
	double carbs    = 0;
	double protein  = 0;
	
	FoodBuilder( String name, double servingSize, String type ) {
		this.name = name;
		this.servingSize = servingSize;
		this.type = type;
	}
	
	public FoodBuilder servings( double amount ) {
		servings = amount;
		return this;
	}
	
	public FoodBuilder calories( double amount ) {
		calories = amount;
		return this;
	}
	
	public FoodBuilder fat( double amount ) {
		fat = amount;
		return this;
	}
	
	public FoodBuilder carbs( double amount ) {
		carbs = amount;
		return this;
	}
	
	public FoodBuilder protein( double amount ) {
		protein = amount;
		return this;
	}
	
	public Food build() {
		return new Food( this );
	}
}
