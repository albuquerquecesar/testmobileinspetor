package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.OrgaoReguladorWebService;
import android.test.AndroidTestCase;

public class OrgaoReguladorWebServiceTest extends AndroidTestCase {
	
	private OrgaoReguladorWebService orgaoReguladorWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.orgaoReguladorWebService=new OrgaoReguladorWebService();
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
		assertNotNull(this.orgaoReguladorWebService.getAll(1, 0));
	}
	
	public void testGetAllPagination(){
		assertEquals(2, this.orgaoReguladorWebService.getAll(2, 0).size());
	}
}
