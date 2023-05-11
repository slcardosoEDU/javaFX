package demostraciones;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class EventosApp extends Application {
    
    public static void main(String[] args) {
        launch();
    }
    
    public void start(Stage w){
        //Nodos
        VBox vertical = new VBox(50);
        //vertical.setAlignment(Pos.CENTER);
        HBox horizontal = new HBox(50);
        Label texto = new Label("Introduce un numero");
        TextField input = new TextField();
        texto.setFont(Font.font(30));
        Rectangle r1 = 
                new Rectangle(500,500,Color.BROWN);
        Rectangle r2 = new Rectangle(500,500,Color.BLACK);
        vertical.getChildren().add(texto);
        vertical.getChildren().add(input);
   
        horizontal.getChildren().add(r1);
        horizontal.getChildren().add(r2);
        vertical.getChildren().add(horizontal);
        Scene escena = new Scene(vertical);
        escena.addEventFilter(KeyEvent.KEY_TYPED, e -> filtroNumeros(e));
        w.setScene(escena);
        
        r1.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> brillar(r1));
        r1.addEventHandler(MouseEvent.MOUSE_EXITED, e -> oscurecer(r1));
        r2.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> brillar(r2));
        r2.addEventHandler(MouseEvent.MOUSE_EXITED, e -> oscurecer(r2));
        w.show();
    }
    
    private void brillar(Rectangle r){
        Color actual = (Color)r.getFill();
        actual = actual.brighter();
        r.setFill(actual);
    }
    
    private void filtroNumeros(KeyEvent e){
        if(!Character.isDigit(e.getCharacter().charAt(0))){
            e.consume();
        }
    }
    
    private void oscurecer(Rectangle r){
        Color actual = (Color)r.getFill();
        actual = actual.darker();
        r.setFill(actual);
    }
}
