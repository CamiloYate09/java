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
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author defaultuser0
 */

@WebServlet(urlPatterns = {"/ConsultaFC"})
public class Modificacion extends HttpServlet {
    
    
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
            out.println("<title>Servlet Registrar</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='EstiloDatos.css'/>"); //llama la hoja de estilos
            out.println("</head>");
            out.println("<body class=\"twoColLiqLtHdr\">");               
            out.println("<div id='container'>"); //Contenedor
            out.println("<div id='header'>"); //Encabezado
            out.println("<center><h1>Datos Usuario</h1></center>"); 
            out.println("</div>"); 
            out.println("<div id='sidebar1'>"); 
            try {
                if(con.getConnection()!=null){     //comprueba la conexion        
                String aux="";
                aux=consul.DatoConsulta(1, "select * from usuarios where usuarios.Documento='"+doc+"' and usuarios.CorreoElectronico='"+corr+"' and usuarios.Contraseña='"+contra+"';");
                //Busca nuestro cliente  en la base de datos
                    if(aux!=""){  
                        /*Asigna a nuestras variable elementos de la base de datos*/
                        int idcliente = (int) 01 ;
                        String nombre = consul.DatoConsulta(2,"select * from usuarios where usuarios.Usuario_ID ="+aux+"");
                        String primerApellido =consul.DatoConsulta(3,"select * from usuarios where usuarios.Usuario_ID ="+aux+"");
                        String segundoApellido= consul.DatoConsulta(4,"select * from usuarios where usuarios.Usuario_ID ="+aux+"");
                        String tdocumento=consul.DatoConsulta(1,"SELECT Nombre_Tipo from usuarios,tipo_documentos where usuarios.Usuario_ID= "+aux+" and  usuarios.Tipo_ID= tipo_documentos.Tipo_ID;");
                        String a=consul.DatoConsulta(5,"select * from usuarios where usuarios.Usuario_ID="+aux+"");
                        String correo=consul.DatoConsulta(6,"select * from usuarios where usuarios.Usuario_ID="+aux+"");
                        String b=consul.DatoConsulta(8,"select * from usuarios where usuarios.Usuario_ID="+aux+"");
                        String contraseña=consul.DatoConsulta(7,"select * from usuarios where usuarios.Usuario_ID="+aux+"");
                        
                        
                        
                        int documento =Integer.parseInt(a);
                        int celular =Integer.parseInt(b);
                        Date fecha=  null;
                        
                        
                        
              
                       
                        Date h = null;
                        
                        Usuario usu=new Usuario(nombre,primerApellido,segundoApellido,documento,correo,contraseña,celular,fecha,tdocumento);
                       
                        /*Llama la clase consumo de la base de datos y la asigna a las variables correspondientes*/
                               
                            /*Crea la factura */
                            
                            /*************************************************************************************/
                            /*************************************************************************************/
                            /*Muestra en pantalla la factura*/ 
                            out.println("<center><table border='1' sTYLE=\"table-layout:fixed\">");//Inicio de la tabla
                                out.println("<tr>");
                                    out.println("<td height ='20'>");
                                        out.println("<p> Bienvenido</p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p></p>");
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Nombre </p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+usu.getNombre()+"</p>");//Imprime el nombre completo
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Primer Apellido </p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+usu.getPrimerApellido()+"</p>");//Imprime el documento
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Segundo Apellido </p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+usu.getSegundoApellido()+"</p>");//Imprime el cargo fijo
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Tipo Documento</p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+usu.getTipododc()+"</p>");//Imprime el estrato
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Documento </p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+(int)usu.getDocumento()+"</p>");//Imprime el costo del estrato
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Celular  </p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+(int)usu.getCelular()+"</p>");//Imprime las horas tv
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Correo Electrónico </p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+usu.getCorreo()+"</p>");//Imprime el valor por hora tv
                                    out.println("</td>");
                                out.println("</tr>");
                                out.println("<tr>");
                                    out.println("<td>");
                                        out.println("<p> Contraseña </p>");
                                    out.println("</td>");
                                    out.println("<td>");
                                        out.println("<p>"+usu.getContraseña()+"</p>");//Imprime los minuto telefono
                                    out.println("</td>");
                                out.println("</tr>");
                               
                                   
                            out.println("</table></center>");//Fin de la tabla
                        
                    } 
                    else{//indica que el usuario no existe 
                    out.println("<center><h1>Datos incorrectos"+ "</h1></center>");
                    }
            }else /*conexion no correcat*/{ //indica que no se pudo realizar la conexion
                    out.println("<center><h1>Ha ocurrido un error, intente mas tarde"+ "</h1></center>");
            }   
            } catch (Exception e) {
                out.println("Usuario no registrado");
            }
            
            out.println("</br>");  
            out.println("<center><a class='boton' type='submit' href='index.html'  alling='rigth'> Regresar</a></center>"); //boton que nos lleva a index.html
            
            out.println("</div>");             
            out.println("<br class='clearfloat' /><!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->"); 
            out.println("<div id='footer'>"); 
            out.println(" <h6> Sus datos se encuentran seguros  </h6> "); 
            
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


