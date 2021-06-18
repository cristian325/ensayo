package com.prueba.models.service;

import java.util.List;

import com.prueba.models.entity.Dispositivo;

public interface IdispositivoService {

	//Obtener todos los dispositivos
	public List<Dispositivo> getAllDevices();
	
	public Dispositivo createDevice(Dispositivo objDispositivo);
	
	public Dispositivo findDeviceByReference(String referencia);
	
	public Boolean deleteDevice(String referencia);
	
	public Dispositivo updateDevice(Dispositivo objDispositivo);
}
