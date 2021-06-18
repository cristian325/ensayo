package com.prueba.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.prueba.models.model.DispositivoSimcardPk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dispositivos_simcards")
@Builder
public class DispositivoSimcard implements Serializable {
	
	private static final long serialVersionUID = 6497320701803853788L;

	@EmbeddedId
	private DispositivoSimcardPk objDispositivosSimcardPk;
	
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaInicio;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	@Column(name = "latitud")
	private double latitud;
	
	@Column(name = "longitud")
	private double longitud;
	
	@Column(name = "min_consumidos")
	private float minutosConsumidos;
	
	@Column(name = "gb_consumidos")
	private float gigasConsumidas;
	

}
