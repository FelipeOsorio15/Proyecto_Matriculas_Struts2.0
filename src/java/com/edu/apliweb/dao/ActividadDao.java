/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.dao;


import com.edu.apliweb.bean.Actividad;

import com.edu.apliweb.service.ActividadInterfaz;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class ActividadDao implements ActividadInterfaz{
    
@Override
public List obtenerListaActividadDao() throws Exception {
          List listaActividad=new ArrayList();
        //Inicializacion de la conexion;
        Connection con=null;
        try{
            //Ejecuto conexion
           con=Conexion.getConnection();
           //Procedimiento Almacenado
           String sql="select * from actividad";
 //String sql="select p.idproyecto,p.name,p.description,p.begindate,p.enddate,p.manager,p.registrationdate,p.updatedate from Proyecto p, where  p.manager=user.iduser";
           // Precedimiento Almacenado
           CallableStatement stm=con.prepareCall(sql);
           ResultSet rs=stm.executeQuery();
           // Recorrer el ResultSet
           // para almacenar los datos de la consulta 
           while(rs.next()){
               Actividad actividad=new Actividad();
        //        proyecto.setIdProyecto(rs.getInt(1));
               actividad.setIdactividad(rs.getInt(1));
                actividad.setName(rs.getString(2));
                actividad.setDescription(rs.getString(3));
                actividad.setBegindate(rs.getString(4));
//          
                actividad.setEnddate(rs.getString(5));
              
                actividad.setRegistrationdate(rs.getString(6));
                actividad.setUpdatedate(rs.getString(7));
                  actividad.setIdproyecto(rs.getInt(8));
               // Almaceno el objeto en la lista
               listaActividad.add(actividad);
           }
           System.out.println("Exito listado ActividadDao");         
           }catch(Exception e){
           System.out.println("Error listado ActividadDao:"+e.getMessage());
           e.printStackTrace();
           }
        // El metodo devuelve el listado de objetos
        return listaActividad;
    }
    
    
     @Override
    public boolean ingresarActividadDao(Actividad actividad) {
  Connection con=null;
        try {
            con=Conexion.getConnection();
            String sql="call pa_ingresoActividad(?,?,?,?,?,?,?);";
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, actividad.getName());
            stm.setString(2, actividad.getDescription());
            stm.setString(3, actividad.getBegindate());
            stm.setString(4, actividad.getEnddate());
          
            stm.setString(5, actividad.getRegistrationdate());
            stm.setString(6, actividad.getUpdatedate());
              stm.setInt(7, actividad.getIdproyecto());
            stm.executeUpdate();
            stm.close();
            con.close();
            System.out.println("Exito al Ingresar ActividadDao");
            return true;           
        } catch (Exception e) {
            System.out.println("Erro al Ingresar ActividadDao :"+e.getMessage());
            e.printStackTrace();
            return false;
        }      
    }
    
    
     @Override
    public int count() {
       int count = 0;
         Connection con = null;	
         try {
            con = Conexion.getConnection();
            String sql = "SELECT COUNT(*) FROM actividad";
            CallableStatement cstm = con.prepareCall(sql);
            ResultSet rs=cstm.executeQuery();
            while(rs.next()){
               count=rs.getInt(1);
            }
            System.out.println("Exito cargaCuentaActividadDao");
        } catch (Exception e) {
            System.out.println("Error cargaCuentaActividadDao" + e.getMessage());
            e.printStackTrace();
        }
         return count;
    }

    @Override
    public List<Actividad> find(int from, int to) {
        Connection con = null;
        List listaActividad=new ArrayList();
         try {
            con = Conexion.getConnection();
           // String sql="select idproyecto,name,description,begindate,enddate,manager,registrationdate,updatedate from Proyecto  order by idproyecto ";
            String sql="select a.idactividad,a.name,a.description,a.begindate,a.enddate,a.registrationdate,a.updatedate,p.idproyecto from actividad a, proyecto p where a.idactividad=p.idproyecto order by a.idactividad limit ?,?; ";                              
      //      String sql = "select u.* from user u order by u.iduser limit ?,?;"; 
            CallableStatement cstm = con.prepareCall(sql);
           cstm.setInt(1,from);
             System.out.println("el valor de from dentro del find es :"+from);
           cstm.setInt(2,to);
             System.out.println("el valor de to dentro del find es:" +to);
            ResultSet rs=cstm.executeQuery();
            while(rs.next()){
            Actividad actividad=new Actividad();
        //        proyecto.setIdProyecto(rs.getInt(1));
               actividad.setIdactividad(rs.getInt(1));
                actividad.setName(rs.getString(2));
                actividad.setDescription(rs.getString(3));
                actividad.setBegindate(rs.getString(4));
          
                actividad.setEnddate(rs.getString(5));
    
                actividad.setRegistrationdate(rs.getString(6));
                actividad.setUpdatedate(rs.getString(7));
                actividad.setIdproyecto(rs.getInt(8));
               // Almaceno el objeto en la lista
               listaActividad.add(actividad);
            }
             
            System.out.println("Exito cargaListaActividadGridDao");
        } catch (Exception e) {
            System.out.println("Error cargaListaActividadGridDao" + e.getMessage());
            e.printStackTrace();
        }
        return listaActividad;
    }
    
    public Actividad obtenerListadoActividadIdDao(String var) throws Exception {
      //  List listaPersonal=new ArrayList();
         Connection con=null;
           Actividad actividad=new Actividad();
         try{
             con=Conexion.getConnection();
             String sql="call pa_buscaActividadId(?)";
             CallableStatement stm=con.prepareCall(sql);
             stm.setString(1,var);
             ResultSet rs=stm.executeQuery();
            
             while(rs.next()){
              
               actividad.setIdactividad(rs.getInt(1));
               actividad.setName(rs.getString(2));
               actividad.setDescription(rs.getString(3));
               actividad.setBegindate(rs.getString(4));
               actividad.setEnddate(rs.getString(5));
    
               actividad.setRegistrationdate(rs.getString(6));
               actividad.setUpdatedate(rs.getString(7));
               actividad.setIdproyecto(rs.getInt(8));

               // Almaceno el objeto en la lista
              // listaPersonal.add(personal);
             }
             System.out.println("Exito ObtenerListaActividadIdDao");
             rs.close();
             stm.close();
             con.close();
         }catch(Exception e){
             System.out.println("Error ObtenerListaActividadIdDao"+e.getMessage());
       //      e.printStackTrace();
         }
         return actividad;
    }
    
    public boolean actualizaActividadDao(Actividad actividad) throws Exception {
    Connection con=null;
        try {
            con=Conexion.getConnection();
            String sql="call pa_actualizaActividad(?,?,?,?,?,?,?,?);";
            CallableStatement stm = con.prepareCall(sql);
           stm.setInt(1, actividad.getIdactividad());
            stm.setString(2, actividad.getName());
            stm.setString(3, actividad.getDescription());
            stm.setString(4, actividad.getBegindate());
            stm.setString(5, actividad.getEnddate());
           
            stm.setString(6, actividad.getRegistrationdate());
            stm.setString(7, actividad.getUpdatedate());
             stm.setInt(8, actividad.getIdproyecto());
            stm.executeUpdate();
            stm.close();
            con.close();
            System.out.println("Exito al Actualizar ActividadDao");
            return true;           
        } catch (Exception e) {
            System.out.println("Erro al Actualizar ActividadDao :"+e.getMessage());
          //  e.printStackTrace();
            return false;
        } 
    }
}




 

   
