package loguingui;

import java.util.Objects;

/**
 *
 * @author samuel loureiro cardoso
 */
public class Usuario {
    private String userName;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String password;
    private boolean bloqueado;

    public Usuario(String nombre, String apellido1, String apellido2, String password, boolean bloqueado) {
        setUsername();
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.password = password;
        this.bloqueado = bloqueado;
    }

    public Usuario(String nombre, String apellido1, String apellido2, String password) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.password = password;
        this.bloqueado = false;
    }
    
    /**
     * Crea un usuario a partir de una linea en formato csv.
     * @param csvLine El formato de la linea es nombreUsr;contrasena;bloqueado;nombre;apellido1;apellido2

     */
    public Usuario(String csvLine){
        String[] campos = csvLine.split(";");
        this.userName = campos[0];
        this.password = campos[1];
        this.bloqueado = Boolean.parseBoolean(campos[2]);
        this.nombre = campos[3];
        this.apellido1 = campos[4];
        this.apellido2 = campos[5];
    }
    
    
    private void setUsername(){
        this.userName = nombre.charAt(0)+apellido1.substring(1, 4)+apellido2.substring(1, 4);
    }
    
    /**
     * Comprueeba si la contraseña coincide con la del usuario actual.
     * @param pass
     * @return 
     */
    public boolean testPassword(String pass){
        return pass!=null && pass.equals(this.password);
    }

    public String getUserName() {
        return userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        setUsername();
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
        setUsername();
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
        setUsername();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.userName, other.userName);
    }
    
    
    
    
}
