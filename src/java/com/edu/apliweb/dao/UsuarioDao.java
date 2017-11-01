/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.dao;

import com.edu.apliweb.bean.Usuario;
import com.edu.apliweb.service.UsuarioInterfaz;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class UsuarioDao implements UsuarioInterfaz{
    @Override
    public Usuario loginUsuarioDao(String usu, String pass) {
         Connection con=null;
        Usuario usuario=new Usuario();
        try{
            con=Conexion.getConnection();
            String sql="call pa_login(?,?);";
            CallableStatement stm=con.prepareCall(sql);
            // inserto el id a consultar
            stm.setString(1, usu);
            stm.setString(2,pass);
            ResultSet rs=stm.executeQuery();  
            while(rs.next()){
                // capturo el objet         
                usuario.setIduser(rs.getInt(1));
                usuario.setName(rs.getString(2));
                usuario.setLastname(rs.getString(3));
                usuario.setDocid(rs.getInt(4));
          
                usuario.setUsername(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                usuario.setEmail(rs.getString(7));
              //  usuario.setEstado(rs.getInt(5));
               // TipoUsuario tipousuario=new TipoUsuario();
              //  tipousuario.setIdTipoUsuario(rs.getInt(6));
             //   usuario.setTipousuario(tipousuario);
            }
            System.out.println("Exito LoginUsuarioDao");
        }catch(Exception e){
            System.out.println("Error LoginUsuarioDao"+e.getMessage());
            e.printStackTrace();
        }
        // se retorna el objeto medico
        return usuario;
    }
   
    @Override
    public List obtenerListaUsuarioDao() throws Exception {
          List listaUsuario=new ArrayList();
        //Inicializacion de la conexion;
        Connection con=null;
        try{
            //Ejecuto conexion
           con=Conexion.getConnection();
           //Procedimiento Almacenado
           String sql="select * from user";
           // Precedimiento Almacenado
           CallableStatement stm=con.prepareCall(sql);
           ResultSet rs=stm.executeQuery();
           // Recorrer el ResultSet
           // para almacenar los datos de la consulta 
           while(rs.next()){
               Usuario usuario=new Usuario();
                usuario.setIduser(rs.getInt(1));
                usuario.setName(rs.getString(2));
                usuario.setLastname(rs.getString(3));
                usuario.setDocid(rs.getInt(4));
          
                usuario.setUsername(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                usuario.setEmail(rs.getString(7));
               // Almaceno el objeto en la lista
               listaUsuario.add(usuario);
           }
           System.out.println("Exito listado UsuarioDao");         
           }catch(Exception e){
           System.out.println("Error listado UsuarioDao:"+e.getMessage());
           e.printStackTrace();
           }
        // El metodo devuelve el listado de objetos
        return listaUsuario;
    }
    
    
     @Override
    public boolean ingresarUsuarioDao(Usuario usuario) {
  Connection con=null;
        try {
            con=Conexion.getConnection();
            String sql="call pa_ingresoUsuario(?,?,?,?,?,?);";
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, usuario.getName());
            stm.setString(2, usuario.getLastname());
            stm.setInt(3, usuario.getDocid());
            stm.setString(4, usuario.getUsername());
            stm.setString(5, usuario.getPassword());
            stm.setString(6, usuario.getEmail());
            stm.executeUpdate();
            stm.close();
            con.close();
            System.out.println("Exito al Ingresar UsuarioDao");
            return true;           
        } catch (Exception e) {
            System.out.println("Erro al Ingresar UsuarioDao :"+e.getMessage());
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
            String sql = "SELECT COUNT(*) FROM user";
            CallableStatement cstm = con.prepareCall(sql);
            ResultSet rs=cstm.executeQuery();
            while(rs.next()){
               count=rs.getInt(1);
            }
            System.out.println("Exito cargaCuentaUsuarioDao");
        } catch (Exception e) {
            System.out.println("Error cargaCuentaUsuarioDao" + e.getMessage());
           // e.printStackTrace();
        }
         return count;
    }

    @Override
    public List<Usuario> find(int from, int to) {
        Connection con = null;
        List listaUsuario=new ArrayList();
         try {
            con = Conexion.getConnection();
          //  String sql="select * from user order by iduser limit ?,?;";
            String sql="select u.* from user u order by u.iduser limit ?,?;";
      //      String sql = "select u.* from user u order by u.iduser limit ?,?;"; 
            CallableStatement cstm = con.prepareCall(sql);
           cstm.setInt(1,from);
           cstm.setInt(2,to);
            ResultSet rs=cstm.executeQuery();
            while(rs.next()){
          Usuario usuario=new Usuario();
                  usuario.setIduser(rs.getInt(1));
                usuario.setName(rs.getString(2));
                usuario.setLastname(rs.getString(3));
                usuario.setDocid(rs.getInt(4));
          
                usuario.setUsername(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                usuario.setEmail(rs.getString(7));
               // Almaceno el objeto en la lista
               listaUsuario.add(usuario);
            }
             
            System.out.println("Exito cargaListaUsuarioGridDao");
        } catch (Exception e) {
            System.out.println("Error cargaListaUsuarioGridDao" + e.getMessage());
          //  e.printStackTrace();
        }
        return listaUsuario;
    }
    
    @Override
    public Usuario obtenerListadoUsuarioIdDao(String var) throws Exception {
      //  List listaPersonal=new ArrayList();
         Connection con=null;
           Usuario usuario=new Usuario();
         try{
             con=Conexion.getConnection();
             String sql="call pa_buscaUsuarioId(?)";
             CallableStatement stm=con.prepareCall(sql);
             stm.setString(1,var);
             ResultSet rs=stm.executeQuery();
            
             while(rs.next()){
              
               usuario.setIduser(rs.getInt(1));
               usuario.setName(rs.getString(2));
               usuario.setLastname(rs.getString(3));
               usuario.setDocid(rs.getInt(4));
               usuario.setUsername(rs.getString(5));
               usuario.setPassword(rs.getString(6));
               usuario.setEmail(rs.getString(7));
               
               // Almaceno el objeto en la lista
              // listaPersonal.add(personal);
             }
             System.out.println("Exito ObtenerListaUsuarioIdDao");
             rs.close();
             stm.close();
             con.close();
         }catch(Exception e){
             System.out.println("Error ObtenerListaUsuarioIdDao"+e.getMessage());
       //      e.printStackTrace();
         }
         return usuario;
    }
    
    /**
     *
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
public boolean actualizaUsuarioDao(Usuario usuario) throws Exception {
    Connection con=null;
        try {
            con=Conexion.getConnection();
            String sql="call pa_actualizaUsuario(?,?,?,?,?,?,?);";
            CallableStatement stm = con.prepareCall(sql);
           stm.setInt(1, usuario.getIduser());
            stm.setString(2, usuario.getName());
            stm.setString(3, usuario.getLastname());
            stm.setInt(4, usuario.getDocid());
            stm.setString(5, usuario.getUsername());
            stm.setString(6, usuario.getPassword());
            stm.setString(7, usuario.getEmail());
            stm.executeUpdate();
            stm.close();
            con.close();
            System.out.println("Exito al Actualizar UsuarioDao");
            return true;           
        } catch (Exception e) {
            System.out.println("Erro al Actualizar UsuarioDao :"+e.getMessage());
          //  e.printStackTrace();
            return false;
        } 
    }
}




 

   
