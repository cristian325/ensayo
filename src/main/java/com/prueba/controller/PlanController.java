package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.prueba.models.entity.Plan;
import com.prueba.models.service.IPlanService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	IPlanService objPlanService;
	
	@GetMapping("/planes")
	public ResponseEntity<List<Plan>>getAllPlanes(){
		List<Plan> listPlanes = objPlanService.getAllPlanes();
		if(listPlanes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listPlanes);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listPlanes);
	}
	
	@PostMapping("/planes")
	public ResponseEntity<Plan> createPlan(@RequestBody Plan objPlan){
		Plan newPlan = objPlanService.createPlan(objPlan);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPlan);		
	}
	
	@PutMapping("/planes/{id}")
	public ResponseEntity<Plan> updatePlan(@RequestBody Plan objPlan , @PathVariable Long id){
		Plan updatePlan = objPlanService.updatePlan(objPlan, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatePlan);
	}
	
	@DeleteMapping("/planes/{id}")	
	public void deletePlan(@PathVariable Long id){
		objPlanService.deletePlan(id);
	}
	
	@GetMapping("/planes/{id}")
	public ResponseEntity<Plan>getOperador(@PathVariable Long id){
		Plan objPlan = objPlanService.getPlan(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(objPlan);
	}
}
