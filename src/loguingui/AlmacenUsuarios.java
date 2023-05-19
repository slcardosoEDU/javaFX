package loguingui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manejar la persistencia de usuarios.
 * @author alumno
 */
public class AlmacenUsuarios {
    
    private final static String ALMACEN_PATH = "recursos/users.db.csv";
    /**
     * Devuelve todos los usuarios almacenados.
     * @return lista con todos los usuarios almacenados.
     */
    public static List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList();
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(ALMACEN_PATH));
            String linea;
            //La primera linea es la cabecera.
            br.readLine();
            while((linea=br.readLine())!= null){
                usuarios.add(new Usuario(linea));
            }
        } catch (Exception  ex ) {
           
        }
         try{
                br.close();
            }catch(IOException e){
                System.err.println(e);
            }
        
        return usuarios;
    }
    
    /**
     * Obtiene el usuario cuyo nombre de usuario se userName.
     * @param userName nombre del usuario.
     * @return usuario o null si no existe.
     */
    public static Usuario getUsuarioByUserName(String userName){
        Usuario user  = null;
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(ALMACEN_PATH));
            String linea;
            //La primera linea es la cabecera.
            br.readLine();
            while((linea=br.readLine())!= null){
                if(linea.startsWith(userName)){
                    user = new Usuario(linea);
                }
            }
        } catch (Exception  ex ) {
           
        }
         try{
                br.close();
            }catch(IOException e){
                System.err.println(e);
            }
        return user;
    }
    
    
}
