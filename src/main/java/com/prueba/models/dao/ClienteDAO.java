package com.prueba.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.models.entity.Cliente;


@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {
	
	public Cliente findByCliente(String nombreCliente);
	
	@Query("SELECT c FROM Cliente c INNER JOIN c.ListaDispositivos l INNER JOIN l.objClienteDispositvoPK.objDispositivo cd "
			+ "WHERE c.cliente = ?1 AND l.objClienteDispositvoPK.objDispositivo.modelo = ?2")
	public List<Cliente> retornarClientes(String nombreCliente , String nombreModelo);
}
