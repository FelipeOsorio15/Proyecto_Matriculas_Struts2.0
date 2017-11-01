<%-- 
    Document   : crearUsuario
    Created on : 12/06/2015, 01:56:18 PM
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
            <%--    <div id="page"> --%>
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="sidebar">
                            <ul>
                                
                                

                                <li> <a href="CrearUsuarioXML" style="color: red">Crear/Listar Usuario</a></li>

                                
                                
                               

                                <li> <a href="CargaInformacionPersonalXML" style="color: red">Informacion Personal</a></li>

                               
                                
                              

                                <li> <a href="CrearProyectoXML"  style="color: red">Crear Proyecto</a></li>

                               
                                
                               

                                <li> <a href="CrearActividadXML" style="color: red">Crear Actividad</a></li>

                               
                                
                            </ul>
                        </div>

                        <div id="content"><br>
                            <h1>MANTENIMIENTO DE USUARIO</h1>
                            <br>
                            <s:a href="LogoutUsuarioXML">Cerrar Sesion</s:a><p>
                                    <br>
                                <h1>
                                </h1>
                                <br/>
                            <s:actionmessage></s:actionmessage>
                            <sx:tabbedpanel id="tabIngreso">
                                <sx:div id="tab1" label="Ingreso Usuario" theme="ajax" >
                                    <br/>
                                    <h1>Ingreso Usuario</h1>
                                    <br/>
                                    <table align="center" class="table" >
                                        <tr>
                                            <td>                   
                                                <s:form action="IngresoUsuarioXML" >

                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Nombre" name="name" id="name">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Apellidos" name="lastname" id="lastname">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="DocID" name="docid" id="docid">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Usuario" name="username" id="username">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Password" name="password" id="password">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Email" name="email" id="email">
                                                    </s:textfield>
                                                    <s:submit value="Registrar"></s:submit>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </table>
                                </sx:div> 
                                <sx:div id="tab2" label="Lista Usuario" theme="ajax">
                                    <br/>
                                    <h1>Lista de Usuario</h1>
                                    <br/>
                                    <sj:head jqueryui="true" jquerytheme="redmond" />
                                    <s:url id="remoteurl" action="listaUsuarioXML"></s:url>    
                                    <s:url id="editurl" action="edit-grid-entry"></s:url>

                                    <sjg:grid

                                        id="grilla"
                                        caption="User"
                                        dataType="json"
                                        href="%{remoteurl}"
                                        editurl="%{editurl}"
                                        pager="true"
                                        navigator="true"
                                        navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
                                        navigatorAddOptions="{height:450,reloadAfterSubmit:true}"
                                        navigatorEditOptions="{height:450,reloadAfterSubmit:false}"
                                        navigatorEdit="true"
                                        navigatorView="true"
                                        navigatorDelete="true"
                                        navigatorDeleteOptions="{height:450,reloadAfterSubmit:true}"
                                        gridModel="gridModel"
                                        rowList="10,15,20"
                                        rowNum="10"
                                        multiselect="true"
                                        onSelectRowTopics="rowselect"
                                        viewrecords="true"
                                        width="600"

                                        >     

                                        <sjg:gridColumn name="iduser" index="iduser" title="Id" sortable="false" search="true" width="20" searchoptions="{sopt:['eq','ne','lt','gt']}"/>
                                        <sjg:gridColumn name="name" index="name" title="Nombre" editable="true" width="60" edittype="text" sortable="true" search="false"/>
                                        <sjg:gridColumn name="lastname" index="lastname" title="Apellido" editable="true" edittype="text" width="100" sortable="true" search="false"/>
                                        <sjg:gridColumn name="docid" index="docid"  title="DocID" editable="true" edittype="text" width="100" sortable="true" search="false" />
                                        <sjg:gridColumn name="username" index="username"  title="User" editable="true" edittype="text" width="50" sortable="true" search="false" />
                                        <sjg:gridColumn name="password" index="password"  title="Password" editable="true" edittype="text" width="50" sortable="true" search="false" />
                                        <sjg:gridColumn name="email" index="email" title="Email" editable="true" edittype="text" width="50" sortable="true" search="false" />
                                    </sjg:grid>   

                                </sx:div> 
                                <sx:div id="tab3" label="Modifica Usuario" theme="ajax" >
                                    <br/>
                                    <h1>Modifica Usuario</h1>
                                    <br/>
                                    <table align="center" class="table" >
                                        <tr>
                                            <td>         
                                                <s:form action="BuscaUsuarioXML">
                                                    <s:textfield label="ID:"
                                                                 name="doc" 
                                                                 size="8">
                                                    </s:textfield>
                                                    <s:submit value="Buscar"></s:submit>
                                                </s:form>
                                                <s:form action="ActualizaUsuarioXML" >

                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="ID" name="idus" id="iduser" value="%{usuario.iduser}">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Nombre" name="nam" id="name" value="%{usuario.name}">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Apellidos" name="lastnam" id="lastname" value="%{usuario.lastname}" >
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Docidd" name="doci" id="docid" value="%{usuario.docid}">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Username" name="usernam" id="username" value="%{usuario.username}">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Passsword" name="passw" id="password" value="%{usuario.password}">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Email" name="emai" id="email" value="%{usuario.email}">
                                                    </s:textfield>
                                                    <s:submit value="Modificar"></s:submit>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </table>
                                </sx:div> 
                                <br/>
                            </sx:tabbedpanel> 


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