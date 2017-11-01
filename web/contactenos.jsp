<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='s' uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix='sx' uri="/struts-dojo-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="resources/reinstated/style.css" />
        <link rel="stylesheet" type="text/css" href="engine1/style.css" />
        
        <sx:head/>
        <title>Acerca De</title>
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
                    <li><a href="contactenos.jsp">Acerca de Nosotros</a></li>
               
                </ul>
            </div>
            <%--    <div id="page"> --%>
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="sidebar">
                            <ul>
                                
                                

                                <li> <a href="CrearUsuarioXML" style="color: red">Crear Usuario</a></li>

                                
                                
                               

                                <li> <a href="CargaInformacionPersonalXML" style="color: red">Informacion Personal</a></li>

                               
                                
                              

                                <li> <a href="CrearProyectoXML"  style="color: red">Crear Proyecto</a></li>

                               
                                
                               

                                <li> <a href="CrearActividadXML" style="color: red">Crear Actividad</a></li>

                               
                                
                            </ul>
                        </div>

                        <div id="content"><br>
                            <h1>Acerca de Nosotros</h1>
                            <br>
                            <s:a href="LogoutUsuarioXML">Cerrar Sesion</s:a><p>
                                    <br>
                                <h1>
                                </h1>
                                <br/>
                            <s:actionmessage></s:actionmessage>
                            

                        </div>

                    </div>


                </div>
                <br/>
                <br/>
                            <%--</div> --%>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            
        </div>

        

    </body>
</html>