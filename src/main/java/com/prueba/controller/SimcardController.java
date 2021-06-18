package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.models.entity.Simcard;
import com.prueba.models.service.ISimcardService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/simcard")
public class SimcardController {
	@Autowired
	ISimcardService objSimcardService;
	
	@PostMapping("/simcards")
	public ResponseEntity<Simcard> createSimcard(@RequestBody Simcard objSimcard){
		Simcard newSimcard = objSimcardService.createSimcard(objSimcard);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSimcard);
	}
	
	@PutMapping("/simcards/{id}")
	public ResponseEntity<Simcard>updateSimcard(@RequestBody Simcard objSimcard, @PathVariable Long id){
		Simcard updateSimcard = objSimcardService.updateSimcard(objSimcard, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateSimcard);
	}
	
	@GetMapping("/simcards")
	public ResponseEntity<List<Simcard>> getAllSimcards(){
		List<Simcard> allSimcards = objSimcardService.getAllSimcards();
		if(allSimcards.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(allSimcards);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(allSimcards);
	}

	@GetMapping("/simcards/{id}")
	public ResponseEntity<Simcard>getSimcard(@PathVariable Long id){
		Simcard objSimcard = objSimcardService.getSimcard(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(objSimcard);
	}
	
	
}
