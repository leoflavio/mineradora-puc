package com.mina.demo.nivelalerta;

public class Mensagem {
	private static Mensagem instance;
	public String value;

	public static Mensagem getInstance() {
		if (instance == null) {
			instance = new Mensagem();
		}
		return instance;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
