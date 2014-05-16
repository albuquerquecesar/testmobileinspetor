package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.BairroWebService;
import android.test.AndroidTestCase;

public class BairroWebServiceTest extends AndroidTestCase{
	
	private BairroWebService bairroWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.bairroWebService=new BairroWebService();
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
		assertNotNull(this.bairroWebService.getAll(1, 0));
	}
	
	public void testGetAllPagenation(){
		assertEquals(1, this.bairroWebService.getAll(1, 0).size());
	}
}
