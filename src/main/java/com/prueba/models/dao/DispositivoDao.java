package com.prueba.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.models.entity.Dispositivo;

public interface DispositivoDao extends JpaRepository<Dispositivo, Long> {
	
	public Dispositivo findByReferencia(String referencia);

}
