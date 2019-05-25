/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Usuario.Usuario;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Statement;


/**
 *
 * @author defaultuser0
 */

@WebServlet(urlPatterns = {"/BorrarRegistro"})
public class BorrarRegistro extends HttpServlet{
    
     Consultas consul=new Consultas();
        Conexion con=new Conexion();
        
        /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*************************************************************************************/
            /*************************************************************************************/
            /* Llama los terminos ingresados en FactirCliente.jsp */ 
            String doc= request.getParameter("documento"); 
            String corr= request.getParameter("correo"); 
            String contra = request.getParameter("contraseña"); 
            
            DecimalFormat tf = new DecimalFormat("#.00");
            /****************************************************************/
            /****************************************************************/
            /*Imprime una factura en un codigo html */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BorrarRegistro</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='EstiloFactura.css'/>"); //llama la hoja de estilos
            out.println("</head>");
            out.println("<body class=\"twoColLiqLtHdr\">");               
            out.println("<div id='container'>"); //Contenedor
            out.println("<div id='header'>"); //Encabezado
            out.println("<h1>BorrarRegistro</h1>"); 
            out.println("</div>"); 
            out.println("<div id='sidebar1'>"); 
            try {
                if(con.getConnection()!=null){     //comprueba la conexion        
                String aux="";
                String aux2="";
                aux=consul.DatoConsulta(1, "select Usuario_ID from usuarios where usuarios.Documento='"+doc+"' and usuarios.CorreoElectronico='"+corr+"' and usuarios.Contraseña='"+contra+"';");
                //Busca nuestro cliente  en la base de datos
                    if(aux!=""){  
                        /*Asigna a nuestras variable elementos de la base de datos*/
                         
                        consul.ejecutar("delete from usuarios where Usuario_ID='"+aux+"';");
                        out.println("<center><h1>Se pudo Eliminar correctamente"+ "</h1></center>");

                            
                        /*Llama la clase consumo de la base de datos y la asigna a las variables correspondientes*/
                               
                        
                            }
                   else{//indica que el usuario no existe 
                    out.println("<center><h1>Datos incorrectos"+ "</h1></center>");
                    }
                            /*************************************************************************************/
                            /*************************************************************************************/
                            /*Muestra en pantalla la factura*/
                }
                else /*conexion no correcat*/{ //indica que no se pudo realizar la conexion
                    out.println("<center><h1>Ha ocurrido un error, intente mas tarde"+ "</h1></center>");
            }   
            } catch (Exception e) {
                out.println("Usuario no registrado");
            }
            
            out.println("</br>");  
            out.println("<center><a class='boton' type='submit' href='index.html'  alling='rigth'> Regresar</a></center>"); //boton que nos lleva a index.html
            out.println("<td><input  class='boton' type='submit' ></td>");
            out.println("</div>");             
            out.println("<br class='clearfloat' /><!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->"); 
            out.println("<div id='footer'>"); 
            out.println(" <h6> ¿Esta seguro de borrar sus datos?  </h6> "); 
            out.println(" <h6> Gracias por la oportunidad  </h6> "); 
            out.println(" </div><!-- end #footer -->"); 
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   try {
                       processRequest(request, response);
                   } catch (SQLException ex) {
                       Logger.getLogger(Modificacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   try {
                       processRequest(request, response);
                   } catch (SQLException ex) {
                       Logger.getLogger(Modificacion.class.getName()).log(Level.SEVERE, null, ex);
                   }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
