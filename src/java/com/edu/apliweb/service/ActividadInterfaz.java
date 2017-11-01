/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.service;

import com.edu.apliweb.bean.Actividad;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ActividadInterfaz {
    public List obtenerListaActividadDao() throws Exception;
     public boolean ingresarActividadDao(Actividad actividad);
   //  public boolean ingresarUsuarioDao(Usuario usuario);
       public int count();

    public List<Actividad> find(int from, int to);
}
