package com.mina.demo.nivelalerta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NivelAlerta5 implements INivelAlerta {

	@Override
	public void executar() {
		String alerta = "Alerta Nivel 5";
		System.out.println(alerta);
		Mensagem.getInstance().setValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" >> "+alerta);
	}

}
