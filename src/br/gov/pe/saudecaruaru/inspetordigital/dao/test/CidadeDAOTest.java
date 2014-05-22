package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.CidadeMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EstadoMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Cidade;
import android.test.AndroidTestCase;

public class CidadeDAOTest extends AndroidTestCase {

	private CidadeDAO cidadeDAO;
	private EstadoDAO estadoDAO;

	
	public CidadeDAOTest() {
		super();

		this.cidadeDAO = CidadeDAO.getInstance();
		this.estadoDAO = EstadoDAO.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();

		this.estadoDAO.merge(EstadoMock.getModelos());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		this.estadoDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Cidade cidade = CidadeMock.getModelos().get(0);

			assertEquals(true, this.cidadeDAO.deleteAll());
			assertEquals(true, this.cidadeDAO.save(cidade, true));
			// deve lançar ma exceção
			try {
				ok = false;
				assertEquals(false, this.cidadeDAO.save(cidade, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(1, this.cidadeDAO.findAll().size());
			assertEquals(cidade, this.cidadeDAO.find(cidade));
			assertEquals(true, this.cidadeDAO.delete(cidade));
			assertEquals(0, this.cidadeDAO.findAll().size());
			assertEquals(true, this.cidadeDAO.merge(cidade));
			assertEquals(true, this.cidadeDAO.merge(cidade));
			cidade.setNome("bairro de teste");
			assertEquals(true, this.cidadeDAO.update(cidade));
			assertEquals(cidade.getNome(), this.cidadeDAO.find(cidade)
					.getNome());
			assertEquals(1, this.cidadeDAO.findAll().size());
			// deve lançar ma exceção
			try {
				ok = false;
				assertEquals(false, this.cidadeDAO.save(cidade, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;

			assertEquals(true, this.cidadeDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public void testCridWithList() {
		boolean ok = true;
		try {
			List<Cidade> cidades = CidadeMock.getModelos();
			assertEquals(true, this.cidadeDAO.deleteAll());
			assertEquals(true, this.cidadeDAO.save(cidades, true));
			assertEquals(cidades.size(), this.cidadeDAO.findAll().size());
			assertEquals(true, this.cidadeDAO.merge(cidades));
			assertEquals(cidades.size(), this.cidadeDAO.findAll().size());
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false, this.cidadeDAO.save(cidades, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(true, this.cidadeDAO.deleteAll());
			assertEquals(0, this.cidadeDAO.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}
}
