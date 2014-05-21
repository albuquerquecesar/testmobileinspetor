package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.Date;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Usuario;
import br.gov.pe.saudecaruaru.inspetordigital.outros.test.ApplicationInspetorDigitalTest;
import br.gov.pe.saudecaruaru.inspetordigital.tools.ApplicationInspetorDigital;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.DivisaoWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.WebServiceTool;
import android.test.AndroidTestCase;

public class DivisaoWebServiceTest extends AndroidTestCase{

	private DivisaoWebService webServiceDivisao;
	
	
	public DivisaoWebServiceTest() throws Exception {
		super();
		this.webServiceDivisao=new DivisaoWebService();
		Usuario usuario=new Usuario();
		usuario.setCpf("08901164400");
		usuario.setId(1);
		usuario.setNome("cesar");
		usuario.setToken("51d339d540c667.08849069");
		ApplicationInspetorDigitalTest.setConnectedUser(usuario);
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
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
	
	public void testGetAllWithDate(){
		Date data=new Date();
		
		data.setHours(0);
		data.setMinutes(0);
		data.setSeconds(0);
		List l=this.webServiceDivisao.getAll(0,0,data);
		
		assertNotNull(l);
	}
	
}
