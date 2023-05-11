package demostraciones;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
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
          prueba5();
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
    
    public void prueba4(){
        Stage w1 = new Stage();
        w1.setX(100);
        w1.setY(100);
        w1.setWidth(500);
        w1.setHeight(300);
        Button boton = new Button("Aceptar");
        ColorPicker cp = new ColorPicker();
        DatePicker dp = new DatePicker(LocalDate.now());
        VBox layout = new VBox(50);
        layout.getChildren().add(boton);
        layout.getChildren().add(cp);
        layout.getChildren().add(dp);
        
        Scene escena = new Scene(layout);
        w1.setScene(escena);
        w1.show();
    }
    /**
     * Eventos
     */
    public void prueba5(){
         Stage w1 = new Stage();
        w1.setX(100);
        w1.setY(100);
        w1.setWidth(500);
        w1.setHeight(300);
        Button boton = new Button("Aceptar");
        ColorPicker cp = new ColorPicker();
        Label etiqueta = new Label("Nada que hacer");
        
        VBox layout = new VBox(50);
        
        
        
        layout.getChildren().add(boton);
        layout.getChildren().add(cp);
        layout.getChildren().add(etiqueta);
        
        
        Scene escena = new Scene(layout);
        w1.setScene(escena);
        EventHandler<ActionEvent> e = new EventHandler() {
             @Override
             public void handle(Event event) {
                 escena.setFill(cp.getValue());
                 System.out.println(cp.getValue());
                 layout.setBackground(
                         new Background(
                         new BackgroundFill(cp.getValue(),
                                 null,null)));
             }
        }; 
        boton.setOnAction(e);
        w1.show();
    }
    
    
    public static void main(String[] args) {
        launch();
    }
    
    
}
