package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import br.gov.pe.saudecaruaru.inspetordigital.dao.SituacaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.SituacaoMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Situacao;

public class SituacaoDAOTest extends BaseDAOTest<Situacao>{

	public SituacaoDAOTest() {
		super(SituacaoDAO.getInstance());
		
	}

	public void testCrud(){
		this.crud(SituacaoMock.getModelos().get(0));
	}
	
	public void testCrudWithList(){
		this.crudWithList(SituacaoMock.getModelos());
	}
}

