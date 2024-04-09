package com.crud.reglas.repository;

import com.crud.reglas.entities.Reglas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglasRepository extends JpaRepository<Reglas, Long> {
}
