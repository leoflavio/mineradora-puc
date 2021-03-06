package com.mina.demo.nivelalerta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NivelAlerta4 implements INivelAlerta {

	@Override
	public void executar() {
		String alerta = "Alerta Nivel 4";
		System.out.println(alerta);
		Mensagem.getInstance().setValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" >> "+alerta);
	}

}
