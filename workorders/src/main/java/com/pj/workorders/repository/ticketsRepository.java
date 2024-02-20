/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.repository;

import com.pj.workorders.domain.tickets;
import com.pj.workorders.enums.GenStatus;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP1
 */
@Repository
public interface ticketsRepository extends JpaRepository<tickets, Long>, Serializable
{    
    @Query("from tickets u where u.tecnicos.id = :idTecnico order by u.fechaEntrega desc")
    List<tickets> findTicketsByTecnico(@Param("idTecnico") Long idTecnico);
    
    @Query("from tickets u where u.status = :status ")
    List<tickets> findTicketsByStatus(@Param("status") GenStatus status);
}
