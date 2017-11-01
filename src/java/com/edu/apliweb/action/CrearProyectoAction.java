/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;

import com.edu.apliweb.bean.Proyecto;
import com.edu.apliweb.bean.Usuario;

import com.edu.apliweb.dao.ProyectoDao;
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
public class CrearProyectoAction extends ActionSupport {
    
    private Integer rows = 0;
    private Integer page = 0;
    private String sord;
    private String sidx;
    private String searchField;
    private String searchString;
    private String searchOper;
    private List<Proyecto> gridModel = null;
    private Integer total = 0;
    // All Record
    private Integer records = 0;
    private List<Proyecto> listaProyecto = null;
    Proyecto proyecto;
     Usuario usuario;

    public CrearProyectoAction() {
    }

    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String execute() {
        try {
            Map session = ActionContext.getContext().getSession();
            if (session.get("sesion") == null) {
                System.out.println("No esta creada la sesion");
                return ERROR;
            } else {
                System.out.println("Sesion Creada");
                ProyectoDao pd = new ProyectoDao();
                listaProyecto = new ArrayList<Proyecto>();
                
                setRecords(pd.count());
                int to = (getRows() * getPage());
                int from = to - getRows();
                if (to > getRecords()) {
                    to = getRecords();
                }
                System.out.println("el avlor de from antes de llamar a find es :" +from);
                System.out.println("el valor de to antes de llamar a find es "+to);
                listaProyecto = pd.find(from, to);
                System.out.println("el valor de from despues del find es :"+from);
                setGridModel(listaProyecto);
                total = (int) Math.ceil((double) records / (double) rows);
                listaProyecto = pd.obtenerListaProyectoDao();
                System.out.println("Exito CargaListadoProyectoAction"+listaProyecto);
                
                return SUCCESS;
            }
        } catch (Exception e) {
            System.out.println("Error CargaListadoProyectoAction" + e.getMessage());
            e.printStackTrace();
            addActionMessage("Error al Cargar la Pagina");
            return ERROR;
        }
    }

    public String getJSON() {
        System.out.println("Entra a JSON");
        return execute();
    }
    
   
    public List<Proyecto> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<Proyecto> gridModel) {
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
}
