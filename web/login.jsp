<%-- 
    Document   : login
    Created on : 12/06/2015, 09:44:13 AM
    Author     : pc
--%>

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
        <link rel="stylesheet" type="text/css" href="engine1/style.css" />
        
        <sx:head/>
        <title>Loguin</title>
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
                        <h2>Cuenta de Usuario</h2>
                        <s:form action="LoginUsuarioXML"> 
                            <s:actionmessage></s:actionmessage>
                            <s:actionerror></s:actionerror>
                            <s:textfield label="Usuario"
                                         name="usu"
                                         id="usu"
                                         size="20"
                                         >        
                            </s:textfield>
                            <s:actionerror></s:actionerror>
                            <s:password label="Clave"
                                        name="pass"
                                        id="pass"
                                        size="20"
                                        type="password">        
                            </s:password>
                            <s:submit value="Ingresar"></s:submit>   
                        </s:form>

                    </div>


                </div>
                <br/>
                <br/>
                <br/>
                <br/>
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
