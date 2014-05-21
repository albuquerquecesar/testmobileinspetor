package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Endereco;
import br.gov.pe.saudecaruaru.inspetordigital.model.Evento;

public class EventoMock {

	public static List<Evento> getModelos(){
		List<Evento> eventos=new ArrayList<Evento>();
		List<Endereco> enderecos=EnderecoMock.getModelos();
		
		eventos.add(new Evento(1, "são joão", enderecos.get(1)));
		eventos.add(new Evento(2, "jogo do santinha", enderecos.get(0)));
		eventos.add(new Evento(3, "vaquejada sem show", enderecos.get(2)));
		eventos.add(new Evento(4, "evento cultural", enderecos.get(3)));
		
		return eventos;
	}
}
