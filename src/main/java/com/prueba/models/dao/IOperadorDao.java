package com.prueba.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.models.entity.Operador;
import com.prueba.models.model.PorcentajeOperadorDTO;

public interface IOperadorDao extends JpaRepository<Operador, Long> {
	
	@Query("SELECT new com.prueba.models.model.PorcentajeOperadorDTO(sum(ds.minutosConsumidos)*100/(SELECT SUM(dsi.minutosConsumidos) from DispositivoSimcard dsi), s.objOperador.operador) from DispositivoSimcard ds left JOIN ds.objDispositivosSimcardPk.objSimcard s left join s.objOperador group by s.objOperador.operadorId")
	public List<PorcentajeOperadorDTO> porcentajeOperadores();
	
	//@Query("SELECT * FROM operadores")
	//public Page<Operador> paginacionOperadores();

}
