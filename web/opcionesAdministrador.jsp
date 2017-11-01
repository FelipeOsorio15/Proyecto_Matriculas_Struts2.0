<%-- 
    Document   : opcionesAdministrador
    Created on : 12/06/2015, 09:50:45 AM
    Author     : pc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='s' uri="/struts-tags" %>
<%@taglib prefix='s' uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix='sx' uri="/struts-dojo-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="resources/reinstated/style.css" />
     
       
        <sx:head/>
        <title>Funciones Admin</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
            </div>
            <div id="menu">
                <ul>
                    <li class="current_page_item">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="login.jsp">Logueo</a></li>
                    <li><a href="contactenos.jsp">Acerca de Nosotros..</a></li>
               
                </ul>
            </div>
            <%--   <div id="page"> --%>
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="sidebar">
                            <ul>
                                
                                

                                <li> <a href="CrearUsuarioXML" style="color: red">Crear/Listar Usuario</a></li>

                                
                               
                               

                                <li> <a href="#" style="color: red">Informacion Personal</a></li>

                                
                              

                                <li> <a href="CrearProyectoXML"  style="color: red">Crear Proyecto</a></li>

                                
                               

                                <li> <a href="CrearActividadXML" style="color: red">Crear Actividad</a></li>

                               
                                
                            </ul>
                        </div><br>
                        <h2>Cuenta de Usuario</h2>
                        <s:actionmessage  ></s:actionmessage>  
                        <%
                            Date date = new Date();
                            SimpleDateFormat data_formato = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
                            String mostrardata = data_formato.format(date);
                        %>
                        Acceso Sesion: </b><%=mostrardata%><br> 
                        <br/>    
                        <s:a href="LogoutUsuarioXML">Cerrar Sesion</s:a><p>

                        <div style="clear: both;">&nbsp;</div>




                    </div>


                </div>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
               
                        <%-- </div> --%>

        </div>


       

    </body>
</html>
