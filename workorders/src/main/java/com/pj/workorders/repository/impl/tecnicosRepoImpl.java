/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.repository.impl;

import com.pj.workorders.domain.tecnicos;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP1
 */


public class tecnicosRepoImpl extends TenantRepoImpl{
   
    public tecnicos getTecnico(Long idtecnico) {

        String strQuery
                = "FROM "
                + tecnicos.class.getSimpleName() + " c "
                + "WHERE "
                + "c.id = :idtecnico ";

        Query q = createQuery(strQuery);

        q.setParameter("idtecnico", idtecnico);

        List result = q.getResultList();
        if (!result.isEmpty()) {
            return (tecnicos) result.get(0);
        }
        return null;
    }    
}
