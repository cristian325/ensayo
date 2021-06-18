package com.prueba.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.models.entity.Plan;

public interface PlanDAO extends JpaRepository<Plan, Long> {

}
