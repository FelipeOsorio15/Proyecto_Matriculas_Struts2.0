/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;

import com.edu.apliweb.bean.Usuario;
import com.edu.apliweb.dao.UsuarioDao;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public class BuscaUsuarioAction extends ActionSupport {
    private String doc;
    private List<Usuario> listaUsuario = null;
    private Usuario usuario;
    
    public BuscaUsuarioAction() {
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
    
    public String execute() throws Exception {
        Boolean resultado = false;
        try {
            Map session = ActionContext.getContext().getSession();
            if (session.get("sesion") == null) {
                System.out.println("No esta creada la sesion");
                return ERROR;
            } else {
                System.out.println("Sesion Creada");
                UsuarioDao usuariodao = new UsuarioDao();
                usuario = usuariodao.obtenerListadoUsuarioIdDao(doc);
                System.out.println("Exito CargaListadoUsuarioIdAction");
                // Cargo el resultado del ArrayList si es vacio es true
                
            }
        } catch (Exception e) {
            System.out.println("Error CargaListadoUsuarioIdAction" + e.getMessage());
            e.printStackTrace();
        }
        // Valido el resultado de la busqueda
       
        if(usuario==null){
            addActionMessage("No se Encontraron Coincidencias");
            return  ERROR;
        }else {
            addActionMessage("Se Encontraron Coincidencias");
            return SUCCESS;
        }
    }
    
}
