<%-- 
    Document   : Registro
    Created on : 18/11/2017, 04:12:45 PM
    Author     : Edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="EstiloRegistro.css"/><!-- LLama la hoja de estilos -->
    
    </head>
<body class="twoColLiqLtHdr">
    <div id="container"><!-- Contenedor -->
        <div id="header"><!--Genera un encabezado -->
            <center><h1>Verificar Datos</h1></center><!-- crea la seccion busqueda del menu -->
        </div><!-- end #header -->
        <div id="sidebar1">
            
            <form action="ConsultaFC"><!-- Genera el cambio de pagina y da la orden de enviar los datos ingresdos -->
                <center><H2> Verificar Datos Usuario  </h2></center>
                <center><table>
                     <tr>
                        <td><label>Documento</label></td>
                        <td><input title="10185502" pattern="^[0-9]*$" id="Documento" name="documento" type="text" length="100"required/></td><!-- Escribe y guarda el nombre -->

                     <tr>
                         <td><label>Correo electronico </label></td><!--Escribe y guarda el correo electronico  -->
                         <td><input title="correo@mail.com" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" id="Correo" name="correo" type="text" length="100"required/></td>
                    </tr>
                     <tr>
                         <td><label>Contraseña </label></td><!--Escribe y guarda la contraseña  -->
                         <td><input TYPE="password" id="Contraseña" name="contraseña" type="text" length="100"required/></td>
                        
                    </tr>
                    <tr>
                        <td><input class="boton" type="submit" ></td> <!-- Boton que nos envia a ConsultaFC
                                                                      .java -->
                     </tr>
                      
                </table></center>
                </br></br>
                <center><h6> Ingrese para verificar sus datos</h6> </center>
            </form>
            <a class="boton" type="submit" href="index.html""> Regresar</a><!-- Boton que nos envia a Index.html -->
        </div><!-- end #mainContent -->
        <br class="clearfloat" /><!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
        <div id="footer">
               
            <h6> Gracias por la oportunidad </h6> 
        </div><!-- end #footer -->
    </div><!-- end #container -->
</body>
</html>

