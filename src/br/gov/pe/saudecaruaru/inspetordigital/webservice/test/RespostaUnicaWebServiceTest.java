package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Inspecao;
import br.gov.pe.saudecaruaru.inspetordigital.model.RespostaUnica;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.RespostaUnicaWebService;
import android.test.AndroidTestCase;

public class RespostaUnicaWebServiceTest extends AndroidTestCase{

	private RespostaUnicaWebService respostaUnicaWebService;
	private Inspecao inspecao=new Inspecao("W20130607174509");

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.respostaUnicaWebService=new RespostaUnicaWebService();
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
		assertEquals(1, this.respostaUnicaWebService.getAll(1, 0).size());
	}
	
	public void testGetAllOfInspecao(){
		List<RespostaUnica> lista=this.respostaUnicaWebService.getAllOfInspecao(this.inspecao);
		
		assertEquals(false, lista.isEmpty());
		//verifica o prrenchimento dos campos
		
		RespostaUnica resposta=lista.get(0);
		assertNotNull(resposta.getInspecao());
		assertNotNull(resposta.getOpcao());
		assertNotNull(resposta.getPergunta());
		
	}
}
