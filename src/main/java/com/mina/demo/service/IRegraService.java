package com.mina.demo.service;

import java.util.List;

import com.mina.demo.entity.Regra;

public interface IRegraService {

	public void salvar(Regra regra);

	public void atualizar(Regra regra);

	public void deletar(Regra regra);

	public List<Regra> buscarTodos();

	public Regra buscarPorID(Long id);

}
