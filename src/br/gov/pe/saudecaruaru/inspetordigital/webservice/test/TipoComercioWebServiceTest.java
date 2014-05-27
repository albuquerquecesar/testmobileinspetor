package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.model.TipoComercio;
import br.gov.pe.saudecaruaru.inspetordigital.model.Usuario;
import br.gov.pe.saudecaruaru.inspetordigital.outros.test.ApplicationInspetorDigitalTest;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.BairroWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.TipoComercioWebService;
import android.test.AndroidTestCase;

public class TipoComercioWebServiceTest extends 
	BaseWebServiceTest<TipoComercio>{

	
	public TipoComercioWebServiceTest() {
		super(new TipoComercioWebService());
	}
}
