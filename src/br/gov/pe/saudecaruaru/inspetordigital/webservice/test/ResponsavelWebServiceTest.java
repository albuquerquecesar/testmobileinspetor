package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.ResponsavelWebService;
import android.test.AndroidTestCase;

public class ResponsavelWebServiceTest extends AndroidTestCase{

	private ResponsavelWebService responsavelWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.responsavelWebService= new ResponsavelWebService();
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
		assertNotNull(this.responsavelWebService.getAll(1, 0));
	}
	
	public void testGetAllPagination(){
		assertEquals(2, this.responsavelWebService.getAll(2, 0).size());
	}
	
	public void testGetByCpf(){
		assertNotNull(this.responsavelWebService.getByCpf("06729732431"));
	}
}
