package loguingui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.stage.Stage;

/**
 *
 * @author alumno
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
        setLoguin();
        this.setWidth(500);
        this.setHeight(600);
        this.setMaximized(false);
        this.setResizable(false);
        
    }
    
    private void setLoguinSuccess(){
        principal = new VBox();
        principal.setBackground(Background.fill(Color.AZURE));
        principal.setPadding(new Insets(50,50,50,50));
        principal.setAlignment(Pos.CENTER);
        mensaje = new Label("Bienvenida/o!");
        mensaje.setFont(Font.font(50));
        mensaje.setTextFill(Color.CHOCOLATE);
        principal.getChildren().add(mensaje);
        setScene(new Scene(principal));
    }
    
    private void setLoguinFails(){
        principal = new VBox();
        //principal.setBackground(Background.fill(Color.BEIGE));
        principal.setPadding(new Insets(50,50,50,50));
        principal.setAlignment(Pos.CENTER);
        mensaje = new Label("Cuenta bloqueada");
        mensaje.setFont(Font.font(40));
        mensaje.setTextFill(Color.RED);
        principal.getChildren().add(mensaje);
        setScene(new Scene(principal));
    }
    
    private void setLoguin(){
        //Declaracion de elementos
        //Botones
        acceder = new Button("Acceder");
        registrarse = new Button("Registrarse");
        acceder.setFont(Font.font(18));
        registrarse.setFont(Font.font(18));
        botonera = new HBox(registrarse,acceder);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(50);
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
        //Titulo
        Label titulo = new Label("Acceso al sistema");
        titulo.setFont(Font.font(30));
        titulo.setBackground(Background.fill(Color.web("#E62A44")));
        titulo.setPadding(new Insets(10,10,10,10));
        titulo.setTextFill(Color.WHITE);
        //Mensaje error
        mensaje = new Label("Tras 3 intentos fallidos se bloquea la cuenta.");
        //mensaje.setTextFill(Color.RED);
        //Layout principal
        principal = new VBox(10);
        principal.setPadding(new Insets(50,100,30,100));
        principal.getChildren().addAll(titulo,userLbl,user,passLbl, pass,mensaje, botonera);
        
        //Ubicar controles
        principal.setMargin(titulo, new Insets(0,0,50,0));
        principal.setMargin(user,new Insets(0,0,30,0));
        principal.setMargin(mensaje,new Insets(0,0,50,0));
        setScene(new Scene(principal));
        setTitle("Login");
    }
    
   
    
    private void tryLoggin(){
        String aux = "123123";
        String user = "pepe";
        if(aux.equals(pass.getText())&&user.equals(this.user.getText())){
            setLoguinSuccess();
        }else{
            intentos--;
            if(intentos==0){
                setLoguinFails();
            }
            this.mensaje.setText("Login incorrecto. Te quedan "+intentos+" intentos.");
            this.mensaje.setTextFill(Color.RED);
            this.pass.clear();
        }
    }
    
    private void enableAcceder(){        
        if(pass.getText()!=null&&!pass.getText().trim().isEmpty()
                &&user.getText()!=null&&user.getText().trim().isEmpty()){
            acceder.setDisable(false);
        }else{
            acceder.setDisable(true);
        }
    }
    
    
    
}