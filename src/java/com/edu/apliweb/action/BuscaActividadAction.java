/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;

import com.edu.apliweb.bean.Actividad;
import com.edu.apliweb.dao.ActividadDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public class BuscaActividadAction extends ActionSupport {
    private String doc;
    private List<Actividad> listaActividad = null;
    private Actividad actividad;
    
    public BuscaActividadAction() {
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
     * @return the listaActividad
     */
    public List<Actividad> getListaActividad() {
        return listaActividad;
    }

    /**
     * @param listaActividad the listaActividad to set
     */
    public void setListaActividad(List<Actividad> listaActividad) {
        this.listaActividad = listaActividad;
    }

    /**
     * @return the actividad
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividad to set
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
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
                ActividadDao actividaddao = new ActividadDao();
                actividad = actividaddao.obtenerListadoActividadIdDao(doc);
                System.out.println("Exito CargaListadoActividadIdAction");
                // Cargo el resultado del ArrayList si es vacio es true
                
            }
        } catch (Exception e) {
            System.out.println("Error CargaListadoActividadIdAction" + e.getMessage());
            e.printStackTrace();
        }
        // Valido el resultado de la busqueda
       
        if(actividad==null){
            addActionMessage("No se Encontraron Coincidencias");
            return  ERROR;
        }else {
            addActionMessage("Se Encontraron Coincidencias");
            return SUCCESS;
        }
    }
    
}
