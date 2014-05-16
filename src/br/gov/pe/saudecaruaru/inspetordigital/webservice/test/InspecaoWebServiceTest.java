package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import br.gov.pe.saudecaruaru.inspetordigital.model.Inspecao;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.InspecaoWebService;
import android.test.AndroidTestCase;

public class InspecaoWebServiceTest extends AndroidTestCase {

	private InspecaoWebService inspecaoWebService;

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.inspecaoWebService=new InspecaoWebService();
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	
	public void testConnection(){
		assertNotNull(this.inspecaoWebService.getAll(1, 0));
	}
	
	public void testGetAll(){
		assertEquals(2, this.inspecaoWebService.getAll(2, 0).size());
	}
	
	public void testFillInspecao(){
		Inspecao inspecao=this.inspecaoWebService.getAll(1, 0).get(0);
		
		assertNotNull(inspecao.getData());
		assertNotNull(inspecao.getFim());
		assertNotNull(inspecao.getInicio());
		assertEquals(false, inspecao.getCodigo().isEmpty());
		assertNotNull(inspecao.getEstabelecimento());
		assertNotNull(inspecao.getFormulario());
	}
}
