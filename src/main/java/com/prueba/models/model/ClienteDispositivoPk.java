package com.prueba.models.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prueba.models.entity.Cliente;
import com.prueba.models.entity.Dispositivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class ClienteDispositivoPk implements Serializable {

	//La claves foraneas van en la relacion muchos a uno
	//@Embeddable = Permite embeber esta clase en otra.
	private static final long serialVersionUID = -5786389431921160879L;
	
	@JoinColumn(name = "id_dispositivo")
	@ManyToOne(fetch = FetchType.LAZY)		
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Dispositivo objDispositivo;
	
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne(fetch = FetchType.LAZY)	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Cliente objCliente;
	
	
	
	

}
