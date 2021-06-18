package com.prueba.models.service;

import java.util.List;

import com.prueba.models.entity.Simcard;

public interface ISimcardService {

	public Simcard createSimcard(Simcard objSimcard);
	
	public Simcard updateSimcard(Simcard objSimcard, Long idSimcard);
	
	public void deleteSimcard(Long idSimcard);
	
	public Simcard getSimcard(Long idSimcard);
	
	public List<Simcard> getAllSimcards();
}
