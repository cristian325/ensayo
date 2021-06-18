package com.prueba.models.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prueba.models.entity.Cliente;
import com.prueba.models.entity.Dispositivo;
import com.prueba.models.entity.Plan;
import com.prueba.models.entity.Simcard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DispositivoSimcardPk implements Serializable{

	private static final long serialVersionUID = 1825491400329899055L;

	@JoinColumn(name = "id_plan")
	@ManyToOne(fetch = FetchType.LAZY)		
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Plan objPlan;
	
	@JoinColumn(name = "id_simcard")
	@ManyToOne(fetch = FetchType.LAZY)	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Simcard objSimcard;
	
	
	@JoinColumn(name = "id_dispositivo")
	@ManyToOne(fetch = FetchType.LAZY)		
	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonBackReference
	private Dispositivo objDispositivo;
	
	
	


}
