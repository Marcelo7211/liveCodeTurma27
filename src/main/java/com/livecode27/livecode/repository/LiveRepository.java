package com.livecode27.livecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livecode27.livecode.model.Live;

/**
 * Palavras sabias de Freitas -> O repositorio serve prara fazer conexão com o banco de dados!!!
 * Palavras de José e Nubia - > tambem faz as consultas
 * 
 * */

@Repository
public interface LiveRepository extends JpaRepository<Live, Long> {
	//TODO Fazer os metodos de consultas
	
	
	/**
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	 * 
	 * Criando methods name
	 * */
	public List<Live> findByNomeContainingIgnoreCase(String nome);
}
