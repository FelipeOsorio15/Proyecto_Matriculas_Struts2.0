<%-- 
    Document   : index
    Created on : 12/06/2015, 09:41:56 AM
    Author     : pc
--%>

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
        <title>Aplicación Seguidor de Proyectos</title>
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
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="sidebar">
                      
                        </div>

                        <div class="post" align="justify"  >
                               <s:actionmessage></s:actionmessage>
                            <h2 class="title" align="justify" ><a style="color: #D53707" >Seguidor de Proyectos</a></h2>                                                                      
                            <h align="justify" style="color: #FFFFFF"> <b>El Sistema de seguimiento a proyectos consta de un módulo de usuarios para validar el 
                                    <br/>ingreso al sistema. La información de cada usuario debe coincidir con la definición de la<br/> Cada usuario puede representar a un “gerente de proyecto” o a un
                                    <br/>“participante/colaborador del proyecto” en el sistema (Ver figuras 1 y 2). Los usuarios se
                                    <br/>registran ellos mismos, pero deben tener un mecanismo de verificación de usuario real
                                    <br/>como el correo electrónico o captcha en el caso del gerente del proyecto (o algún otro
                                    <br/>mecanismo alternativo). Si se trata de un participante, entonces debe esperar la invitación
                                    <br/>a través de correo electrónico, de parte del gerente de dicho proyecto y aceptar.
                                </b></h>
                            <br/>
                            <i>Contactenos los esperamos con los brazos abiertos.</i>
                        </div>
                    </div>


                </div>
                    <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
           
            </div>

        </div>

    </body>
</html>