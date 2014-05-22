package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Estado;

public class EstadoMock {

	public static List<Estado> getModelos() {
		List<Estado> list = new ArrayList<Estado>();
	
		list.add(new Estado("ALAGOAS", "AL", "12"));
		list.add(new Estado("pernambuco", "PE", "26"));
		list.add(new Estado("SÃO PAULO", "SP", "23"));
		list.add(new Estado("bahia", "BA", "29"));
	
		return list;
	}

}
