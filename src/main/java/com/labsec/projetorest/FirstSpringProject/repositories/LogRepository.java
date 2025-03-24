package com.labsec.projetorest.FirstSpringProject.repositories;

import com.labsec.projetorest.FirstSpringProject.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}