package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ComercioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ServidorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.TipoComercioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.BairroMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.CidadeMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ComercioMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EstadoMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.ServidorMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.TipoComercioMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;
import br.gov.pe.saudecaruaru.inspetordigital.model.Cidade;
import br.gov.pe.saudecaruaru.inspetordigital.model.Comercio;
import br.gov.pe.saudecaruaru.inspetordigital.model.Servidor;
import br.gov.pe.saudecaruaru.inspetordigital.model.TipoComercio;

public class ComercioDAOTest extends BaseDAOTest<Comercio>{

	private BairroDAO bairroDAO;
	private EstadoDAO estadoDAO;
	private CidadeDAO cidadeDAO;
	private ComercioDAO comercioDAO;
	private TipoComercioDAO tipoComercioDAO;
	private ServidorDAO servidorDAO;
	
	
	public ComercioDAOTest() {
		super(ComercioDAO.getInstance());
		this.bairroDAO=BairroDAO.getInstance();
		this.cidadeDAO=CidadeDAO.getInstance();
		this.estadoDAO=EstadoDAO.getInstance();
		this.comercioDAO=ComercioDAO.getInstance();
		this.tipoComercioDAO=TipoComercioDAO.getInstance();
		this.servidorDAO=ServidorDAO.getInstance();
		
	}

	/* (non-Javadoc)
	 * @see br.gov.pe.saudecaruaru.inspetordigital.dao.test.BaseDAOTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		this.estadoDAO.merge(EstadoMock.getModelos());
		this.cidadeDAO.merge(CidadeMock.getModelos());
		this.bairroDAO.merge(BairroMock.getModelos());
		this.tipoComercioDAO.merge(TipoComercioMock.getModelos());
		this.servidorDAO.merge(ServidorMock.getModelos());
		
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
		this.tipoComercioDAO.deleteAll();
		this.servidorDAO.deleteAll();
	}

	
	public void testCrud(){
		Comercio comercio=ComercioMock.getModelos().get(0);
		this.crud(comercio);
		
		//deve gerar erros
		boolean ok=false;
		Cidade cid=comercio.getEndereco().getCidade();
		Bairro bairro=comercio.getEndereco().getBairro();
		Servidor fiscal=comercio.getFiscal();
		TipoComercio tipo=comercio.getTipoComercio();
		
		try{
			assertEquals(true, this.comercioDAO.merge(comercio));
			comercio.getEndereco().setCidade(new Cidade("20xfg00", "qualquer coisa", EstadoMock.getModelos().get(0)));
			assertEquals(false, this.comercioDAO.update(comercio));
		}catch(Exception ex){
			ok=true;
			
		}
		finally{
			assertEquals(true, ok);
			ok=false;
		}
		comercio.getEndereco().setCidade(cid);
		
		
		try{
			comercio.getEndereco().setBairro(new Bairro("4523fdesf542354", "sei lá"));
			assertEquals(false, this.comercioDAO.update(comercio));
		}catch(Exception ex){
			ok=true;
			
		}
		finally{
			assertEquals(true, ok);
		}
		comercio.getEndereco().setBairro(bairro);
		
		try{
			comercio.setTipoComercio(new TipoComercio(4132451, "fweqfewqfewq"));
			assertEquals(false, this.comercioDAO.update(comercio));
		}catch(Exception ex){
			ok=true;
			
		}
		finally{
			assertEquals(true, ok);
		}
		comercio.setTipoComercio(tipo);
		
		try{
			comercio.setFiscal(new Servidor("432142433", "paulo 1234"));
			assertEquals(false, this.comercioDAO.update(comercio));
		}catch(Exception ex){
			ok=true;
			
		}
		finally{
			assertEquals(true, ok);
		}
		
		
		
	}
	
	public void testCrudWithList(){
		this.crudWithList(ComercioMock.getModelos());
	}
}
