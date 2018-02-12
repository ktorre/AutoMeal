import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryGui extends Application {
	
	@Override
	public void start( Stage primaryStage ) throws IOException {
		
		Parent root = FXMLLoader.load( getClass().getResource( "client.fxml" ) );
		
		Scene main = new Scene( root, 400, 600 );
		primaryStage.setScene( main );
		primaryStage.show();
	}
}
