package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.model.Evento;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.EventoWebService;

public class EventoWebServiceTest extends BaseWebServiceTest<Evento> {

	public EventoWebServiceTest() {
		super(new EventoWebService());
	}

}
