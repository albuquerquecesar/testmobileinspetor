package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Grupo;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.GrupoWebService;
import android.test.AndroidTestCase;

public class GrupoWebServiceTest extends AndroidTestCase{

	private GrupoWebService grupoWebService;
	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.grupoWebService= new GrupoWebService();
		
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
		List<Grupo> grupo=this.grupoWebService.getAll(0, 0);
		assertNotNull(grupo);
		
		assertEquals(false, grupo.isEmpty());
	}
	
	public void testGetAllForPage(){
		assertEquals(4, this.grupoWebService.getAll(4, 0).size());
	}
}
