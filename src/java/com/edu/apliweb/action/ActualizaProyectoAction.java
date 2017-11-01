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
public class ActualizaProyectoAction extends ActionSupport {
    
    private int idpro;
    private String nam;
    private String descr;
    private String fechin;
    private String fechfin;
    private int mang;
    private String datreg;
    private String fechact;
   
    private List<Proyecto> listaProyecto=null;
    
    public ActualizaProyectoAction() {
    }
    
  

    /**
     * @return the idpro
     */
    public int getIdpro() {
        return idpro;
    }

    /**
     * @param idpro the idpro to set
     */
    public void setIdpro(int idpro) {
        this.idpro = idpro;
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
     * @return the mang
     */
    public int getMang() {
        return mang;
    }

    /**
     * @param mang the mang to set
     */
    public void setMang(int mang) {
        this.mang = mang;
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
   
    @Override
    public String execute() throws Exception {
  ProyectoDao proyectoDao = new ProyectoDao();
        Boolean res = false;
        Proyecto proy = new Proyecto();
        proy.setIdproyecto(idpro);
        proy.setName(nam);
        proy.setDescription(descr);
        proy.setBegindate(fechin);
        proy.setEnddate(fechfin);
        proy.setManager(mang);
        proy.setRegistrationdate(datreg);
        proy.setUpdatedate(fechact);
        try {

            res = proyectoDao.actualizaProyectoDao(proy);
            proyectoDao.obtenerListaProyectoDao();
            System.out.println("Exito al Modificar Proyecto Action");
        } catch (Exception e) {
            System.out.println("Error al Modificar Proyecto Action :" + e.getMessage());
            e.printStackTrace();
        }
        if (res == true) {
            addActionMessage("Proyecto Modificado con Exito");
            listaProyecto = proyectoDao.obtenerListaProyectoDao();
            return SUCCESS;
        } else {
            addActionMessage("Error al Modificar el Proyecto");
            return ERROR;
        }
    }
}
