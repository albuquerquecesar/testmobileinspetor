package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.webservices.NaturezaWebService;
import br.gov.pe.saudecaruaru.inspetordigital.model.Natureza;
import android.test.AndroidTestCase;

public class NaturezaWebServiceTest extends AndroidTestCase {
	
	private NaturezaWebService webservice;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.webservice=new NaturezaWebService();
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
		List<Natureza> l=null;;
		l=this.webservice.getAll(10, 0);
		
		assertEquals(10, l.size());
	}

}
