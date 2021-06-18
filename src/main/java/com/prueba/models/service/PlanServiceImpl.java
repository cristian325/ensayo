package com.prueba.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.models.dao.PlanDAO;
import com.prueba.models.entity.Plan;
@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	PlanDAO objPlanDAO;
	@Override
	public Plan createPlan(Plan objPlan) {
		
		return objPlanDAO.save(objPlan);
	}

	@Override	
	public Plan updatePlan(Plan objPlan, Long idPlan) {
		Plan updatePlan = objPlanDAO.findById(idPlan).get();
		updatePlan.setPlan(objPlan.getPlan());
		updatePlan.setTotalMinutos(objPlan.getTotalMinutos());
		updatePlan.setTotalDatos(objPlan.getTotalDatos());
		return objPlanDAO.save(updatePlan);
	}

	@Override
	public void deletePlan(Long idPlan) {
		objPlanDAO.deleteById(idPlan);

	}

	@Override
	public Plan getPlan(Long idPlan) {
		
		return objPlanDAO.findById(idPlan).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Plan> getAllPlanes() {
		
		return objPlanDAO.findAll();
	}

}
