package com.prueba.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente implements Serializable{
	
	
	private static final long serialVersionUID = -5866031440180926631L;

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 0,max = 6)	
	private Long idCliente;
	
	@NotEmpty
	@Size(min = 0,max = 250)
	@Column(name = "cliente")
	private String cliente;

	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	
	@OneToMany(mappedBy = "objClienteDispositvoPK.objCliente")	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "objCliente" })
	private List<ClienteDispositivo> ListaDispositivos;
}
