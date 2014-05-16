package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Pergunta;
import br.gov.pe.saudecaruaru.inspetordigital.model.PerguntaFechada;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.PerguntaWebService;
import android.test.AndroidTestCase;

public class PerguntaWebServiceTest extends AndroidTestCase{

	private PerguntaWebService perguntaWebService;
	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.perguntaWebService=new PerguntaWebService();
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void testConnection(){
		assertNotNull(this.perguntaWebService.getAll(2, 0));
	}
	
	public void testPagination(){
		assertEquals(2, this.perguntaWebService.getAll(2, 0).size());
	}
	
	public void testWithOpcoes(){
		List<Pergunta> perguntaFechadas=this.perguntaWebService.getAll(1, 0);
		assertEquals(1, perguntaFechadas.size());
		assertTrue(((PerguntaFechada)perguntaFechadas.get(0)).getOpcoes().size() > 0);
	}
}
