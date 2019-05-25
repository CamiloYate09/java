/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.SimpleDateFormat;
import BaseDatos.Conexion;
import BaseDatos.Insertar_Usuario;
import BaseDatos.Consultas;
import Usuario.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat; 
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import Usuario.Usuario;

/**
 *
 * @author defaultuser0
 */
public class Pruebas {
    
    public static void main(String[] args) throws SQLException{
    
     Conexion c= new Conexion();//verifica la conexión con la base de datos
    Insertar_Usuario insertar = new Insertar_Usuario();
    Consultas con=new Consultas();
    
    String aux="";
    String resultconsulta=null;
           //resultconsulta= con.DatoConsulta(1,"select Tipo_ID from tipo_documentos where tipo_documentos.Nombre_Tipo = '"+aux+"'");
        // String nombreNuevo="farruco";
         //String ax="22";
           //con.ejecutar("UPDATE usuarios SET usuarios.Nombre= '"+nombreNuevo+"' WHERE usuarios.Usuario_ID= '"+ax+"';");

           
           resultconsulta=con.DatoConsulta(1,"select * from usuarios;");
            con.ejecutar("delete from usuarios where Usuario_ID = 2;");
    String[] dat =new String[9]; //arreglo para pasar los datos de prueba para insertar un clientes
      
      /*datos para pasar un nuevo cliente a la base de datos */
      dat[0]="sonia";
      dat[1]="Cardona";
      dat[2]="Suarez";
      dat[3]="109341212";
      dat[4]="yiango1995@gmail.com";
      dat[5]="sibmac92";
      dat[6]="31170242";
      dat[7]="2017-03-24";
      dat[8]=resultconsulta;
     int au=1;
     //String primerApellido =con.DatoConsulta(3,"select * from usuarios where usuarios.Usuario_ID="+au+"");
     
    aux=con.DatoConsulta(1, "select Usuario_ID from usuarios where usuarios.Documento= 153 and usuarios.CorreoElectronico= '123@ail.com' and usuarios.Contraseña= 123;");
  
       // new Principal().setVisible(true);
       
      
        if(c.getConnection()!=null){//verifica que la conexión con la base de datos sea correcta
        //  ResultSet a=null;
         //a=insertar.consultar("SELECT * FROM clientes;");
         
        
         
         System.out.println("la conexion es Correcta"+" "+aux);
        //insertar.InsertarUsuario(dat);

          
       }
       else//indica que la conexión con la base de datos no es correcta
       {
           System.out.println("la conexion es incorrecta");
           
       }
      
       
    

 }

}