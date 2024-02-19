package com.pj.workorders.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.pj.workorders.enums.GenStatus;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tareas")
@Data
public class tareas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "descripcion")
    @NotNull
    private String descripcion;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    @NotNull
    private Date fechaCreacion;
    
    @Column(name = "estatus")
    @Enumerated(EnumType.STRING)
    @NotNull
    private GenStatus status;    
    
    public tareas() {
        this.fechaCreacion = new Date();
        this.status = GenStatus.ACTIVO;
        
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
