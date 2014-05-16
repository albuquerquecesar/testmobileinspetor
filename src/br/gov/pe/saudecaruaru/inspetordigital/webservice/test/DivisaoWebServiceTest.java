package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.DivisaoWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.WebServiceTool;
import android.test.AndroidTestCase;

public class DivisaoWebServiceTest extends AndroidTestCase{

	private DivisaoWebService webServiceDivisao;
	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.webServiceDivisao=new DivisaoWebService();
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		this.webServiceDivisao=null;
	}
	
	
	
	//testa se traz todas as divisões
	public void testGetAll(){
		
		List l=this.webServiceDivisao.getAll(0,0);
		
		assertEquals(false, l.isEmpty());
	}
	
}
