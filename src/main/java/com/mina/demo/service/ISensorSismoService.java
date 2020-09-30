package com.mina.demo.service;

import java.util.List;

import com.mina.demo.entity.SensorSismo;

public interface ISensorSismoService {

	public void salvar(SensorSismo sensor);

	public void atualizar(SensorSismo sensor);

	public void deletar(SensorSismo sensor);

	public List<SensorSismo> buscarTodos();

	public SensorSismo buscarPorID(Long id);

}
