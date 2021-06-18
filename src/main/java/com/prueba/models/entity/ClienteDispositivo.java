package com.prueba.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.prueba.models.model.ClienteDispositivoPk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes_dispositivo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDispositivo {
	
	@EmbeddedId
	private ClienteDispositivoPk objClienteDispositvoPK;

	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaInicio;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaFin;
	
	@NotEmpty
	@Size(min = 0,max = 50)
	private String contrato;
	
	
}
