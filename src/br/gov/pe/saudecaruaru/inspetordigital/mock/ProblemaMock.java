package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Problema;

public class ProblemaMock {

	public static List<Problema> getModelos(){
		List<Problema> problemas=new ArrayList<Problema>();
		
		problemas.add(new Problema(1, "produto vencido"));
		problemas.add(new Problema(2, "produto estragado"));
		problemas.add(new Problema(3, "bebida falsificada"));
		problemas.add(new Problema(4, "mal conservação dos alimentos"));
		
		return problemas;
	}
}
