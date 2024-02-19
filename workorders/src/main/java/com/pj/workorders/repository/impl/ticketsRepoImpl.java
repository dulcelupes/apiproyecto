package com.pj.workorders.repository.impl;

import com.pj.workorders.domain.tickets;
import java.util.List;
import javax.persistence.Query;
import org.springframework.context.annotation.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP1
 */


public class ticketsRepoImpl extends TenantRepoImpl{
    
    public List<tickets> gettickets(Long idtecnico) {

        String strQuery
                = "FROM "
                + tickets.class.getSimpleName() + " c "
                + "WHERE "
                + "c.tecnicos = :idtecnico "
                + "ORDER BY "
                + "c.fechaEntrega DESC";

        Query q = createQuery(strQuery);

        q.setParameter("idtecnico", idtecnico);

        List<tickets> listResul = q.getResultList();

        return listResul;

    }
}
