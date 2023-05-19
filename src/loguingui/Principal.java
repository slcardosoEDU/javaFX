package loguingui;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Punto de entrada a la aplicacion.
 * @author samuel loureiro cardoso  
 */
public class Principal extends Application{

    @Override
public void start(Stage primaryStage) throws Exception {
        primaryStage = new LoguinStage();
        primaryStage.show();
    }
    
    public static void main(String[] args) throws IOException {
       
        launch();
    }
    
}
