/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pj.workorders.enums.GenStatus;
import com.sun.istack.NotNull;
import java.util.Date;

/**
 *
 * @author HP1
 */
public class ticketsRespDTO {
    
    public Long id;

    @NotNull
    public Long tecnicos_id;
    
    @NotNull
    public Long tareas_id;    

    public Date fechaEntrega;
    
    public GenStatus status;    

    // 0 es true 1 false
    public Boolean correctiva;    

    public ticketsRespDTO() {
        this.fechaEntrega = new Date();
        this.status = GenStatus.ACTIVO;
    }

    public Boolean getCorrectiva() {
        return correctiva;
    }

    public void setCorrectiva(Boolean correctiva) {
        this.correctiva = correctiva;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenStatus getStatus() {
        return status;
    }

    public void setStatus(GenStatus status) {
        this.status = status;
    }

    public Long getTareas_id() {
        return tareas_id;
    }

    public void setTareas_id(Long tareas_id) {
        this.tareas_id = tareas_id;
    }

    public Long getTecnicos_id() {
        return tecnicos_id;
    }

    public void setTecnicos_id(Long tecnicos_id) {
        this.tecnicos_id = tecnicos_id;
    }
    
    
    
}
