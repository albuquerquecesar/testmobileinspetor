package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;

public class BairroMock {

	public static List<Bairro> getModelos() {
		List<Bairro> bairros = new ArrayList<Bairro>();
	
		bairros.add(new Bairro("01", "são francisco"));
		bairros.add(new Bairro("02", "maurício de nassau"));
		bairros.add(new Bairro("03", "salgado"));
		bairros.add(new Bairro("04", "centro"));
	
		return bairros;
	}

}
