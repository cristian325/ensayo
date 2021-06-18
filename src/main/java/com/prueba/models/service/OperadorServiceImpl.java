package com.prueba.models.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.models.dao.IOperadorDao;
import com.prueba.models.entity.Operador;
import com.prueba.models.model.PorcentajeOperadorDTO;
@Service
public class OperadorServiceImpl implements IOperadorService {

	@Autowired
	IOperadorDao objOperadorDao;
	
	@Override
	@Transactional
	public Operador createOperador(Operador objOperador) {
		
		return objOperadorDao.save(objOperador);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Operador> getAllOperadors() {	
		return objOperadorDao.findAll();
	}

	@Override
	public Operador updateOperador(Operador objOperador, Long id) {
		
		Operador updateObjOperador = objOperadorDao.findById(id).get();
		updateObjOperador.setOperador(objOperador.getOperador());
		updateObjOperador.setBanda(objOperador.getBanda());
		return objOperadorDao.save(updateObjOperador);
	}

	@Override
	public void deleteOperator(Long operadorId) {	
			objOperadorDao.deleteById(operadorId);		
	}

	@Override
	public List<PorcentajeOperadorDTO> listaPorcentaje() {
		
		return objOperadorDao.porcentajeOperadores();
	}

	@Override
	public Operador getOperador(Long idOperador) {
	
		return objOperadorDao.findById(idOperador).get();
	}

	@Override
	public Page<Operador> getAll(Pageable pageable) {
		
		return objOperadorDao.findAll(pageable);
	}

}
