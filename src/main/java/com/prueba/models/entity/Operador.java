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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="operadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operador implements Serializable {
	
	
	private static final long serialVersionUID = 5950221251144139416L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_operador")
	@Size(min = 0, max = 6)
	private Long operadorId;
	
	@Column(name="operador")
	@Size(min = 0, max = 80)
	private String operador;
	
	@Column(name="banda")
	@Size(min = 0, max = 2)
	private String banda;
	
	//Un Operador tiene muchas Simcards
	//cascade ALL realizar todas las operaciones en Cadena
	@OneToMany(mappedBy = "objOperador",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Simcard> objSimcards;
	
	

}
