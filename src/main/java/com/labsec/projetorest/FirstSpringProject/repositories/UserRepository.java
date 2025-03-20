package com.labsec.projetorest.FirstSpringProject.repositories;

import com.labsec.projetorest.FirstSpringProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}


