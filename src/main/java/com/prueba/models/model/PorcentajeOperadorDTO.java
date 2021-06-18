package com.prueba.models.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PorcentajeOperadorDTO implements Serializable {

	private static final long serialVersionUID = -1511875964581204314L;
	
	private Double porcentajeOperador;
	private String nombreOperador;

}
