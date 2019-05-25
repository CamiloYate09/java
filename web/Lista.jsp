<%-- 
    Document   : Lista
    Created on : 29/07/2018, 12:29:56 PM
    Author     : Edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Lista</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="EstiloLista.css"/><!-- LLama la hoja de estilos -->
    
    </head>
<body class="twoColLiqLtHdr">
    <div id="container"><!-- Contenedor -->
        <div id="header"><!--Genera un encabezado -->
            <h1>ListaDatos</h1>
        </div><!-- end #header -->
        <div id="sidebar1"><!-- crea la seccion que recibe los datos del menu -->           
            <form action="Lista"><!-- Genera el cambio de pagina y da la orden de enviar los datos ingresdos -->
                <center><H2> Generar Lista </h2></center>
                <center><table><!-- Crea una tabla -->
                    
                    <tr>
                        <td><input class="boton" type="submit" ></td> <!-- Boton que nos envia a ConsultaCM.java -->
                    </tr>
                </table></center>
            </form>
            </br>
            <a class="boton" type="submit" href="index.html"  alling="rigth"> Regresar</a><!-- Boton que nos envia a Index.html -->
        </div><!-- end #mainContent -->
        <br class="clearfloat" /><!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
        <div id="footer">
            
            <h6> Gracias </h6> 
        </div><!-- end #footer -->
    </div><!-- end #container -->
</body>
</html>
