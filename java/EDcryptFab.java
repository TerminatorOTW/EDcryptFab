
// Developed by the "TERMINATOR OTW"

package edcryptfab.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EDcryptFab extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        Modal modal = new Modal();
        
        Scene scene = new Scene(modal.getMainActivity().mainLayout);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("EDCryptFab V1.1");
        primaryStage.show();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
