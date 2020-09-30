package com.mina.demo.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mina.demo.config.BuildRegras;
import com.mina.demo.config.MotorDrools;
import com.mina.demo.entity.Regra;
import com.mina.demo.entity.SensorSismo;
import com.mina.demo.nivelalerta.INivelAlerta;
import com.mina.demo.repository.IRegraRepository;
import com.mina.demo.repository.ISensorSismoRepository;

@Component
public class ExecutorRegras {

	@Autowired
	private IRegraRepository regraRepository;
	
	@Autowired
	private ISensorSismoRepository sensorSismoRepository;

	@Scheduled(fixedRate = 3000L)
	void executorJob() throws InterruptedException {
		executeAgora();
	}

	public void executeAgora() {
		
		List<SensorSismo> list = sensorSismoRepository.findFirst2ByOrderByDataDesc();
		
		if(list!=null && list.size()==2) {
			Regra r = new Regra(1L, "default", 0, 0, "1==1", 1);
			Double vnew = list.get(0).getValor();
			Double vold = list.get(1).getValor();
			
			Double vperc = (vnew/vold-1)*100;
			
			BuildRegras rule = new BuildRegras();
			StringBuilder rules = BuildRegras.criarImport();

			regraRepository.findAll().forEach(x -> {
				rules.append(rule.criarRegra(x, x.getCondicaoRegra()+ " < " +vperc));
			});

			MotorDrools.executeDrools(r, rules.toString());
//			System.out.println("Regra recupedada: " + rules.toString());

//			https://stackoverflow.com/questions/2215843/using-reflection-in-java-to-create-a-new-instance-with-the-reference-variable-ty
//			https://docs.oracle.com/javase/tutorial/reflect/member/ctorInstance.html
			try {
				String className = "com.mina.demo.nivelalerta.NivelAlerta"+r.getNivelAlerta();
				Class c = Class.forName(className);
				INivelAlerta interfaceType = (INivelAlerta) c.newInstance();
				interfaceType.executar();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}
}
