package com.MyAzienda.SpringDataJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringDataJPA.models.Studente;

@Repository
public interface IStudenteRepository extends JpaRepository<Studente, Long>{
	
	List<Studente> findByCognome(String cognome);
	List<Studente> findByNome(String nome);

	List<Studente> findByNomeAndCognome(String nome, String cognome);
	
	/*
	 * findAll()
	 * findById(id)
	 * save(entity)
	 * deleteById(id)
	 * existById(id)
	 */
	
}
