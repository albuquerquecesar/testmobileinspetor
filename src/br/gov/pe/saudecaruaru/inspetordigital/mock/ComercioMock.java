package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Comercio;
import br.gov.pe.saudecaruaru.inspetordigital.model.Endereco;
import br.gov.pe.saudecaruaru.inspetordigital.model.Servidor;
import br.gov.pe.saudecaruaru.inspetordigital.model.TipoComercio;

public class ComercioMock {

	
	public static List<Comercio> getModelos(){
		
		List<Comercio> comercios=new ArrayList<Comercio>();
		List<Endereco> enderecos=EnderecoMock.getModelos();
		List<TipoComercio> tipos=TipoComercioMock.getModelos();
		List<Servidor> fiscais = ServidorMock.getModelos();
		
		comercios.add(new Comercio("rg3434", "cesaR", "4543252353246HTDBRT", tipos.get(0), enderecos.get(0),fiscais.get(0)));
		comercios.add(new Comercio("rg89789", "paulo", "4543252sdvhjsadiRT", tipos.get(1), enderecos.get(1),fiscais.get(1)));
		comercios.add(new Comercio("rg56grgw", "pires", "4543sadkbfawsiuRT", tipos.get(2), enderecos.get(2),fiscais.get(2)));
		comercios.add(new Comercio("rgsds3434", "joaoa", "454325shfdbh", tipos.get(3), enderecos.get(3),fiscais.get(3)));
		
		return comercios;
	}
}
