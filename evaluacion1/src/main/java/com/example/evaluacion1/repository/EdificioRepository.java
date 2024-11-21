package com.example.evaluacion1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluacion1.entity.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long>{
	

}
