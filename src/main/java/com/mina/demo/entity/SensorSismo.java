package com.mina.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_sismico")
public class SensorSismo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	public String nome;

	@Column(name = "valor")
	public Double valor;

	@Column(name = "datacriacao")
	public LocalDateTime data;

	public SensorSismo() {
		super();
	}

	public SensorSismo(Long id, String nome, Double valor, LocalDateTime data) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.data = data;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SensorSismo [id=" + id + ", nome=" + nome + ", valor=" + valor + ", data=" + data + "]";
	}

}
