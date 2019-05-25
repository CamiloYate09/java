/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.sql.Date;

/**
 *
 * @author defaultuser0
 */
public class Usuario {
    
    
    String nombre;
    String primerApellido;
    String segundoApellido;
    int documento;
    String correo;
    String contrasena;
    int celular;
    Date fecha;
    String tipodoc;
    /****************************************************************/
    /****************************************************************/
    /*Crea el cosntructor*/
    public Usuario(String nombre, String Apellido1, String Apellido2,int documento,String correo, String contraseña,int celular, Date fecha,String tipodoc) {
        
        this.nombre = nombre;
        this.primerApellido = Apellido1;
        this.segundoApellido = Apellido2;
        this.documento = documento;
        this.correo = correo;
        this.contrasena = contraseña;
        this.celular = celular;
        this.fecha = fecha;
        this.tipodoc = tipodoc;
    }
    /****************************************************************/
    /****************************************************************/
    /*Genera los Getters y Setters*/
    
  

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

   

    

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
     public String getTipododc() {
        return tipodoc;
    }

    public void setTipodoc(Date fecha) {
        this.tipodoc = tipodoc;
    }
 
 
    
}
