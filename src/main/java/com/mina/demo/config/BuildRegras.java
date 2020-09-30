package com.mina.demo.config;

import com.mina.demo.entity.Regra;

public class BuildRegras {

	public static StringBuilder criarImport() {
		return new StringBuilder(" import com.mina.demo.entity.Regra; ");
	}

	public StringBuilder criarRegra(Regra r, String condicao) {
		StringBuilder s = new StringBuilder();
		s.append(" rule \"").append(r.getNome()).append("\" ");
		s.append(r.getGrupo() != null && r.getGrupo()!=0 ? "activation-group \"" + r.getGrupo() + "\"" : " ");
		s.append(" salience ").append(r.getPrioridade());
		s.append(" when ");
		s.append(" obj: Regra(").append(condicao).append(") ");
		s.append(" then ");
		s.append(" obj.setNivelAlerta(").append(r.getNivelAlerta()).append("); ");
		s.append(" end ");
		return s;
	}
}
