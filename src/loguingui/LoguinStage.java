package loguingui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.stage.Stage;

/**
 *
 * @author samuel loureiro cardoso
 */
public class LoguinStage extends Stage {

    private VBox principal;
    private HBox botonera;
    private Button acceder;
    private Button registrarse;
    private TextField user;
    private PasswordField pass;
    private Label mensaje;

    private int intentos;

    public LoguinStage() {
        intentos = 3;
        this.setWidth(500);
        this.setHeight(600);
        this.setMaximized(false);
        this.setResizable(false);
        setLoguin();

    }

    private void setLoguinSuccess() {
        principal = new VBox();
        principal.setBackground(Background.fill(Color.AZURE));
        principal.setPadding(new Insets(50, 50, 50, 50));
        principal.setAlignment(Pos.CENTER);
        mensaje = new Label("Bienvenida/o!");
        mensaje.setFont(Font.font(50));
        mensaje.setTextFill(Color.CHOCOLATE);
        principal.getChildren().add(mensaje);
        setScene(new Scene(principal));
        this.setWidth(500);
        this.setHeight(600);
        
    }

    private void setLoguinFails() {
        principal = new VBox();
        principal.setPadding(new Insets(50, 50, 50, 50));
        principal.setAlignment(Pos.CENTER);
        mensaje = new Label("Cuenta bloqueada");
        mensaje.setFont(Font.font(40));
        mensaje.setTextFill(Color.RED);
        principal.getChildren().add(mensaje);
        
        setScene(new Scene(principal));
        this.setWidth(500);
        this.setHeight(600);
    }

    private void setLoguin() {
        //Declaracion de elementos
        //Botones
        acceder = new Button("Acceder");
        registrarse = new Button("Registrarse");
        acceder.setFont(Font.font(18));
        registrarse.setFont(Font.font(18));
        botonera = new HBox(registrarse, acceder);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(50);
        //Logica de los botones
        acceder.setDisable(true);
        acceder.addEventHandler(ActionEvent.ACTION, e -> tryLoggin());
        //Vinculamos la tecla enter con el boton acceder
        acceder.setDefaultButton(true);
        //De momento deshabilitado
        registrarse.setDisable(true);
        //Usuario y contrasena
        user = new TextField();
        pass = new PasswordField();
        user.setFont(Font.font(18));
        pass.setFont(Font.font(18));
        Label userLbl = new Label("Usuario");
        userLbl.setLabelFor(user);
        userLbl.setFont(Font.font(18));
        Label passLbl = new Label("Contraseña");
        passLbl.setLabelFor(pass);
        passLbl.setFont(Font.font(18));
        //Logica de los texFields
        user.addEventHandler(KeyEvent.KEY_RELEASED, e -> enableAcceder());
        pass.addEventHandler(KeyEvent.KEY_RELEASED, e -> enableAcceder());
        //Titulo
        Label titulo = new Label("Acceso al sistema");
        titulo.setFont(Font.font(30));
        titulo.setBackground(Background.fill(Color.web("#E62A44")));
        titulo.setPadding(new Insets(10, 10, 10, 10));
        titulo.setTextFill(Color.WHITE);
        //Mensaje error
        mensaje = new Label("Tras 3 intentos fallidos se bloquea la cuenta.");
        //Layout principal
        principal = new VBox(10);
        principal.setPadding(new Insets(50, 100, 30, 100));
        principal.getChildren().addAll(titulo, userLbl, user, passLbl, pass, mensaje, botonera);

        //Ubicar controles
        principal.setMargin(titulo, new Insets(0, 0, 50, 0));
        principal.setMargin(user, new Insets(0, 0, 30, 0));
        principal.setMargin(mensaje, new Insets(0, 0, 50, 0));
        setScene(new Scene(principal));
        setTitle("Login");
    }

    /**
     * Comprueba si el usuario y la contraseña son correctos mostrando la escena
     * correspondiente.
     */
    private void tryLoggin() {
//        String aux = "123123";
//        String user = "pepe";
        Usuario u = AlmacenUsuarios.getUsuarioByUserName(user.getText());
        if(u!=null && u.testPassword(pass.getText())){
            setLoguinSuccess();

        } else {
            intentos--;
            if (intentos == 0) {
                setLoguinFails();
            } else {
                this.mensaje.setText("Login incorrecto. Te quedan " + intentos + " intentos.");
                this.mensaje.setTextFill(Color.RED);
                //Limpiamos el campo pass
                this.pass.clear();
                //Dejamos el cursor en el campo pass
                this.pass.requestFocus();
                //Hay que actualizar el estado del boton acceder
                enableAcceder();

            }

        }
    }

    /**
     * Comprueba que los campos contraseña y usuario no estén vacíos y habilita
     * el botón acceder.
     */
    private void enableAcceder() {
        if (pass.getText() != null && !pass.getText().trim().isEmpty()
                && user.getText() != null && !user.getText().trim().isEmpty()) {
            acceder.setDisable(false);
        } else {
            acceder.setDisable(true);
        }
    }
    
    

}
