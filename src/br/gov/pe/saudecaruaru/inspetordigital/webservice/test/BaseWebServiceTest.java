package br.gov.pe.saudecaruaru.inspetordigital.webservice.test;

import java.util.Date;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.IModel;
import br.gov.pe.saudecaruaru.inspetordigital.model.Usuario;
import br.gov.pe.saudecaruaru.inspetordigital.outros.test.ApplicationInspetorDigitalTest;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.BaseWebService;
import android.test.AndroidTestCase;

public class BaseWebServiceTest<T extends IModel> extends AndroidTestCase{

	private BaseWebService<T> webService;
	
	public BaseWebServiceTest(BaseWebService<T> webService) {
		//loga o usu´ario na base de testes
		this.webService=webService;
		Usuario usuario=new Usuario();
		usuario.setCpf("08901164400");
		usuario.setId(1);
		usuario.setNome("cesar");
		usuario.setToken("51d339d540c667.08849069");
		ApplicationInspetorDigitalTest.setConnectedUser(usuario);
	}
	
	public void testGetAll(){
		
		List l=this.webService.getAll(0,0);
		
		assertEquals(false, l.isEmpty());
	}
	
	public void testGetAllWithDate(){
		Date data=new Date();
		
		data.setHours(0);
		data.setMinutes(0);
		data.setSeconds(0);
		List l=this.webService.getAll(0,0,data);
		
		assertNotNull(l);
	}
}
