package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.TipoComercio;

public class TipoComercioMock {

	
	public static List<TipoComercio> getModelos(){
		List<TipoComercio> list=new ArrayList<TipoComercio>();
		
		list.add(new TipoComercio(1, "barrcaca cachorro quente"));
		list.add(new TipoComercio(2, "barrcaca de bebidas"));
		list.add(new TipoComercio(3, "barrcaca de tapioca"));
		list.add(new TipoComercio(4, "churrasquinho"));
		
		return list;
	}
}
