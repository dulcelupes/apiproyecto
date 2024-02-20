package com.pj.workorders.domain;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tecnicos")

public class tecnicos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "usuario")
    @NotNull
    private String usuario;

    @Column(name = "nombre")
    @NotNull
    private String nombre;
        
    @Column(name = "puesto")
    private String puesto;
    
    public tecnicos() {
        
    }
 
   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    
   public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }      
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
   public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }        
}
