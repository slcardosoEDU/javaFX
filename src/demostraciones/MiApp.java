package demostraciones;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class MiApp extends Application{

    @Override
    public void start(Stage w1) throws Exception {
//        prueba1(w1);
          prueba3();
    }
    
    public void prueba1(Stage w1){
        w1.setTitle("Ventana 1");
        w1.setX(500);
        w1.setY(0);
        w1.setWidth(500);
        w1.setHeight(200);
        w1.show();
    }
    
    
    public void prueba2(){
        Stage w1 = new Stage();
        Stage w2 = new Stage();
        Stage w3 = new Stage();
        Screen pantalla = Screen.getPrimary();
        Rectangle2D area = pantalla.getBounds();
        double ancho = area.getWidth();
        double alto = area.getHeight();
        
        w1.setTitle("Ventana 1");
        w2.setTitle("Ventana 2");
        w3.setTitle("Ventana 3");
        w1.setY(0.2*alto);
        w2.setY(0.2*alto);
        w3.setY(0.2*alto);
        
        w1.setX(0);
        final double anchoW = ancho/3;
        w2.setX(anchoW);
        w3.setX(2*anchoW);
        
        w1.setWidth(anchoW);
        w2.setWidth(anchoW);
        w3.setWidth(anchoW);
        
        w1.setHeight(alto*0.6);
        w2.setHeight(alto*0.6);
        w3.setHeight(alto*0.6);
        
        w1.show();
        w2.show();
        w3.show();
        
    }
    
    public void prueba3(){
        Stage w1 = new Stage();
        Stage w2 = new Stage();
        Stage w3 = new Stage();
        w1.setTitle("Ventana 1");
        w2.setTitle("Ventana 2");
        w3.setTitle("Ventana 3");
        w1.showAndWait();
        w2.show();
        w3.show();
    }
    
    
    public static void main(String[] args) {
        launch();
    }
    
    
}
