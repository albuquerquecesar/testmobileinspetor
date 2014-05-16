package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.NaturezaJuridicaWebService;
import android.test.AndroidTestCase;

public class NaturezaJuridicaWebServiceTest extends AndroidTestCase{

	private NaturezaJuridicaWebService naturezaJuridicaWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.naturezaJuridicaWebService=new NaturezaJuridicaWebService();
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
		assertNotNull(this.naturezaJuridicaWebService.getAll(1, 0));
	}
	
	public void testGetAllPagenation(){
		assertEquals(1, this.naturezaJuridicaWebService.getAll(1, 0).size());
	}
}
