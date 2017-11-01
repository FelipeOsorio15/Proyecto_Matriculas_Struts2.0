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
import java.util.Map;
import static javassist.CtMethod.ConstParameter.integer;

/**
 *
 * @author pc
 */
public class LoginUsuarioAction extends ActionSupport {
    
     String usu;
    String pass;
    Usuario usuario; 
    Integer iduser;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public LoginUsuarioAction() {
    }
     public void validate(){
        if (getUsu().length() == 0) {
             addFieldError("usu", "Debe ingresar un usuario");
         }
       if (getPass().length() == 0) {
              addFieldError("pass", "Debe ingresar password");
           }
    }
    public String execute() throws Exception {
        int cod;
        try{       
            UsuarioDao usuariodao=new UsuarioDao();

            usuario=usuariodao.loginUsuarioDao(usu, pass);
            System.out.println("Exito loginUsuarioAction");
             System.out.println("usuario" +usuario.getName());
        }catch(Exception e){
            System.out.println("Error loginUsuarioAction "+e.getMessage());
            e.printStackTrace();
        }
        // Se evalua el resultado de la consulta
        //si el objeto es vacio
        cod=usuario.getIduser();
        if(cod==0){
            addActionMessage("Datos Incorrectos");
            return ERROR;
        }else{
            Map<String,Object> sesion=ActionContext.getContext().getSession();
            sesion.put("sesion","true");
            System.out.println("Exito validacion usuario encontrado");
            addActionMessage("Bienvenido Administrador  "+usu);
            return SUCCESS;
        }
    }

    /**
     * @return the iduser
     */
  
}
