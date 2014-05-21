package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import br.gov.pe.saudecaruaru.inspetordigital.dao.ProblemaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ProblemaMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Problema;

public class ProblemaDAOTest extends BaseDAOTest<Problema>{

	public ProblemaDAOTest() {
		super(ProblemaDAO.getInstance());
		
	}

	public void testCrud(){
		this.crud(ProblemaMock.getModelos().get(0));
	}
	
	public void testCrudWithList(){
		this.crudWithList(ProblemaMock.getModelos());
	}
}
