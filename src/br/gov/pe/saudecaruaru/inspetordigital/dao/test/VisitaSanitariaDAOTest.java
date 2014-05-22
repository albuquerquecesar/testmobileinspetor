package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ComercioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EventoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ProblemaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ServidorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.TipoComercioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.VisitaSanitariaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.BairroMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.CidadeMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ComercioMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EstadoMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EventoMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ProblemaMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ServidorMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.TipoComercioMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.VisitaSanitariaMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Problema;
import br.gov.pe.saudecaruaru.inspetordigital.model.VisitaSanitaria;

public class VisitaSanitariaDAOTest extends BaseDAOTest<VisitaSanitaria> {
	
	private BairroDAO bairroDAO;
	private EstadoDAO estadoDAO;
	private CidadeDAO cidadeDAO;
	private ComercioDAO comercioDAO;
	private TipoComercioDAO tipoComercioDAO;
	private ServidorDAO servidorDAO;
	private VisitaSanitariaDAO visitaSanitariaDAO;
	private EventoDAO eventoDAO;
	private ProblemaDAO problemaDAO;
	
	
	public VisitaSanitariaDAOTest() {
		
		super(VisitaSanitariaDAO.getInstance());
		
		this.bairroDAO=BairroDAO.getInstance();
		this.cidadeDAO=CidadeDAO.getInstance();
		this.estadoDAO=EstadoDAO.getInstance();
		this.comercioDAO=ComercioDAO.getInstance();
		this.tipoComercioDAO=TipoComercioDAO.getInstance();
		this.servidorDAO=ServidorDAO.getInstance();
		this.eventoDAO=EventoDAO.getInstance();
		this.problemaDAO=ProblemaDAO.getInstance();
		
	}

	
	public void testCrud(){
		try{
	
		this.estadoDAO.merge(EstadoMock.getModelos());
		this.cidadeDAO.merge(CidadeMock.getModelos());
		this.bairroDAO.merge(BairroMock.getModelos());
		
		this.tipoComercioDAO.merge(TipoComercioMock.getModelos());
		this.problemaDAO.merge(ProblemaMock.getModelos());
		
		this.servidorDAO.merge(ServidorMock.getModelos());
		this.eventoDAO.merge(EventoMock.getModelos());
		this.comercioDAO.merge(ComercioMock.getModelos());
		this.crud(VisitaSanitariaMock.getModelos().get(0));

		this.cidadeDAO.deleteAll();
		this.estadoDAO.deleteAll();
		this.bairroDAO.deleteAll();
		this.eventoDAO.deleteAll();
		this.tipoComercioDAO.deleteAll();
		this.comercioDAO.deleteAll();
		this.servidorDAO.deleteAll();
		this.problemaDAO.deleteAll();
		this.visitaSanitariaDAO.deleteAll();
	}catch(Exception ex){
		ex.printStackTrace();
	}
	}
	
	public void testCrudWithList() {
		try{
		this.estadoDAO.merge(EstadoMock.getModelos());
		this.cidadeDAO.merge(CidadeMock.getModelos());
		this.bairroDAO.merge(BairroMock.getModelos());
		
		this.tipoComercioDAO.merge(TipoComercioMock.getModelos());
		this.problemaDAO.merge(ProblemaMock.getModelos());
		
		this.servidorDAO.merge(ServidorMock.getModelos());
		this.eventoDAO.merge(EventoMock.getModelos());
		this.comercioDAO.merge(ComercioMock.getModelos());
		this.crudWithList(VisitaSanitariaMock.getModelos());

		this.cidadeDAO.deleteAll();
		this.estadoDAO.deleteAll();
		this.bairroDAO.deleteAll();
		this.eventoDAO.deleteAll();
		this.tipoComercioDAO.deleteAll();
		this.comercioDAO.deleteAll();
		this.servidorDAO.deleteAll();
		this.problemaDAO.deleteAll();
		this.visitaSanitariaDAO.deleteAll();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
