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
public class tareasRespDTO {
    
    public Long id;

    @NotNull
    public String descripcion;

    public Date fechaCreacion;
    
    public GenStatus status;        

    public tareasRespDTO() {
        this.status = GenStatus.ACTIVO;
        this.fechaCreacion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public GenStatus getStatus() {
        return status;
    }

    public void setStatus(GenStatus status) {
        this.status = status;
    }
    
    
    
}
