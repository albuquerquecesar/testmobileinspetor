package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Cidade;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estado;

public class CidadeMock {

	public static List<Cidade> getModelos() {
		List<Cidade> cidades = new ArrayList<Cidade>();
		List<Estado> estados = EstadoMock.getModelos();
	
		cidades.add(new Cidade("102023", "cachoeirinha", estados.get(0)));
		cidades.add(new Cidade("103423", "são paulo", estados.get(1)));
		cidades.add(new Cidade("107623", "pequenopólis", estados.get(2)));
		cidades.add(new Cidade("102045", "vitória", estados.get(3)));
	
		return cidades;
	}

}
