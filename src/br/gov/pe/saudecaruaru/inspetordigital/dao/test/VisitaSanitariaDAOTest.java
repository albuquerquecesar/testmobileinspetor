package br.gov.pe.saudecaruaru.inspetordigital.dao.test;


import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ComercioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EventoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ProblemaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ServidorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.SituacaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.TipoComercioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.VisitaSanitariaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.BairroMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.CidadeMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ComercioMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EstadoMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EventoMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ProblemaMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ServidorMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.SituacaoMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.TipoComercioMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.VisitaSanitariaMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.VisitaSanitaria;

public class VisitaSanitariaDAOTest extends BaseDAOTest<VisitaSanitaria>{

	private BairroDAO bairroDAO;
	private EstadoDAO estadoDAO;
	private CidadeDAO cidadeDAO;
	private TipoComercioDAO tipoComercioDAO;
	private ProblemaDAO problemaDAO;
	private SituacaoDAO situacaoDAO;
	private ComercioDAO comercioDAO;
	private EventoDAO eventoDAO;
	private ServidorDAO servidorDAO;
	private VisitaSanitariaDAO visitaSanitariaDAO;
	
	public VisitaSanitariaDAOTest() {
		
		super(VisitaSanitariaDAO.getInstance());
		this.visitaSanitariaDAO=VisitaSanitariaDAO.getInstance();
		this.bairroDAO=BairroDAO.getInstance();
		this.cidadeDAO=CidadeDAO.getInstance();
		this.comercioDAO=ComercioDAO.getInstance();
		this.estadoDAO=EstadoDAO.getInstance();
		this.eventoDAO=EventoDAO.getInstance();
		this.problemaDAO=ProblemaDAO.getInstance();
		this.situacaoDAO=SituacaoDAO.getInstance();
		this.tipoComercioDAO=TipoComercioDAO.getInstance();
		this.servidorDAO=ServidorDAO.getInstance();
		
	}

	/* (non-Javadoc)
	 * @see br.gov.pe.saudecaruaru.inspetordigital.dao.test.BaseDAOTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.bairroDAO.merge(BairroMock.getModelos());
		this.estadoDAO.merge(EstadoMock.getModelos());
		this.cidadeDAO.merge(CidadeMock.getModelos());
		
		this.tipoComercioDAO.merge(TipoComercioMock.getModelos());
		this.problemaDAO.merge(ProblemaMock.getModelos());
		this.situacaoDAO.merge(SituacaoMock.getModelos());
		this.servidorDAO.merge(ServidorMock.getModelos());
		this.comercioDAO.merge(ComercioMock.getModelos());
		this.eventoDAO.merge(EventoMock.getModelos());
		
	}

	/* (non-Javadoc)
	 * @see br.gov.pe.saudecaruaru.inspetordigital.dao.test.BaseDAOTest#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		this.eventoDAO.deleteAll();
		this.comercioDAO.deleteAll();
		this.servidorDAO.deleteAll();
		this.tipoComercioDAO.deleteAll();
		this.problemaDAO.deleteAll();
		this.situacaoDAO.deleteAll();
		this.bairroDAO.deleteAll();
		this.cidadeDAO.deleteAll();
		this.estadoDAO.deleteAll();
	}

	
	public void testCrud(){
		this.crud(VisitaSanitariaMock.getModelos().get(0));
	}
	
	public void testCrudWithList(){
		this.crudWithList(VisitaSanitariaMock.getModelos());
	}
}