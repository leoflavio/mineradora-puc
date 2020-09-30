package com.mina.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regra")
public class Regra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	public String nome;

	@Column(name = "grupo")
	public Integer grupo;

	@Column(name = "prioridade", columnDefinition = "integer default 0")
	public Integer prioridade;

	@Column(name = "condicao_regra")
	public String condicaoRegra;

	@Column(name = "nivel_alerta")
	public Integer nivelAlerta;

	public Regra() {
		super();
	}

	public Regra(Long id, String nome, Integer grupo, Integer prioridade, String condicaoRegra, Integer nivelAlerta) {
		super();
		this.id = id;
		this.nome = nome;
		this.grupo = grupo;
		this.prioridade = prioridade;
		this.condicaoRegra = condicaoRegra;
		this.nivelAlerta = nivelAlerta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public String getCondicaoRegra() {
		return condicaoRegra;
	}

	public void setCondicaoRegra(String condicaoRegra) {
		this.condicaoRegra = condicaoRegra;
	}

	public Integer getNivelAlerta() {
		return nivelAlerta;
	}

	public void setNivelAlerta(Integer nivelAlerta) {
		this.nivelAlerta = nivelAlerta;
	}

	@Override
	public String toString() {
		return "Regra [id=" + id + ", nome=" + nome + ", grupo=" + grupo + ", prioridade=" + prioridade
				+ ", condicaoRegra=" + condicaoRegra + ", nivelAlerta=" + nivelAlerta + "]";
	}

}
