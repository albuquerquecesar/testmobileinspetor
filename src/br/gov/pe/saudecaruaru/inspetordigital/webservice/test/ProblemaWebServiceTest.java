package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.model.Problema;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.ProblemaWebService;

public class ProblemaWebServiceTest extends BaseWebServiceTest<Problema>{

	public ProblemaWebServiceTest() {
		super(new ProblemaWebService());
		
	}

	public void testSend(){
		assertNotNull(new ProblemaWebService().send(new Problema(23, "testando aqui rapaz")));
	}
}
