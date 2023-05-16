package loguingui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class Principal extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new LoguinStage();
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
