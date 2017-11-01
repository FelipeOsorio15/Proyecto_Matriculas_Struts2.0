<%-- 
    Document   : crearProyecto
    Created on : 16/06/2015, 07:25:03 AM
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
        <title>Funciones Proyecto</title>
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
            <%--     <div id="page"> --%>
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
                            <h1>MANTENIMIENTO DE PROYECTOS</h1>
                            <br>
                            <s:a href="LogoutUsuarioXML">Cerrar Sesion</s:a><p>
                                    <br>
                                <h1>
                                </h1>
                                <br/>
                            <s:actionmessage></s:actionmessage>
                            <sx:tabbedpanel id="tabIngreso">
                                <sx:div id="tab1" label="Ingreso Proyecto" theme="ajax" >
                                    <br/>
                                    <h1>Ingreso Proyecto</h1>
                                    <br/>
                                    <table align="center" class="table" >
                                        <tr>
                                            <td>                   
                                                <s:form action="IngresoProyectoXML" >

                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Nombre" name="name" id="name">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Descripcion" name="description" id="description">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fecha Inicio" name="begindate" id="begindate">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fecha Fin" name="enddate" id="enddate">
                                                    </s:textfield>
                                                         <s:actionerror></s:actionerror>
                                                    <s:textfield label="Manager" name="manager" id="manager">
</s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fecha Registro" name="registrationdate" id="registrationdate">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fecha Actuali" name="updatedate" id="updatedate">
                                                    </s:textfield>
                                                    <s:submit value="Registrar"></s:submit>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </table>
                                </sx:div> 
                                <sx:div id="tab2" label="Lista Proyecto" theme="ajax">
                                    <br/>
                                     
                                    <h1>Lista de Proyecto</h1>
                                    <br/>
                                    <sj:head jqueryui="true" jquerytheme="redmond" />
                                    <s:url id="remoteurl" action="listaProyectoXML" ></s:url>    
                                    <s:url id="editurl" action="edit-grid-entry"></s:url>

                                    <sjg:grid

                                        id="grilla"
                                        caption="Proyecto"
                                        dataType="json"
                                        href="%{remoteurl}"
                                        editurl="%{editurl}"
                                        pager="true"
                                        navigator="true"
                                        navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
                                        navigatorAddOptions="{height:550,reloadAfterSubmit:true}"
                                        navigatorEditOptions="{height:550,reloadAfterSubmit:false}"
                                        navigatorEdit="true"
                                        navigatorView="true"
                                        navigatorDelete="true"
                                        navigatorDeleteOptions="{height:550,reloadAfterSubmit:true}"
                                        gridModel="gridModel"
                                        rowList="10,15,20"
                                        rowNum="10"
                                        multiselect="true"
                                        onSelectRowTopics="rowselect"
                                        width="800"

                                        >     

                                        <sjg:gridColumn name="idproyecto"  index="idproyecto" title="Id" sortable="false" search="true" width="20" searchoptions="{sopt:['eq','ne','lt','gt']}"/>
                                        <sjg:gridColumn name="name"  index="name" title="Nombre" editable="true" width="60" edittype="text" sortable="true" search="false"/>
                                        <sjg:gridColumn name="description" index="description" title="Descr" editable="true" edittype="text" width="100" sortable="true" search="false"/>
                                        <sjg:gridColumn name="begindate" index="begindate" title="FeIni" editable="true" edittype="text" width="100" sortable="true" search="false" />
                                        <sjg:gridColumn name="enddate" index="enddate" title="FeFin" editable="true" edittype="text" width="50" sortable="true" search="false" />
                                        <sjg:gridColumn name="manager" index="manager" title="Manag" editable="true" edittype="text" width="50" sortable="true" search="false" />
                                        <sjg:gridColumn name="registrationdate" index="registrationdate"  title="FeReg" editable="true" edittype="text" width="50" sortable="true" search="false" />
                                        <sjg:gridColumn name="updatedate" index="updatedate"  title="FeAct" editable="true" edittype="text" width="50" sortable="true" search="false" />
                                    </sjg:grid>   

                                </sx:div> 
                                <sx:div id="tab3" label="Modifica Proyecto" theme="ajax" >
                                    <br/>
                                    <h1>Modifica Proyecto</h1>
                                    <br/>
                                    <table align="center" class="table" >
                                        <tr>
                                            <td>         
                                                <s:form action="BuscaProyectoXML">
                                                    <s:textfield label="IdProy:"
                                                                 name="doc" 
                                                                 size="8">
                                                    </s:textfield>
                                                    <s:submit value="Buscar"></s:submit>
                                                </s:form>
                                                <s:form action="ActualizaProyectoXML" >

                                                        <s:actionerror></s:actionerror>
                                                    <s:textfield label="ID" name="idpro" id="idproyecto" value="%{proyecto.idproyecto}">
                                                    </s:textfield> 
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Nombre:" name="nam" id="name" value="%{proyecto.name}">
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Descripcion" name="descr" id="description" value="%{proyecto.description}" >
                                                    </s:textfield>
                                                    <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fechs Ini" name="fechin" id="begindate" value="%{proyecto.begindate}">
                                                    </s:textfield>
                                                     <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fechs Fin" name="fechfin" id="enddate" value="%{proyecto.enddate}">
                                                    </s:textfield>
                                                     <s:actionerror></s:actionerror>
                                                    <s:textfield label="Manager" name="mang" id="manager" value="%{proyecto.manager}">
                                                    </s:textfield>
                                                     <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fecha Regi" name="datreg" id="registrationdate" value="%{proyecto.registrationdate}">
                                                    </s:textfield>
                                                     <s:actionerror></s:actionerror>
                                                    <s:textfield label="Fecha Actual" name="fechact" id="updatedate" value="%{proyecto.updatedate}">
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
                            <%--    </div> --%>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            
        </div>

        

    </body>
</html>