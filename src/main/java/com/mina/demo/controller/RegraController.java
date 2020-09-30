package com.mina.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mina.demo.entity.Regra;
import com.mina.demo.service.IRegraService;

@RestController
@RequestMapping(value = "/regra", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegraController {

	@Autowired
	private IRegraService regraService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void salvar(@RequestBody Regra regra) {
		regraService.salvar(regra);
	}

	@RequestMapping(value = "/remover", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void remover(@RequestBody Regra regra) {
		regraService.deletar(regra);
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void atualizar(@RequestBody Regra regra) {
		regraService.atualizar(regra);
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public Regra buscaPorId(@RequestBody Long id) {
		return regraService.buscarPorID(id);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public Collection<Regra> getAll() {
		return regraService.buscarTodos();
	}
}
