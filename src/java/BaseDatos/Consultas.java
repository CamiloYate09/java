/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author defaultuser0
 */
public class Consultas {
    
     Conexion con=new Conexion();//Inicializa la conexión a la base de datos
    Connection co=con.getConnection();//atributo que verifica si la conexión es exitosa
    String dato="";
    Statement st;
    /*realiza consultas a la base de datos recibiendo un espacio de  la columna y la sentencia sql*/
    public String DatoConsulta (int numcolumna,String sql){
        try {//indica si la consulta se pudo realizar corrrectamente
               
            this.st = co.createStatement();
             ResultSet re=st.executeQuery(sql);
             if(re.next())
             dato=re.getString(numcolumna);
        } catch (SQLException ex) {//indica si la consulta tiene una excepción
        
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.dato;//retorna el resultado de la consulta
        
    }
    
    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = co.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }        return true;
    }
    
}
