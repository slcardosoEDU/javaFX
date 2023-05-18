package ejercicios.apuntes;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Actividad08 extends Application {
    final int FILAS = 8;
    final int COLUMNAS = 8;

    GridPane gridRect;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tablero");


        gridRect = new GridPane();
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++) {
                Rectangle rect = new Rectangle(50, 50, (i + j) % 2 != 0 ? Color.BROWN : Color.ANTIQUEWHITE);

                rect.setOnMouseEntered(e->brillar(rect));
                rect.setOnMouseExited(e->oscurecer(rect));
                gridRect.add(rect, j, i);
            }

        HBox hBox = new HBox(100, gridRect);
        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void brillar(Rectangle rect){
        Color actual = (Color)rect.getFill();
        System.out.println(actual.getHue()+","+actual.getSaturation()+","+actual.getBrightness()+","+actual.getOpacity());
        actual = actual.brighter();
        rect.setFill(actual);
    }
    
    private void oscurecer(Rectangle rect){
        Color actual = (Color)rect.getFill();
        actual = actual.darker();
        rect.setFill(actual);
    }

    public static void main(String[] args) {
        launch();
    }

}
