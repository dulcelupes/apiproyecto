/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.repository;

import com.pj.workorders.domain.tecnicos;
import com.pj.workorders.domain.tickets;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP1
 */
@Repository
public interface ticketsRepository extends JpaRepository<tickets, Long>
{    
     
}
