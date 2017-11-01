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
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author pc
 */
public class IngresoUsuarioAction extends ActionSupport {
    
    private List<Usuario> listaUsuario = null;
     Usuario usuario;  
     String name;
     String lastname;
     int docid;
     String username;
     String password;
     String email;

    
    

    
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
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the docid
     */
    public int getDocid() {
        return docid;
    }

    /**
     * @param docid the docid to set
     */
    public void setDocid(int docid) {
        this.docid = docid;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void validate() {
        if (getName().length() == 0) {
            addFieldError("name", "Debe ingresar el Nombre");
        }
        if (getLastname().length() == 0) {
            addFieldError("lastname", "Debe ingresar el Apellido");
        }
        int doc;
        doc=getDocid();
        if (doc == 0) {
            addFieldError("docid", "Debe ingresar el Documento ID");
        }
        if (getUsername().length() == 0) {
            addFieldError("username", "Debe ingresar el Usuario");
        }
        if (getPassword().length() == 0) {
            addFieldError("password", "Debe ingresar el Password");
        }
        if (getEmail().length() == 0) {
            addFieldError("email", "Debe ingresar el Email");
        }
        
    }

    

    public String execute() throws Exception {
        UsuarioDao usuarioDao = new UsuarioDao();
        Boolean res = false;
        Usuario usua = new Usuario();
        usua.setName(name);
        usua.setLastname(lastname);
        usua.setDocid(docid);
        usua.setUsername(username);
        usua.setPassword(password);
        usua.setEmail(email);
        try {

            res = usuarioDao.ingresarUsuarioDao(usua);
            usuarioDao.obtenerListaUsuarioDao();
            System.out.println("Exito al Ingresar Usuario Action");
        } catch (Exception e) {
            System.out.println("Error al Ingresar Usuario Action :" + e.getMessage());
            e.printStackTrace();
        }
        if (res == true) {
            addActionMessage("Usuario Registrado con Exito");
            listaUsuario = usuarioDao.obtenerListaUsuarioDao();
            return SUCCESS;
        } else {
            addActionMessage("Error al Registrar el Usuario");
            return ERROR;
        }
    }

    
}

