package com.prueba.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.models.entity.Simcard;

public interface SimcardDAO extends JpaRepository<Simcard, Long> {

}
