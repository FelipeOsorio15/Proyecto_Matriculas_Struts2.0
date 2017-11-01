/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;


import com.edu.apliweb.bean.Actividad;
import com.edu.apliweb.dao.ActividadDao;

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
public class CrearActividadAction extends ActionSupport {
    
    private Integer rows = 0;
    private Integer page = 0;
    private String sord;
    private String sidx;
    private String searchField;
    private String searchString;
    private String searchOper;
    private List<Actividad> gridModel = null;
    private Integer total = 0;
    // All Record
    private Integer records = 0;
    private List<Actividad> listaActividad = null;
    //Proyecto proyecto;
     private Actividad actividad;

    public CrearActividadAction() {
    }
    
    public String execute() {
        try {
            Map session = ActionContext.getContext().getSession();
            if (session.get("sesion") == null) {
                System.out.println("No esta creada la sesion");
                return ERROR;
            } else {
                System.out.println("Sesion Creada");
                ActividadDao pd = new ActividadDao();
                listaActividad = new ArrayList<Actividad>();
                
                setRecords(pd.count());
                int to = (getRows() * getPage());
                int from = to - getRows();
                if (to > getRecords()) {
                    to = getRecords();
                }
                System.out.println("el avlor de from antes de llamar a find es :" +from);
                System.out.println("el valor de to antes de llamar a find es "+to);
                listaActividad = pd.find(from, to);
                System.out.println("el valor de from despues del find es :"+from);
                setGridModel(listaActividad);
                total = (int) Math.ceil((double) records / (double) rows);
                listaActividad = pd.obtenerListaActividadDao();
                System.out.println("Exito CargaListadoActividadAction"+listaActividad);
                
                return SUCCESS;
            }
        } catch (Exception e) {
            System.out.println("Error CargaListadoActividadAction" + e.getMessage());
            e.printStackTrace();
            addActionMessage("Error al Cargar la Pagina");
            return ERROR;
        }
    }


    /**
     * @return the rows
     */
    public Integer getRows() {
        return rows;
    }
public String getJSON() {
        System.out.println("Entra a JSON");
        return execute();
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return the sord
     */
    public String getSord() {
        return sord;
    }

    /**
     * @param sord the sord to set
     */
    public void setSord(String sord) {
        this.sord = sord;
    }

    /**
     * @return the sidx
     */
    public String getSidx() {
        return sidx;
    }

    /**
     * @param sidx the sidx to set
     */
    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    /**
     * @return the searchField
     */
    public String getSearchField() {
        return searchField;
    }

    /**
     * @param searchField the searchField to set
     */
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the searchString
     */
    public String getSearchString() {
        return searchString;
    }

    /**
     * @param searchString the searchString to set
     */
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    /**
     * @return the searchOper
     */
    public String getSearchOper() {
        return searchOper;
    }

    /**
     * @param searchOper the searchOper to set
     */
    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    /**
     * @return the gridModel
     */
    public List<Actividad> getGridModel() {
        return gridModel;
    }

    /**
     * @param gridModel the gridModel to set
     */
    public void setGridModel(List<Actividad> gridModel) {
        this.gridModel = gridModel;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return the records
     */
    public Integer getRecords() {
        return records;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(Integer records) {
        this.records = records;
    }

    /**
     * @return the listaProyecto
     */
    public List<Actividad> getListaActividad() {
        return listaActividad;
    }

    /**
     * @param listaActividad the listaProyecto to set
     */
    public void setListaActividad(List<Actividad> listaActividad) {
        this.listaActividad = listaActividad;
    }

    /**
     * @return the actividad
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * @param actividad the actividad to set
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
}
