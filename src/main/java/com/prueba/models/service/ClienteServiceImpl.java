package com.prueba.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.models.dao.ClienteDAO;
import com.prueba.models.entity.Cliente;
@Service
public class ClienteServiceImpl implements IclienteService {

	@Autowired
	ClienteDAO objClienteDao;
	@Override
	public Cliente createClient(Cliente objCliente) {
		
		return objClienteDao.save(objCliente);
	}

	@Override
	public Boolean deleteClient(Long idCliente) {
		Cliente deleteClient = objClienteDao.findById(idCliente).get();
		if(deleteClient!= null) {
			objClienteDao.delete(deleteClient);
			return true;
		}
		return false;
	}

	@Override
	public Cliente updateClient(Cliente objCliente) {
		Cliente cliente = objClienteDao.findByCliente(objCliente.getCliente());
		if(cliente != null) {
			cliente.setCliente(objCliente.getCliente());
			return objClienteDao.save(cliente);
		}
		return null;
	}

	@Override
	public List<Cliente> getAllClients() {
		return objClienteDao.findAll();
	}

}
