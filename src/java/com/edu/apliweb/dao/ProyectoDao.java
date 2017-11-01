/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.dao;


import com.edu.apliweb.bean.Proyecto;

import com.edu.apliweb.service.ProyectoInterfaz;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class ProyectoDao implements ProyectoInterfaz{
 
    @Override
    public List obtenerListaProyectoDao() throws Exception {
          List listaProyecto=new ArrayList();
        //Inicializacion de la conexion;
        Connection con=null;
        try{
            //Ejecuto conexion
           con=Conexion.getConnection();
           //Procedimiento Almacenado
           String sql="select * from proyecto";
 //String sql="select p.idproyecto,p.name,p.description,p.begindate,p.enddate,p.manager,p.registrationdate,p.updatedate from Proyecto p, where  p.manager=user.iduser";
           // Precedimiento Almacenado
           CallableStatement stm=con.prepareCall(sql);
           ResultSet rs=stm.executeQuery();
           // Recorrer el ResultSet
           // para almacenar los datos de la consulta 
           while(rs.next()){
               Proyecto proyecto=new Proyecto();
        //        proyecto.setIdProyecto(rs.getInt(1));
               proyecto.setIdproyecto(rs.getInt(1));
                proyecto.setName(rs.getString(2));
                proyecto.setDescription(rs.getString(3));
                proyecto.setBegindate(rs.getString(4));
//          
                proyecto.setEnddate(rs.getString(5));
                proyecto.setManager(rs.getInt(6));
                proyecto.setRegistrationdate(rs.getString(7));
                proyecto.setUpdatedate(rs.getString(8));
               // Almaceno el objeto en la lista
               listaProyecto.add(proyecto);
           }
           System.out.println("Exito listado ProyectoDao");         
           }catch(Exception e){
           System.out.println("Error listado ProyectoDao:"+e.getMessage());
           e.printStackTrace();
           }
        // El metodo devuelve el listado de objetos
        return listaProyecto;
    }
    
    
     @Override
    public boolean ingresarProyectoDao(Proyecto proyecto) {
  Connection con=null;
        try {
            con=Conexion.getConnection();
            String sql="call pa_ingresoProyecto(?,?,?,?,?,?,?);";
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, proyecto.getName());
            stm.setString(2, proyecto.getDescription());
            stm.setString(3, proyecto.getBegindate());
            stm.setString(4, proyecto.getEnddate());
            stm.setInt(5, proyecto.getManager());
            stm.setString(6, proyecto.getRegistrationdate());
            stm.setString(7, proyecto.getUpdatedate());
            stm.executeUpdate();
            stm.close();
            con.close();
            System.out.println("Exito al Ingresar ProyectoDao");
            return true;           
        } catch (Exception e) {
            System.out.println("Erro al Ingresar ProyectoDao :"+e.getMessage());
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
            String sql = "SELECT COUNT(*) FROM proyecto";
            CallableStatement cstm = con.prepareCall(sql);
            ResultSet rs=cstm.executeQuery();
            while(rs.next()){
               count=rs.getInt(1);
            }
            System.out.println("Exito cargaCuentaProyectoDao");
        } catch (Exception e) {
            System.out.println("Error cargaCuentaProyectoDao" + e.getMessage());
            e.printStackTrace();
        }
         return count;
    }

    @Override
    public List<Proyecto> find(int from, int to) {
        Connection con = null;
        List listaProyecto=new ArrayList();
         try {
            con = Conexion.getConnection();
           // String sql="select idproyecto,name,description,begindate,enddate,manager,registrationdate,updatedate from Proyecto  order by idproyecto ";
            String sql="select p.idproyecto,p.name,p.description,p.begindate,p.enddate,p.manager,p.registrationdate,p.updatedate,u.iduser from proyecto p, user u where p.manager=u.iduser order by p.idproyecto limit ?,?; ";                              
      //      String sql = "select u.* from user u order by u.iduser limit ?,?;"; 
            CallableStatement cstm = con.prepareCall(sql);
           cstm.setInt(1,from);
             System.out.println("el valor de from dentro del find es :"+from);
           cstm.setInt(2,to);
             System.out.println("el valor de to dentro del find es:" +to);
            ResultSet rs=cstm.executeQuery();
            while(rs.next()){
          Proyecto proyecto=new Proyecto();
        //        proyecto.setIdProyecto(rs.getInt(1));
               proyecto.setIdproyecto(rs.getInt(1));
                proyecto.setName(rs.getString(2));
                proyecto.setDescription(rs.getString(3));
                proyecto.setBegindate(rs.getString(4));
          
                proyecto.setEnddate(rs.getString(5));
                proyecto.setManager(rs.getInt(6));
                proyecto.setRegistrationdate(rs.getString(7));
                proyecto.setUpdatedate(rs.getString(8));
               // Almaceno el objeto en la lista
               listaProyecto.add(proyecto);
            }
             
            System.out.println("Exito cargaListaProyectoGridDao");
        } catch (Exception e) {
            System.out.println("Error cargaListaProyectoGridDao" + e.getMessage());
            e.printStackTrace();
        }
        return listaProyecto;
    }
    
    @Override
    public boolean actualizaProyectoDao(Proyecto proyecto) throws Exception {
    Connection con=null;
        try {
            con=Conexion.getConnection();
            String sql="call pa_actualizaProyecto(?,?,?,?,?,?,?,?);";
            CallableStatement stm = con.prepareCall(sql);
           stm.setInt(1, proyecto.getIdproyecto());
            stm.setString(2, proyecto.getName());
            stm.setString(3, proyecto.getDescription());
            stm.setString(4, proyecto.getBegindate());
            stm.setString(5, proyecto.getEnddate());
            stm.setInt(6, proyecto.getManager());
            stm.setString(7, proyecto.getRegistrationdate());
            stm.setString(8, proyecto.getUpdatedate());
      
            stm.executeUpdate();
            stm.close();
            con.close();
            System.out.println("Exito al Actualizar ProyectoDao");
            return true;           
        } catch (Exception e) {
            System.out.println("Erro al Actualizar ProyectoDao :"+e.getMessage());
          //  e.printStackTrace();
            return false;
        } 
    }
    
        @Override
    public Proyecto obtenerListadoProyectoIdDao(String var) throws Exception {
      //  List listaPersonal=new ArrayList();
         Connection con=null;
           Proyecto proyecto=new Proyecto();
         try{
             con=Conexion.getConnection();
             String sql="call pa_buscaProyectoId(?)";
             CallableStatement stm=con.prepareCall(sql);
             stm.setString(1,var);
             ResultSet rs=stm.executeQuery();
            
             while(rs.next()){
              
               proyecto.setIdproyecto(rs.getInt(1));
               proyecto.setName(rs.getString(2));
               proyecto.setDescription(rs.getString(3));
               proyecto.setBegindate(rs.getString(4));
               proyecto.setEnddate(rs.getString(5));
               proyecto.setManager(rs.getInt(6));
               proyecto.setRegistrationdate(rs.getString(7));
               proyecto.setUpdatedate(rs.getString(8));

               // Almaceno el objeto en la lista
              // listaPersonal.add(personal);
             }
             System.out.println("Exito ObtenerListaProyectoIdDao");
             rs.close();
             stm.close();
             con.close();
         }catch(Exception e){
             System.out.println("Error ObtenerListaproyectoIdDao"+e.getMessage());
       //      e.printStackTrace();
         }
         return proyecto;
    }
    
}




 

   
