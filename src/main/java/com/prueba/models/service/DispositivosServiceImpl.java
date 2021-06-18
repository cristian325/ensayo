package com.prueba.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.models.dao.DispositivoDao;
import com.prueba.models.entity.Dispositivo;
@Service
public class DispositivosServiceImpl implements IdispositivoService {
	
	@Autowired
	DispositivoDao objDispositivoDao;

	@Override
	public List<Dispositivo> getAllDevices() {				
		return objDispositivoDao.findAll();
	}

	@Override
	public Dispositivo createDevice(Dispositivo parDispositivo) {
		Dispositivo objDispositivo = objDispositivoDao.findByReferencia(parDispositivo.getReferencia());
		if(objDispositivo != null) {
			return null;
			
		}
		return objDispositivoDao.save(parDispositivo);
	}

	@Override
	public Dispositivo findDeviceByReference(String referencia) {
		
		Dispositivo objDispositivo = objDispositivoDao.findByReferencia(referencia);		
		return objDispositivo;
	}

	@Override
	public Boolean deleteDevice(String referencia) {
		Dispositivo objDispositivo = objDispositivoDao.findByReferencia(referencia);
		if(objDispositivo != null) {			
			 objDispositivoDao.delete(objDispositivo);
			 return true;
		}	
		return false;
	}

	@Override
	public Dispositivo updateDevice(Dispositivo parDispositivo) {
		Dispositivo objDispositivo = objDispositivoDao.findByReferencia(parDispositivo.getReferencia());
		if(objDispositivo != null) {			
			objDispositivo.setModelo(parDispositivo.getModelo());
			objDispositivo.setReferencia(parDispositivo.getReferencia());
			objDispositivo.setTipoDispositivo(parDispositivo.getTipoDispositivo());
			
			 return objDispositivoDao.save(objDispositivo);
		}	
		return null;
	}
	
	

}
