package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.model.Situacao;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.SituacaoWebService;

public class SituacaoWebServiceTest extends BaseWebServiceTest<Situacao>{

	public SituacaoWebServiceTest() {
		super(new SituacaoWebService());
	}

}
