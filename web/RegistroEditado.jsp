<%-- 
    Document   : RegistroEditado
    Created on : 29/07/2018, 11:20:11 AM
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
            <h1>Registro Usuario</h1>
        </div><!-- end #header -->
        <div id="sidebar1"><!-- crea la seccion Registro del menu -->
            
            <form action="RegistroEditado"><!-- Genera el cambio de pagina y da la orden de enviar los datos ingresdos -->
                <center><table>
                     
                    <tr>
                        <td><label>Nombre</label></td>  
                        <td><input title="Juanito" pattern="^[a-zA-z]*$"id="Nombre" name="nombre" type="text" length="100"required/> </td><!-- Escribe y guarda el nombre -->
                    </tr>
                     <tr>
                         <td><label>Apellido </label></td>
                         <td><input title="Gomezito" pattern="^[a-zA-z]*$" id="Apellido1" name="apellido1" type="text" length="100"required/></td><!--Escribe y guardael primer apellido-->
                    </tr>
                     <tr>
                        <td> <label>Segundo apellido </label></td>
                        <td> <input title="Calderon" pattern="^[a-zA-z]*$" id="Apellido2" name="apellido2" type="text" length="100"required/></td> <!--Escribe y guarda el segundo apellido -->
                    </tr>
                    
                    
                    <td><label>Tipo de documento</label></td>
                        <<td><select id="TipoDocumento" name="tipodocumento"><!--Selecciona y guarda el estrato -->
                            <option value="Certificado Cabildo">Certificado Cabildo</option>
                            <option value="Cédula de Ciudadanía">Cédula de Ciudadanía</option>
                            <option value="Cedula de Extranjeria">Cedula de Extranjeria</option>
                            <option value="Documento de Identidad Extranjera">Documento de Identidad Extranjera</option>
                            <option value="N.I.T">N.I.T</option>
                            <option value="Pasaporte">Pasaporte</option>                 
                            <option value="Registro Civil">Registro Civil</option> 
                            <option value="Tarjeta de Identidad">Tarjeta de Identidad</option> 
                            <option value="Visa">Visa</option> 
                        
                               </select>
                        </td><!--Escribe y guarda el documento  -->
                    <tr>
                        <td><label>Documento</label></td>
                        
                        <td><input title="10185502000"  pattern="^[0-9]*$" id="Documento" name="documento" type="text" length="100"required/></td><!--Escribe y guarda el tipo de documento -->
                    </tr>
                     <tr>
                        
                    </tr>
                     <tr>
                        
                    </tr>
                     <tr>
                        <td> <label>Celular </label></td><!--Escribe y guarda el celular -->
                        <td>  <input title="3456789023123"  pattern="^[0-9]*$"id="Celular" name="celular" type="text" length="100"required/> </td>
                    </tr>
                     <tr>
                         <td><label>Correo electronico </label></td><!--Escribe y guarda el correo electronico  -->
                         <td><input title="correo@mail.com" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" id="Correo" name="correo" type="text" length="100"required/></td>
                    </tr>
                     <tr>
                         <td><label>Contraseña </label></td><!--Escribe y guarda la contraseña  -->
                         <td><input TYPE="password" type="text" id="Contraseña" name="contraseña" length="1000"required/></td>
                        
                    </tr>
                    <tr>
                        <td><input  class="boton" type="submit" ></td> <!-- Boton que nos envia a Registrar.java -->
                    </tr>
                </table></center>
            </form>
            </br>
            <a class="boton" type="submit" href="index.html"  alling="rigth"> Regresar</a><!-- Boton que nos envia a Index.html -->
  
        </div><!-- end #sidebar -->
        <br class="clearfloat" /><!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
        <div id="footer"><!--pie de pagina-->
            <h6> mi factura.com es un marca registrada  </h6> 
            <h6> mifactura.com inc 2017 todos los derechos reservados  </h6> 
        </div><!-- end #footer -->
    </div><!-- end #container -->
</body>
</html>
