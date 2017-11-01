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
public class Actividad {
    private Integer idactividad;
    private Integer idproyecto;
    private String name;
    private String description;
    private String begindate;
    private String enddate;
    private String registrationdate;
    private String updatedate;

    /**
     * @return the idactividad
     */
    public Integer getIdactividad() {
        return idactividad;
    }

    /**
     * @param idactividad the idactividad to set
     */
    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    /**
     * @return the idproyecto
     */
    public Integer getIdproyecto() {
        return idproyecto;
    }

    /**
     * @param idproyecto the idproyecto to set
     */
    public void setIdproyecto(Integer idproyecto) {
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
}
