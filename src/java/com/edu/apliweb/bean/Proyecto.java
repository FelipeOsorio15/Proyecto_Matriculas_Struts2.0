/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.bean;

/**
 *
 * @author pc
 */
public class Proyecto {
 int idproyecto;
  private Usuario usuario;
     String name;
     String description;
     int manager;
     String begindate;
     String enddate;
     String registrationdate;
     String updatedate;

    /**
     * @return the idProyecto
     */
    public int getIdproyecto() {
        return idproyecto;
    }

    /**
     * @param idproyecto the idProyecto to set
     */
    
    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
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
     * @return the endate
     */
    public String getEnddate() {
        return enddate;
    }

    /**
     * @param enddate the endate to set
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
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}