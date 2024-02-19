/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.repository.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 *
 * @author HP1
 */
public class TenantRepoImpl {
    
    @PersistenceContext(unitName = "tenant-persistence-unit")
    public EntityManager em;

    protected Query createQuery(String s) {
        return em.createQuery(s);
    }

    protected Query createQuery(String s, Class clase) {
        return em.createQuery(s, clase);
    }

    protected Query createNativeQuery(String s) {
        return em.createNativeQuery(s);
    }

    protected TypedQuery<Tuple> createQueryTuple(String s) {
        return em.createQuery(s, Tuple.class);
    }

    protected TypedQuery createQueryCriteria(CriteriaQuery c) {
        return em.createQuery(c);
    }

    protected CriteriaBuilder createCriteriaBuilder() {
        return em.getCriteriaBuilder();
    }

    public void limpiarMemoria() {
        em.flush();
        em.clear();
    }

    public Object cargaListasLizy(Object fromObj) {
        if (fromObj == null) {
            throw new NullPointerException("Source and destination objects must be non-null");
        }
        if (fromObj instanceof HibernateProxy) {
           fromObj =  Hibernate.unproxy(fromObj);
        }
        Class fromClass = fromObj.getClass();

        Field[] fields = fromClass.getDeclaredFields();
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                if (f.getType().equals(List.class)) {
                    List lista = (List) f.get(fromObj);
                    if (lista != null) {
                        lista.size();
                    }
                } else if (f.getType().equals(Set.class)) {
                    Set set = (Set) f.get(fromObj);
                    if (set != null) {
                        set.size();
                    }
                }
            } // skip it
            catch (IllegalAccessException ex) {
            }
        }
        return fromObj;
    }
}

