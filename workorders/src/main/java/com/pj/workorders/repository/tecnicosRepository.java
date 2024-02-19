package com.pj.workorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pj.workorders.domain.tecnicos;
import org.springframework.stereotype.Repository;

@Repository
public interface tecnicosRepository extends JpaRepository<tecnicos, Long>
{    
    
}
