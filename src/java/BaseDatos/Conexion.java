
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * CONEXION A LA BASE DE DATOS
 *
 * @author Edwar
 */
public class Conexion {
    
     /****************************************************************/
    /****************************************************************/
    /*Atributos que localiza y generan la conexión con la base de datos*/
    private String username = "root";//nombre de la conexión mysql
    private String password = "root";// contraseña de la base de datos
    private String hostname = "127.0.0.1"; //"localhost:8080";
    private String port = "3311"; //puerto de mysql
    private String database = "actividad"; // el nombre de la base de datos 
    private String classname = "com.mysql.jdbc.Driver"; // el diver de conexion de mysql 
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
   private Connection conn;

    /****************************************************************/
    /****************************************************************/
    /*Función para generar la conexión con la base de datos  */
    public Conexion() {

        try {//la conexión es exitosa
            Class.forName(classname);
            conn = DriverManager.getConnection(url, username, password);
           

        } catch (Exception e) {//no se pudo realizar la conexión 

            System.err.println(e.getMessage());
            
           
        }

    }
    /****************************************************************/
    /****************************************************************/
    /*Retorna si la conexión es correcta */
    public Connection getConnection() {
        return this.conn;
    }
    


    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
