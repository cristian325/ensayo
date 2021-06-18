package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.prueba.models.entity.Operador;
import com.prueba.models.model.PorcentajeOperadorDTO;
import com.prueba.models.service.IOperadorService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/operador")
public class OperadoController {

	@Autowired
	IOperadorService objOperadorService;
	
	@GetMapping("/operadores")
	public ResponseEntity<List<Operador>> getAllOperadors(){
		List<Operador> operadorsList = objOperadorService.getAllOperadors();
		if(operadorsList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(operadorsList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(operadorsList);
	}
	
	@GetMapping("/paged")
	public ResponseEntity<?> getAllOperadors(Pageable pageable){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(objOperadorService.getAll(pageable));
	
	}
	
	
	@PostMapping("/operadores")
	public ResponseEntity<Operador>createOperator(@RequestBody Operador objOperador){
		Operador newOperator = objOperadorService.createOperador(objOperador);
		return ResponseEntity.status(HttpStatus.CREATED).body(newOperator);
	}
	 
	@PutMapping("/operadores/{id}")
	public ResponseEntity<Operador>updateOperador(@RequestBody Operador ObjOperador, @PathVariable Long id){
		
		Operador updateObjOperador = objOperadorService.updateOperador(ObjOperador, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateObjOperador);
	}
	
	@DeleteMapping("/operadores/{id}")	
	public void deleteOperador(@PathVariable Long id){
		objOperadorService.deleteOperator(id);
	}

	@GetMapping("/operadores/{id}")
	public ResponseEntity<Operador>getOperador(@PathVariable Long id){
		Operador objOperador = objOperadorService.getOperador(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(objOperador);
	}
	
	@GetMapping("operadores/porcentaje")
	public ResponseEntity<List<PorcentajeOperadorDTO>>lista(){
		List<PorcentajeOperadorDTO> miLista = objOperadorService.listaPorcentaje();
		for (PorcentajeOperadorDTO porcentajeOperadorDTO : miLista) {
			
			System.out.println(porcentajeOperadorDTO.getNombreOperador());
			System.out.println(porcentajeOperadorDTO.getPorcentajeOperador());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(objOperadorService.listaPorcentaje());
	}
}
