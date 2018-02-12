import javafx.application.Application;

public class Main {
	
	public static void main( String[] args ) {
		if ( args.length > 0 ) {
			switch ( args[ 0 ] ) {
				case "--text":
				case "-t":
					launchTextGUI();
					break;
				case "--gui":
				case "-g":
					launchGui( args );
					break;
				default:
					System.out.println( "Invalid option" );
					break;
			}
		} else {
			launchGui( args );
		}
	}
	
	private static void launchGui( String[] args ) {
		System.out.println( "Launching visual gui..." );
		Application.launch( InventoryGui.class, args );
	}
	
	private static void launchTextGUI() {
		// Just for testing rn
		Food t = new Food( "NAME", 13, "TYPE" );
		System.out.println( t );
		
		Food f = new FoodBuilder( "Rockstar Recovery ( Lemonade )", 8, "oz" )
				         .servings( 2 )
				         .calories( 10 )
				         .carbs( 3 )
				         .build();
		f.addTag( "Energy" );
		f.addTag( "Drink" );
		System.out.println( f );
		
		Food f2 = new FoodBuilder( "Rockstar Recovery ( Orange )", 8, "oz" )
				          .servings( 2 )
				          .calories( 10 )
				          .carbs( 3 )
				          .build();
		f2.addTag( "Energy Drink" ).addTag( "Orange" );
		System.out.println( f2 );
		
		Food peanuts = new FoodBuilder( "Dry Roasted Peanuts (Winco)", 1, "oz" )
				               .calories( 110 )
				               .carbs( 4 )
				               .fat( 9.3 )
				               .protein( 4.7 )
				               .build();
		System.out.println( peanuts );
	}
}
