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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public class CrearUsuarioAction extends ActionSupport {
    
   private Integer rows = 0;
    private Integer page = 0;
    private String sord;
    private String sidx;
    private String searchField;
    private String searchString;
    private String searchOper;
    private List<Usuario> gridModel = null;
    private Integer total = 0;
    // All Record
    private Integer records = 0;
    private List<Usuario> listaUsuario = null;
    Usuario usuario;

    public CrearUsuarioAction() {
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String execute() {
        try {
            Map session = ActionContext.getContext().getSession();
            if (session.get("sesion") == null) {
                System.out.println("No esta creada la sesion");
                return ERROR;
            } else {
                System.out.println("Sesion Creada");
                 UsuarioDao pd = new UsuarioDao();
                listaUsuario = new ArrayList<Usuario>();
               
                setRecords(pd.count());
                int to = (getRows() * getPage());
                int from = to - getRows();
                if (to > getRecords()) {
                    to = getRecords();
                
                }
                listaUsuario = pd.find(from, to);
                setGridModel(listaUsuario);
                total = (int) Math.ceil((double) records / (double) rows);


                listaUsuario = pd.obtenerListaUsuarioDao();
                System.out.println("Exito CargaListadoUsuarioAction");
                return SUCCESS;
            }
        } catch (Exception e) {
            System.out.println("Error CargaListadoUsuarioAction" + e.getMessage());
            e.printStackTrace();
            addActionMessage("Error al Cargar la Pagina");
            return ERROR;
        }
    }

    public String getJSON() {
        System.out.println("Entra a JSON");
        return execute();
    }

    public List<Usuario> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<Usuario> gridModel) {
        this.gridModel = gridModel;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchOper() {
        return searchOper;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
