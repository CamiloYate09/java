/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;


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

@WebServlet(urlPatterns = {"/Registrar"})
public class Registrar_Usuario extends HttpServlet {
    
    
    
     Consultas con=new Consultas();
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
        Conexion c= new Conexion();
        String[] dat=new String[9];
        
        Insertar_Usuario insertar=new Insertar_Usuario();
        Date fecha = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            
            String fe = "";
           ;
        try (PrintWriter out = response.getWriter()) { 
            
            
            
            
            String resultconsulta=null;
          String aux=request.getParameter("tipodocumento");
            dat[0]= request.getParameter("nombre");
            dat[1] = request.getParameter("apellido1");
            dat[2] = request.getParameter("apellido2");
            dat[3] = request.getParameter("documento");
            dat[4] = request.getParameter("correo");
            dat[5] = request.getParameter("contraseña");
            dat[6]=request.getParameter("celular"); 
            dat[7]=date.format(fecha);
            
           resultconsulta= con.DatoConsulta(1,"select Tipo_ID from tipo_documentos where tipo_documentos.Nombre_Tipo = '"+aux+"'");
            dat[8] = resultconsulta;
           
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrar</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='EstiloRegistro.css'/>"); 
            out.println("</head>");
            out.println("<body class=\"twoColLiqLtHdr\">");               
            out.println("<div id='container'>"); 
            out.println("<div id='header'>"); 
            out.println("<h1>Mi factura.com</h1>"); 
            out.println("</div>"); 
            out.println("<div id='sidebar1'>");
            
            
   if(c.getConnection()!=null ){
       
               insertar.InsertarUsuario(dat);
                /*tienes que  poner el codigo para enviar los datos de arriba a la base de datos*/
                  out.println("<center><h1>Señor ha sido registrado correctamente</h1></center>");
            }else if(c.getConnection()==null)/*conexion no correcat*/{
                    out.println("<center><h1>Señor  ha ocurrido un error, intente mas tarde"+ "</h1></center>");
            }   
            out.println("<center><a class='boton' type='submit' href='index.html'  alling='rigth'> Regresar</a></center>"); 
            out.println("</div>");             
            out.println("<br class='clearfloat' /><!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->"); 
            out.println("<div id='footer'>"); 
            out.println(" <h6> Regitro  </h6> "); 
            out.println(" <h6> Gracias  </h6> "); 
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
            Logger.getLogger(Registrar_Usuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Registrar_Usuario.class.getName()).log(Level.SEVERE, null, ex);
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

    private String toString(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    
    
   
}
