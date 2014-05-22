package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EventoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.BairroMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.CidadeMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EstadoMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EventoMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;
import br.gov.pe.saudecaruaru.inspetordigital.model.Cidade;
import br.gov.pe.saudecaruaru.inspetordigital.model.Evento;

public class EventoDAOTest extends BaseDAOTest<Evento> {

	private BairroDAO bairroDAO;
	private EstadoDAO estadoDAO;
	private CidadeDAO cidadeDAO;
	private EventoDAO eventoDAO;
	
	
	public EventoDAOTest() {
		super(EventoDAO.getInstance());
		this.bairroDAO=BairroDAO.getInstance();
		this.cidadeDAO=CidadeDAO.getInstance();
		this.estadoDAO=EstadoDAO.getInstance();
		this.eventoDAO=EventoDAO.getInstance();
		
	}

	/* (non-Javadoc)
	 * @see br.gov.pe.saudecaruaru.inspetordigital.dao.test.BaseDAOTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		this.estadoDAO.merge(EstadoMock.getModelos());
		this.cidadeDAO.merge(CidadeMock.getModelos());
		this.bairroDAO.merge(BairroMock.getModelos());
		
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see br.gov.pe.saudecaruaru.inspetordigital.dao.test.BaseDAOTest#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		this.cidadeDAO.deleteAll();
		this.estadoDAO.deleteAll();
		this.bairroDAO.deleteAll();
	}

	
	public void testCrud(){
		Evento evento=EventoMock.getModelos().get(0);
		this.crud(evento);
		
		//deve gerar erros
		boolean ok=false;
		Cidade cid=evento.getEndereco().getCidade();
		Bairro bairro=evento.getEndereco().getBairro();
		try{
			assertEquals(true, this.eventoDAO.merge(evento));
			evento.getEndereco().setCidade(new Cidade("2000", "qualquer coisa", EstadoMock.getModelos().get(0)));
			assertEquals(false, this.eventoDAO.update(evento));
		}catch(Exception ex){
			ok=true;
			
		}
		finally{
			assertEquals(true, ok);
			ok=false;
		}
		evento.getEndereco().setCidade(cid);
		
		
		try{
			evento.getEndereco().setBairro(new Bairro("4523542354", "sei lá"));
			assertEquals(false, this.eventoDAO.update(evento));
		}catch(Exception ex){
			ok=true;
			
		}
		finally{
			assertEquals(true, ok);
		}
	}
	
	public void testCrudWithList(){
		this.crudWithList(EventoMock.getModelos());
	}
}
