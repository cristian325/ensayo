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
@Table(name="planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan implements Serializable{
	

	private static final long serialVersionUID = -8174250973557460968L;

	@Id
	@Column(name = "id_plan")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 0,max = 6)	
	private Long idPlan;
	
	@Column(name = "plan")
	@Size(min = 0,max = 50)
	private String plan;
	
	@Column(name = "total_minutos")
	private float totalMinutos;
	
	@Column(name = "total_datos")
	private float totalDatos;
	
	@OneToMany(mappedBy = "objDispositivosSimcardPk.objPlan" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DispositivoSimcard> listDispositivosSimcardPlan;

}
