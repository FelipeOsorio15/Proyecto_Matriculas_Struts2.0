/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.service;

import com.edu.apliweb.bean.Usuario;
import java.util.List;

/**
 *
 * @author pc
 */
public interface UsuarioInterfaz {
    public Usuario loginUsuarioDao(String usu, String pass);
     public List obtenerListaUsuarioDao() throws Exception;
     public boolean ingresarUsuarioDao(Usuario usuario);
      public boolean actualizaUsuarioDao(Usuario usuario) throws Exception;
        //public Usuario buscarUsuarioIdDao(int id);
   //  public boolean ingresarUsuarioDao(Usuario usuario);
       public int count();
 public Usuario obtenerListadoUsuarioIdDao(String var) throws Exception;
    public List<Usuario> find(int from, int to);
    
}



    
