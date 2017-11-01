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
public class ActualizaActividadAction extends ActionSupport {
     private int idacti;
    private String nam;
    private String descr;
    private String fechin;
    private String fechfin;

    private String datreg;
    private String fechact;
        private int idproye;
   
    private List<Actividad> listaActividad=null;
    
    public ActualizaActividadAction() {
    }
    
  
    /**
     * @return the idacti
     */
    public int getIdacti() {
        return idacti;
    }

    /**
     * @param idacti the idacti to set
     */
    public void setIdacti(int idacti) {
        this.idacti = idacti;
    }

    /**
     * @return the nam
     */
    public String getNam() {
        return nam;
    }

    /**
     * @param nam the nam to set
     */
    public void setNam(String nam) {
        this.nam = nam;
    }

    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @param descr the descr to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * @return the fechin
     */
    public String getFechin() {
        return fechin;
    }

    /**
     * @param fechin the fechin to set
     */
    public void setFechin(String fechin) {
        this.fechin = fechin;
    }

    /**
     * @return the fechfin
     */
    public String getFechfin() {
        return fechfin;
    }

    /**
     * @param fechfin the fechfin to set
     */
    public void setFechfin(String fechfin) {
        this.fechfin = fechfin;
    }

    /**
     * @return the datreg
     */
    public String getDatreg() {
        return datreg;
    }

    /**
     * @param datreg the datreg to set
     */
    public void setDatreg(String datreg) {
        this.datreg = datreg;
    }

    /**
     * @return the fechact
     */
    public String getFechact() {
        return fechact;
    }

    /**
     * @param fechact the fechact to set
     */
    public void setFechact(String fechact) {
        this.fechact = fechact;
    }

    /**
     * @return the idproye
     */
    public int getIdproye() {
        return idproye;
    }

    /**
     * @param idproye the idproye to set
     */
    public void setIdproye(int idproye) {
        this.idproye = idproye;
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
    @Override
    public String execute() throws Exception {
  ActividadDao actividadDao = new ActividadDao();
        Boolean res = false;
        Actividad acti = new Actividad();
        acti.setIdactividad(idacti);
        acti.setName(nam);
        acti.setDescription(descr);
        acti.setBegindate(fechin);
        acti.setEnddate(fechfin);
        acti.setRegistrationdate(datreg);
        acti.setUpdatedate(fechact);
        acti.setIdproyecto(idproye);
        try {

            res = actividadDao.actualizaActividadDao(acti);
            actividadDao.obtenerListaActividadDao();
            System.out.println("Exito al Modificar Actividad Action");
        } catch (Exception e) {
            System.out.println("Error al Modificar ActividadAction :" + e.getMessage());
            e.printStackTrace();
        }
        if (res == true) {
            addActionMessage("Proyecto Modificado con Exito");
            listaActividad = actividadDao.obtenerListaActividadDao();
            return SUCCESS;
        } else {
            addActionMessage("Error al Modificar la Activiad");
            return ERROR;
        }
    }
}
