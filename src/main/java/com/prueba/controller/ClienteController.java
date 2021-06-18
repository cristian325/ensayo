package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.models.entity.Cliente;
import com.prueba.models.service.IclienteService;
@RestController
public class ClienteController {

	@Autowired
	IclienteService objClienteService;
	
	@GetMapping("/getAllClients")
	public ResponseEntity<List<Cliente>> getAllClients(){
		List<Cliente> clientsList = objClienteService.getAllClients();		
		if(clientsList.isEmpty()){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientsList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(clientsList);
	}
	
	@PostMapping("/createClient")
	public ResponseEntity<Cliente>createClient(@RequestBody Cliente parCliente) {
		return null;
		
		
	}
}
