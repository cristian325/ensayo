package com.prueba.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consumos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumo {

	@Id
	@Column(name = "id_consumo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 0,max = 6)
	private Long idConsumo;	

	
	@Column(name = "fecha_consumo")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaConsumo;
	
	//MUCHOS consumos tienen un Dispositivo
	@JoinColumn(name = "id_dispositivo")
	@ManyToOne(fetch = FetchType.LAZY)
	private Dispositivo objDispositivo;
}
