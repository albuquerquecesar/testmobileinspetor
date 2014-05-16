package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import android.test.AndroidTestCase;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.CidadeWebService;

public class CidadeWebServiceTest extends AndroidTestCase{


	private CidadeWebService cidadeWebService;
	
	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.cidadeWebService=new CidadeWebService();
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
		assertNotNull(this.cidadeWebService.getAll(1, 0));
	}
	
	public void testGetAllPagenation(){
		assertEquals(10, this.cidadeWebService.getAll(10, 0).size());
	}
	
}
