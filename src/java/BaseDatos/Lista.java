/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author defaultuser0
 */

@WebServlet(urlPatterns = {"/Lista"})
public class Lista extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        

        try (PrintWriter out = response.getWriter()) {
    /****************************************************************/
    /****************************************************************/
    /*Llama los datos de FacturaMensual.jsp y los agrega a atributos 
       de esta clase */

      
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lista</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='EstiloLista.css'/>"); //llama la hoja de estilos
            out.println("</head>");
            out.println("<body class=\"twoColLiqLtHdr\">");               
            out.println("<div id='container'>"); //Contenedor
            out.println("<div id='header'>");   //Encabezado
            out.println("<h1>Lista Usuarios</h1>"); 
            out.println("</div>"); 
            out.println("<div id='sidebar1'>"); //Contenido de la factura
  
            try {
            Conexion con= new Conexion();
            Consultas consul=new Consultas();
            int x;
            
            if(con.getConnection()!=null){     //comprueba la conexion
                
               x=Integer.parseInt(consul.DatoConsulta(1,"select count(*) from usuarios"));
                
                    if(x>=1){ //busca al usuario 
                            //tienes que hacer un metodo que llame a todas las facturas con esa fecha y con un for sumar todos los campos
                            
                            int i=1;
                            String fechaInicio="hola";
                            String nombre="";
                            String documento="";
                            String tipodocumento="";
                            String correo="";
                            String celular="";
                            String a="";
                            String b="";
                            String c="";
                            
                            
                            String ayudaI="";
                            
                            while(i<=x){
                                
                                ayudaI= String.valueOf(i);
                                     
                                
                                a=consul.DatoConsulta(2,"select * from usuarios where Usuario_ID='"+ayudaI+"';");
                                b=consul.DatoConsulta(3,"select * from usuarios where Usuario_ID='"+ayudaI+"';");
                                c=consul.DatoConsulta(4,"select * from usuarios where Usuario_ID='"+ayudaI+"';");
                                nombre=" "+a+" "+b+" "+c+" ";
                                
                                tipodocumento=consul.DatoConsulta(1,"SELECT Nombre_Tipo from usuarios,tipo_documentos where usuarios.Usuario_ID= '"+ayudaI+"' and  usuarios.Tipo_ID= tipo_documentos.Tipo_ID;");
                                
                                documento=consul.DatoConsulta(5, "select * from usuarios where usuarios.Usuario_ID="+ayudaI+"");
                                correo=consul.DatoConsulta(6, "select * from usuarios where usuarios.Usuario_ID="+ayudaI+"");
                                celular=consul.DatoConsulta(8, "select * from usuarios where usuarios.Usuario_ID="+ayudaI+"");
                                
                                
                                out.println("<center><table border='1' sTYLE=\"table-layout:fixed\">");//crea un atabla para inprimir la factura
                            out.println("<tr>");
                                
                               out.println("<td class:'ed'>");
                                    out.println("<p> "+nombre+"</p>");
                                out.println("</td>");
                                out.println("<td  class:'ed'>");
                                    out.println("<p>"+tipodocumento+"</p>");//Fecha de incio de la solicitud
                                out.println("</td>");
                                out.println("<td class:'ed'>");
                                    out.println("<p>"+documento+"</p>");//Fecha de incio de la solicitud
                                out.println("</td>");
                                 out.println("<td class:'ed'>");
                                    out.println("<p>"+correo+"</p>");//Fecha de incio de la solicitud
                                out.println("</td> ");
                                out.println("<td class:'ed'>");
                                    out.println("<p>"+celular+"</p>");//Fecha de incio de la solicitud
                                out.println("</td>");
                            out.println("</tr>");
                        out.println("</table></center>");//Fin de la tabla 
                                
                                nombre="";
                                tipodocumento="";
                                documento="";
                                correo="";
                                celular="";
                                a="";
                                b="";
                                c="";
                                ayudaI="";
                                i++;
                            }
                      
                        /*************************************************************************************/
                        /*************************************************************************************/
                        /*Muestra en pantalla la factura*/ 
                        
                    }
            }
            } catch (Exception e) {
                out.println("<center><h1>No se encontro ningun resultado</h1></center>");
            }
            
            
            out.println("</br>");  
            out.println("<center><a class='boton' type='submit' href='index.html'  alling='rigth'> Regresar</a></center>"); //boton que envia a Index.html
            out.println("</div>");             
            out.println("<br class='clearfloat' /><!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->"); 
            out.println("<div id='footer'>"); 
           
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
        processRequest(request, response);
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
        processRequest(request, response);
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
