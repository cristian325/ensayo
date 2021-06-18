package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.models.entity.Dispositivo;
import com.prueba.models.service.IdispositivoService;

@RestController
public class DispositivoController {
	@Autowired
	IdispositivoService objDispositivoService;
	
	@GetMapping("/getAllDevices")
	public ResponseEntity<List<Dispositivo>> getAllDevices(){
		List<Dispositivo> deviceList = objDispositivoService.getAllDevices();
		if(deviceList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deviceList);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(deviceList);
	};
	@PostMapping("/createDevice")
	public ResponseEntity<Dispositivo> createDevice(@RequestBody Dispositivo parDispositivo){
		Dispositivo objDispositivo = objDispositivoService.createDevice(parDispositivo);
		if(objDispositivo == null) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(objDispositivo);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(objDispositivo);
		
	}
	
	@DeleteMapping("/deleteDevice/{referencia}")
	public ResponseEntity<Boolean> deleteDevice(@PathVariable String referencia){
		if(objDispositivoService.deleteDevice(referencia)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		}
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
		
	}
	
	@PutMapping("/updateDevice")
	public ResponseEntity<Dispositivo> updateDevice(@RequestBody Dispositivo parDispositvo){
		Dispositivo objDispositivo = objDispositivoService.updateDevice(parDispositvo);
		if(objDispositivo == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(objDispositivo);
		}
		
		 return ResponseEntity.status(HttpStatus.OK).body(objDispositivo);
	}
}
