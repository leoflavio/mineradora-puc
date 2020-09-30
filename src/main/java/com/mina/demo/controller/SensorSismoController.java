package com.mina.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mina.demo.entity.SensorSismo;
import com.mina.demo.service.ISensorSismoService;

@RestController
@RequestMapping(value = "/sensor", produces = MediaType.APPLICATION_JSON_VALUE)
public class SensorSismoController {

	@Autowired
	private ISensorSismoService sensorSismoService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void salvar(@RequestBody SensorSismo sensor) {
		sensorSismoService.salvar(sensor);
	}

	@RequestMapping(value = "/remover", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void remover(@RequestBody SensorSismo sensor) {
		sensorSismoService.deletar(sensor);
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void atualizar(@RequestBody SensorSismo sensor) {
		sensorSismoService.atualizar(sensor);
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public SensorSismo buscaPorId(@RequestBody Long id) {
		return sensorSismoService.buscarPorID(id);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public Collection<SensorSismo> getAll() {
		return sensorSismoService.buscarTodos();
	}
}
