package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Estabelecimento;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.EstabelecimentoWebService;
import android.test.AndroidTestCase;

public class EstabelecimentoWebServiceTest extends AndroidTestCase{
	
	private EstabelecimentoWebService estabelecimentoWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.estabelecimentoWebService=new EstabelecimentoWebService();
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
		assertNotNull(this.estabelecimentoWebService.getAll(1, 0));
	}
	
	public void testGetAllPagination(){
		assertEquals(1, this.estabelecimentoWebService.getAll(1, 0).size());
	}
	
	public void testGetAllByCpfCnpj(){
		
		assertEquals(1, this.estabelecimentoWebService.getAllByCpfCnpj("13042567150").size());
	}
	
	public void testGetOneEstabelecimento(){
		List<Estabelecimento> es=this.estabelecimentoWebService.getAllByCpfCnpj("13042567150");
		assertEquals(1, es.size());
		assertEquals("13042567150", es.get(0).getCpfCnpj());
	}
}
