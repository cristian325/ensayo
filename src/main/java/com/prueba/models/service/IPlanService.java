package com.prueba.models.service;

import java.util.List;

import com.prueba.models.entity.Plan;

public interface IPlanService {

	public Plan createPlan(Plan objPlan);
	
	public Plan updatePlan(Plan objPlan, Long idPlan);
	
	public void deletePlan(Long idPlan);
	
	public Plan getPlan(Long idPlan);
	
	public List<Plan> getAllPlanes();
}
