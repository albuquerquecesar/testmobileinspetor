package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Situacao;

public class SituacaoMock {

	public static List<Situacao> getModelos(){
		List<Situacao> situacoes=new ArrayList<Situacao>();
		
		situacoes.add(new Situacao(1, "boa"));
		situacoes.add(new Situacao(2, "regular"));
		situacoes.add(new Situacao(3, "ruim"));
		situacoes.add(new Situacao(4, "péssima"));
		
		return situacoes;
	}
}
