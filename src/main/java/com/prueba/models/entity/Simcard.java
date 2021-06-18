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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="simcards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Simcard implements Serializable {

	private static final long serialVersionUID = -378057915402929639L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_simcard")
	private Long idSimcard;

	
	@NotEmpty
	@Column(name="numero")
	@Size(min=0, max = 30)
	private String numero;	
	
	@NotEmpty
	@Column(name="estado")
	@Size(min=0, max = 30)
	private String estado;
	
	
	//Muchas Simcards pertenecen a un Operador
	@JoinColumn(name = "id_operador")
	@ManyToOne(fetch = FetchType.LAZY)
	//@JsonBackReference
	//@JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
	private Operador objOperador;
	
	@OneToMany(mappedBy = "objDispositivosSimcardPk.objSimcard" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DispositivoSimcard> listDispositivos;
	
}
