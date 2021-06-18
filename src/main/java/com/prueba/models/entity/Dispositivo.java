package com.prueba.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="dispositivos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dispositivo implements Serializable {
	
	private static final long serialVersionUID = 1079955862494296172L;

	@Id
	@Column(name = "id_dispositivo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 0,max = 6)
	private Long idDispositivo;
	
	@Size(min = 0, max = 200)
	@Column(name = "referencia", unique = true)
	@NotEmpty(message = "La referencia no puede ser vacia")
	private String referencia;
	
	@Size(min = 0, max = 70)
	private String modelo;
	
	@Column(name = "tipo_dispositivo")
	@Size(min = 0, max = 70)
	private String tipoDispositivo;


	@OneToMany(mappedBy = "objClienteDispositvoPK.objDispositivo")
	private List<ClienteDispositivo> ListaClientes;
	
	
	@OneToMany(mappedBy = "objDispositivo" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Consumo> listaConsumos;
	
	@OneToMany(mappedBy = "objDispositivosSimcardPk.objDispositivo" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<DispositivoSimcard> listDispositivosSimcardPlan;
	
}
