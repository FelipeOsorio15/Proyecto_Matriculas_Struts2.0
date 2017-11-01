/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;

import com.edu.apliweb.bean.Actividad;
import com.edu.apliweb.dao.ActividadDao;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author pc
 */
public class IngresoActividadAction extends ActionSupport {
     private List<Actividad> listaActividad = null;
      private Actividad actividad;  
      private String name;
      private String description;
     
      private String begindate;
      private String enddate;
      
      private String registrationdate;
      private String updatedate;
    private int idproyecto;
    public IngresoActividadAction() {
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the begindate
     */
    public String getBegindate() {
        return begindate;
    }

    /**
     * @param begindate the begindate to set
     */
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    /**
     * @return the enddate
     */
    public String getEnddate() {
        return enddate;
    }

    /**
     * @param enddate the enddate to set
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    /**
     * @return the registrationdate
     */
    public String getRegistrationdate() {
        return registrationdate;
    }

    /**
     * @param registrationdate the registrationdate to set
     */
    public void setRegistrationdate(String registrationdate) {
        this.registrationdate = registrationdate;
    }

    /**
     * @return the updatedate
     */
    public String getUpdatedate() {
        return updatedate;
    }

    /**
     * @param updatedate the updatedate to set
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * @return the idproyecto
     */
    public int getIdproyecto() {
        return idproyecto;
    }

    /**
     * @param idproyecto the idproyecto to set
     */
    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }
    @Override
    public void validate() {
        if (getName().length() == 0) {
            addFieldError("name", "Debe ingresar el Nombre");
        }
        if (getDescription().length() == 0) {
            addFieldError("description", "Debe ingresar la descripcion");
        }
        
        if (getBegindate().length() == 0) {
            addFieldError("begindate", "Debe ingresar fecha inicio");
        }
        if (getEnddate().length() == 0) {
            addFieldError("enddate", "Debe ingresar fecha fin");
        }
       
        if (getRegistrationdate().length() == 0) {
            addFieldError("registrationdate", "Debe ingresar fecha reg");
        }
        if (getUpdatedate().length() == 0) {
            addFieldError("updatedate", "Debe ingresar fecha actu");
        }
         int idproy;
        idproy=getIdproyecto();
        if (idproy == 0) {
            addFieldError("manager", "Debe ingresar el idproy");
        }
    }

     @Override
    public String execute() throws Exception {
        ActividadDao actividadDao = new ActividadDao();
        Boolean res = false;
        Actividad acti = new Actividad();
        acti.setName(name);
        acti.setDescription(description);
        acti.setBegindate(begindate);
        acti.setEnddate(enddate);
       
        acti.setRegistrationdate(registrationdate);
        acti.setUpdatedate(updatedate);
        acti.setIdproyecto(idproyecto);
        try {

            res = actividadDao.ingresarActividadDao(acti);
            actividadDao.obtenerListaActividadDao();
            System.out.println("Exito al Ingresar Actividad Action");
        } catch (Exception e) {
            System.out.println("Error al Ingresar Actividad Action :" + e.getMessage());
            e.printStackTrace();
        }
        if (res == true) {
            addActionMessage("Actividad Registrado con Exito");
            listaActividad = actividadDao.obtenerListaActividadDao();
            return SUCCESS;
        } else {
            addActionMessage("Error al Registrar Actividad");
            return ERROR;
        }
    }

    
}
