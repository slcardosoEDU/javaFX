package demostraciones;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class MiApp extends Application{

    @Override
    public void start(Stage w1) throws Exception {
        prueba1(w1);
    }
    
    public void prueba1(Stage w1){
        w1.setTitle("Ventana 1");
        w1.setX(500);
        w1.setY(0);
        w1.setWidth(500);
        w1.setHeight(200);
        w1.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    
}
