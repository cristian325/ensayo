package com.prueba.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.models.entity.Operador;
import com.prueba.models.model.PorcentajeOperadorDTO;

public interface IOperadorService {

	public Operador createOperador(Operador objOperador);
	
	public Operador updateOperador(Operador objOperador ,Long id);
	
	public void deleteOperator(Long idOperador);
	
	public Operador getOperador(Long idOperador);
	
	public List<Operador> getAllOperadors();
	
	public List<PorcentajeOperadorDTO> listaPorcentaje();
	
	public Page<Operador> getAll(Pageable pageable);
	
}
