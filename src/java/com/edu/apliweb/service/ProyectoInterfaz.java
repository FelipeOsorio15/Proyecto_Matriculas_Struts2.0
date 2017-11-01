/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.service;


import com.edu.apliweb.bean.Proyecto;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ProyectoInterfaz {

     public List obtenerListaProyectoDao() throws Exception;
     public boolean ingresarProyectoDao(Proyecto proyecto);
   //  public boolean ingresarUsuarioDao(Usuario usuario);
       public int count();
public boolean actualizaProyectoDao(Proyecto proyecto) throws Exception;
public Proyecto obtenerListadoProyectoIdDao(String var) throws Exception;
    public List<Proyecto> find(int from, int to);
}
