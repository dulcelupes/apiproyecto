/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.domain;

import com.pj.workorders.enums.GenStatus;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author HP1
 */
@Entity
@Table(name = "tickets")

public class tickets implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tecnicos_id", nullable = false)
    private tecnicos tecnicos;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tareas_id", nullable = false)
    private tareas tareas;    

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_entrega")
    @NotNull
    private Date fechaEntrega;
    
    @Column(name = "estatus")
    @Enumerated(EnumType.STRING)
    @NotNull
    private GenStatus status;    

    @NotNull
    private Boolean correctiva;  

    public tickets() {
        this.fechaEntrega = new Date();
        this.status = GenStatus.ACTIVO;
        this.correctiva = true;
    }
    
   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    
    public tecnicos getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(tecnicos tecnicos) {
        this.tecnicos = tecnicos;
    }   

    public tareas getTareas() {
        return tareas;
    }

    public void setTareas(tareas tareas) {
        this.tareas = tareas;
    }    
    
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }      
    
    public GenStatus getStatus() {
        return status;
    }

    public void setStatus(GenStatus status) {
        this.status = status;
    }

   public Boolean getCorrectiva() {
        return correctiva;
    }

    public void setCorrectiva(Boolean correctiva) {
        this.correctiva = correctiva;
    }    
}
