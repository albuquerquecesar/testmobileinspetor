package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.FormularioPerguntaWebService;
import android.test.AndroidTestCase;

public class FormularioPerguntaWebServiceTest extends AndroidTestCase{
	
	private FormularioPerguntaWebService formularioPerguntaWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.formularioPerguntaWebService=new FormularioPerguntaWebService();
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	public void testGetAll(){
		assertEquals(2, this.formularioPerguntaWebService.getAll(2, 0).size());
	}
	
}
