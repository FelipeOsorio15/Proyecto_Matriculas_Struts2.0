/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;


import com.edu.apliweb.bean.Proyecto;
import com.edu.apliweb.dao.ProyectoDao;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author pc
 */
public class IngresoProyectoAction extends ActionSupport {
    
    private List<Proyecto> listaProyecto = null;
      Proyecto proyecto;  
      String name;
      String description;
     
      String begindate;
      String enddate;
      int manager;
      String registrationdate;
      String updatedate;
    
   
    
   
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
     * @return the manager
     */
    public int getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(int manager) {
        this.manager = manager;
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
        int man;
        man=getManager();
        if (man == 0) {
            addFieldError("manager", "Debe ingresar el Manager");
        }
        if (getRegistrationdate().length() == 0) {
            addFieldError("registrationdate", "Debe ingresar fecha reg");
        }
        if (getUpdatedate().length() == 0) {
            addFieldError("updatedate", "Debe ingresar fecha actu");
        }
    }

    

    @Override
    public String execute() throws Exception {
        ProyectoDao proyectoDao = new ProyectoDao();
        Boolean res = false;
        Proyecto proy = new Proyecto();
        proy.setName(name);
        proy.setDescription(description);
        proy.setBegindate(begindate);
        proy.setEnddate(enddate);
        proy.setManager(manager);
        proy.setRegistrationdate(registrationdate);
        proy.setUpdatedate(updatedate);
        try {

            res = proyectoDao.ingresarProyectoDao(proy);
            proyectoDao.obtenerListaProyectoDao();
            System.out.println("Exito al Ingresar Proyecto Action");
        } catch (Exception e) {
            System.out.println("Error al Ingresar Proyecto Action :" + e.getMessage());
            e.printStackTrace();
        }
        if (res == true) {
            addActionMessage("Proyecto Registrado con Exito");
            listaProyecto = proyectoDao.obtenerListaProyectoDao();
            return SUCCESS;
        } else {
            addActionMessage("Error al Registrar el Proyecto");
            return ERROR;
        }
    }

    
}
