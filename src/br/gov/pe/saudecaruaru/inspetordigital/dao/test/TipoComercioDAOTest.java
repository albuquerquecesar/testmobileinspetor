package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import br.gov.pe.saudecaruaru.inspetordigital.dao.TipoComercioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.TipoComercioMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.TipoComercio;

public class TipoComercioDAOTest extends BaseDAOTest<TipoComercio>{

	public TipoComercioDAOTest() {
		super(TipoComercioDAO.getInstance());
		// TODO Auto-generated constructor stub
	}


	public void testCrud(){
		this.crud(TipoComercioMock.getModelos().get(0));
	}
	
	public void testCrudWithList(){
		this.crudWithList(TipoComercioMock.getModelos());
	}
}
