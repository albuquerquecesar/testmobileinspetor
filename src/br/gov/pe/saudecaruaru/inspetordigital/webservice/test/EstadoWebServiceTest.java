package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Estado;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.EstadoWebService;
import android.test.AndroidTestCase;

public class EstadoWebServiceTest extends AndroidTestCase{

	
	private EstadoWebService estadoWebService;
	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.estadoWebService=new EstadoWebService();
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
		
		List<Estado> list=this.estadoWebService.getAll(0,0);
		
		assertNotNull(list);
		
		assertEquals(27, list.size());
	}
	
}
