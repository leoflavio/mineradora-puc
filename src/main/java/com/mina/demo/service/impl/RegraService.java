package com.mina.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mina.demo.entity.Regra;
import com.mina.demo.repository.IRegraRepository;
import com.mina.demo.service.IRegraService;

@Service
public class RegraService implements IRegraService {

	@Autowired
	private IRegraRepository regraRepository;

	@Override
	public void salvar(Regra regra) {
		regraRepository.save(regra);
	}

	@Override
	public void atualizar(Regra regra) {
		regraRepository.save(regra);
	}

	@Override
	public void deletar(Regra regra) {
		regraRepository.delete(regra);
	}

	@Override
	public List<Regra> buscarTodos() {
		return regraRepository.findAll();
	}

	@Override
	public Regra buscarPorID(Long id) {
		return regraRepository.findById(id).orElse(null);
	}

}
