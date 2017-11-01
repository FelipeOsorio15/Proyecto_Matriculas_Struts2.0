/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.apliweb.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author pc
 */
public class LogoutUsuarioAction extends ActionSupport {
    
    public LogoutUsuarioAction() {
    }
    
    public String execute() throws Exception {
        Map sessionLogout=ActionContext.getContext().getSession();
        sessionLogout.remove("sesion");
        addActionMessage("Ha salido de su Sesion");
        return SUCCESS;
    }
    
}
