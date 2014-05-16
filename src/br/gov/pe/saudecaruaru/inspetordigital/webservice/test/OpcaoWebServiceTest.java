package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.OpcaoWebService;
import android.test.AndroidTestCase;

public class OpcaoWebServiceTest extends AndroidTestCase{
	
	private OpcaoWebService opcaoWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.opcaoWebService=new OpcaoWebService();
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
		assertNotNull(this.opcaoWebService.getAll(2, 0));
	}
	
	public void testGetAllPagination(){
		assertEquals(1, this.opcaoWebService.getAll(1, 0).size());
	}

}
