package com.prueba.models.service;

import java.util.List;

import com.prueba.models.entity.Cliente;

public interface IclienteService {
	
	public List<Cliente> getAllClients();
	
	public Cliente createClient(Cliente objCliente);
	
	public Boolean deleteClient(Long idCliente);
	
	public Cliente updateClient(Cliente objCliente);

}
