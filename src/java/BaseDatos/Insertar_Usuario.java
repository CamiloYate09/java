/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author defaultuser0
 */
public class Insertar_Usuario {
    
    
    Conexion  conect=new Conexion();//llama la conexión a la base de datos 
    
    /*Funcion que realiza la insercion de cada cliente a la base de datos*/
    public int InsertarUsuario(String[] datos) throws SQLException{
        int filasafectadas=0;
        
         try{
             Connection con=conect.getConnection(); //llama la conexión con la base de datos
             Statement SentenciaInsert= con.createStatement();
             //sentencia que llama la función para insertar un usuario en la base de datos 
             filasafectadas=SentenciaInsert.executeUpdate("INSERT INTO usuarios (Nombre,Apellido,Apellido2,Documento,CorreoElectronico,Contraseña,NumeroCelular,FechaRegistro,Tipo_ID) VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[4]+"','"+datos[5]+"','"+datos[6]+"','"+datos[7]+"','"+datos[8]+"')");
             System.out.println("Registro almacenado, correctamente");//imprime que el cliente fue insertado correctamente
         } catch(Exception e)//excepcion en la inserción de un nuevo cliente
         {
               System.err.println(e.getMessage());
               System.out.print("no se ha podido insertar");
         }
        return filasafectadas;//retorna la variable en la cual se inserta un nuevo cliente
    }

}
