/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;

import com.edu.apliweb.bean.Usuario;
import com.edu.apliweb.dao.UsuarioDao;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author pc
 */
public class ActualizaUsuarioAction extends ActionSupport {
    
    private int idus;
    private String nam;
    private String lastnam;
    private int doci;
    private String usernam;
    private String passw;
    private String emai;
    private List<Usuario> listaUsuario=null;
    
    public ActualizaUsuarioAction() {
    }
  

    /**
     * @return the idus
     */
    public int getIdus() {
        return idus;
    }

    /**
     * @param idus the idus to set
     */
    public void setIdus(int idus) {
        this.idus = idus;
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
     * @return the lastnam
     */
    public String getLastnam() {
        return lastnam;
    }

    /**
     * @param lastnam the lastnam to set
     */
    public void setLastnam(String lastnam) {
        this.lastnam = lastnam;
    }

    /**
     * @return the doci
     */
    public int getDoci() {
        return doci;
    }

    /**
     * @param doci the doci to set
     */
    public void setDoci(int doci) {
        this.doci = doci;
    }

    /**
     * @return the usernam
     */
    public String getUsernam() {
        return usernam;
    }

    /**
     * @param usernam the usernam to set
     */
    public void setUsernam(String usernam) {
        this.usernam = usernam;
    }

    /**
     * @return the passw
     */
    public String getPassw() {
        return passw;
    }

    /**
     * @param passw the passw to set
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    /**
     * @return the emai
     */
    public String getEmai() {
        return emai;
    }

    /**
     * @param emai the emai to set
     */
    public void setEmai(String emai) {
        this.emai = emai;
    }

    /**
     * @return the listaUsuario
     */
    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    /**
     * @param listaUsuario the listaUsuario to set
     */
    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
 
    public String execute() throws Exception {
  UsuarioDao usuarioDao = new UsuarioDao();
        Boolean res = false;
        Usuario usu = new Usuario();
        usu.setIduser(idus);
        usu.setName(nam);
        usu.setLastname(lastnam);
        usu.setDocid(doci);
        usu.setUsername(usernam);
        usu.setPassword(passw);
        usu.setEmail(emai);
        try {

            res = usuarioDao.actualizaUsuarioDao(usu);
            usuarioDao.obtenerListaUsuarioDao();
            System.out.println("Exito al Modificar Usuario Action");
        } catch (Exception e) {
            System.out.println("Error al Modificar Usuario Action :" + e.getMessage());
            e.printStackTrace();
        }
        if (res == true) {
            addActionMessage("Usuario Modificado con Exito");
            listaUsuario = usuarioDao.obtenerListaUsuarioDao();
            return SUCCESS;
        } else {
            addActionMessage("Error al Modificar el Usuario");
            return ERROR;
        }
    }
}
