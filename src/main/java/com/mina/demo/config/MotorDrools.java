package com.mina.demo.config;

import java.util.Collection;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

/**
 * 
 * @author Leoflavio Silva
 */
public class MotorDrools {
	
	
	public static void executeDrools(Object obj, String ruleString) {
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		kbuilder.add(ResourceFactory.newByteArrayResource(ruleString.getBytes()), ResourceType.DRL);

		if (kbuilder.hasErrors()) {
			throw new RuntimeException("Unable to compile rules: "+kbuilder.getErrors().toString());
		}

		Collection<KiePackage> pkgs = kbuilder.getKnowledgePackages();

		InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addPackages(pkgs);

		KieSession kieSession = kbase.newKieSession();
		
		kieSession.insert(obj);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
}