package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.ProprietarioWebService;
import android.test.AndroidTestCase;

public class ProprietarioWebServiceTest extends AndroidTestCase{

	private ProprietarioWebService proprietarioWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.proprietarioWebService=new ProprietarioWebService();
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
		assertNotNull(this.proprietarioWebService.getAll(1, 0));
	}
	
	public void testGetAllPagination(){
		assertEquals(2, this.proprietarioWebService.getAll(2, 0).size());
	}
	
	public void testGetByCpf(){
		assertNotNull(this.proprietarioWebService.getByCpf("08769213496"));
	}
}
