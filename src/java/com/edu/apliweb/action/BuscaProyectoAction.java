/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;

import com.edu.apliweb.bean.Proyecto;
import com.edu.apliweb.dao.ProyectoDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public class BuscaProyectoAction extends ActionSupport {
    
     private String doc;
    private List<Proyecto> listaProyecto = null;
    private Proyecto proyecto;
    public BuscaProyectoAction() {
    }
    
   

    /**
     * @return the doc
     */
    public String getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }

    /**
     * @return the listaProyecto
     */
    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    /**
     * @param listaProyecto the listaProyecto to set
     */
    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    
    public String execute() throws Exception {
        Boolean resultado = false;
        try {
            Map session = ActionContext.getContext().getSession();
            if (session.get("sesion") == null) {
                System.out.println("No esta creada la sesion");
                return ERROR;
            } else {
                System.out.println("Sesion Creada");
                ProyectoDao proyectodao = new ProyectoDao();
                proyecto = proyectodao.obtenerListadoProyectoIdDao(doc);
                System.out.println("Exito CargaListadoUsuarioIdAction");
                // Cargo el resultado del ArrayList si es vacio es true
                
            }
        } catch (Exception e) {
            System.out.println("Error CargaListadoProyectoIdAction" + e.getMessage());
            e.printStackTrace();
        }
        // Valido el resultado de la busqueda
       
        if(proyecto==null){
            addActionMessage("No se Encontraron Coincidencias");
            return  ERROR;
        }else {
            addActionMessage("Se Encontraron Coincidencias");
            return SUCCESS;
        }
    }
}
