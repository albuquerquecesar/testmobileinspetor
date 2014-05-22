package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;
import br.gov.pe.saudecaruaru.inspetordigital.model.Cidade;
import br.gov.pe.saudecaruaru.inspetordigital.model.Endereco;

public class EnderecoMock {

	public static List<Endereco> getModelos(){
		
		List<Endereco> enderecos=new ArrayList<Endereco>();
		List<Bairro> bairros=BairroMock.getModelos();
		List<Cidade> cidades=CidadeMock.getModelos();
		
		enderecos.add(new Endereco(1,
						"55938838", "rua da matriz", bairros.get(1), cidades
								.get(1), null, null));
		
		enderecos.add(new Endereco(2,
				"55978838", "rua taparica dos sul", bairros.get(0), cidades
						.get(0), null, null));
		
		enderecos.add(new Endereco(3,
				"55938839", "avenida sem nome", bairros.get(2), cidades
						.get(2), null, null));
		
		enderecos.add(new Endereco(4,
				"56938838", "rua da matriz", bairros.get(3), cidades
						.get(3), null, null));
		
		return enderecos;
	}
}
