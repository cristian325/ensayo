package com.prueba.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.models.dao.SimcardDAO;
import com.prueba.models.entity.Simcard;
@Service
public class SimcardServiceImpl implements ISimcardService {
	//Creamos una inyeccion de depencia de la interfaz DAO
	@Autowired
	SimcardDAO objSimcardDAO;

	@Override
	@Transactional
	public Simcard createSimcard(Simcard objSimcard) {	
		//Metodo para crear una simcard el cual retorna la simcard creada.
		return objSimcardDAO.save(objSimcard);
	}

	@Override
	public Simcard updateSimcard(Simcard objSimcard, Long idSimcard) {
		/*Metodo para actualizar una simcard
		 *Se busca una simcard por Id la cual retorna un Optional que debe ser casteado,
		 *con el ".get()"*/
		Simcard objUpdateSimcard = objSimcardDAO.findById(idSimcard).get();
		/*Se actualiza la simcard con los datos que llegan por parámetro*/
		objUpdateSimcard.setNumero(objSimcard.getNumero());
		objUpdateSimcard.setEstado(objSimcard.getEstado());
		objUpdateSimcard.setObjOperador(objSimcard.getObjOperador());
		/* Se guarda el objeto actualizado con el save el cual modifica los valores del
		 * registro almacenado en la BD*/
		return objSimcardDAO.save(objUpdateSimcard);
	}

	@Override
	public void deleteSimcard(Long idSimcard) {
		// Elimina un registro de Simcard dado un identificador
		objSimcardDAO.deleteById(idSimcard);

	}

	@Override
	public Simcard getSimcard(Long idSimcard) {
		// Obtiene un registro de simcard dado un identificador, este registro,
		// debe ser casteado con el ".get()" ya que la acción retorna un Optional.
		return objSimcardDAO.findById(idSimcard).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Simcard> getAllSimcards() {
		// Obtiene todos los registros almacenados referentes a Simcards
		return objSimcardDAO.findAll();
	}

}
