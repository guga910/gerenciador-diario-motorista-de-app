package com.example.gerenciadordiariomotoristadeapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaMotorista;

@Repository
public interface DiariaMotoristaRepository extends JpaRepository< DiariaMotorista,Long>{

	@Query("SELECT b FROM DiariaMotorista b WHERE b.dia >= :inicio AND b.dia <= :fim")
	List<DiariaMotorista> findBySemanaDoDia(LocalDate inicio, LocalDate fim );
//	findById
	
	
	
	
}
