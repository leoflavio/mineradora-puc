package com.mina.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mina.demo.entity.SensorSismo;
import com.mina.demo.repository.ISensorSismoRepository;
import com.mina.demo.service.ISensorSismoService;

@Service
public class SensorSismoService implements ISensorSismoService {

	@Autowired
	private ISensorSismoRepository sensorSismoRepository;

	@Override
	public void salvar(SensorSismo sensor) {
		sensor.setData(LocalDateTime.now());
		sensorSismoRepository.save(sensor);
	}

	@Override
	public void atualizar(SensorSismo sensor) {
		sensor.setData(LocalDateTime.now());
		sensorSismoRepository.save(sensor);
	}

	@Override
	public void deletar(SensorSismo sensor) {
		sensorSismoRepository.delete(sensor);
	}

	@Override
	public List<SensorSismo> buscarTodos() {
		return sensorSismoRepository.findAll();
	}

	@Override
	public SensorSismo buscarPorID(Long id) {
		return sensorSismoRepository.findById(id).orElse(null);
	}

}
