package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.BairroMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;
import android.test.AndroidTestCase;

public class BairroDAOTest extends AndroidTestCase {

	private BairroDAO bairroDAO;

	
	public BairroDAOTest() {
		super();

		this.bairroDAO = BairroDAO.getInstance();
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
		this.bairroDAO.deleteAll();
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
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Bairro bairro = BairroMock.getModelos().get(0);

			assertEquals(true, this.bairroDAO.deleteAll());
			assertEquals(true, this.bairroDAO.save(bairro, true));
			assertEquals(1, this.bairroDAO.findAll().size());
			assertEquals(bairro, this.bairroDAO.find(bairro));
			assertEquals(true, this.bairroDAO.delete(bairro));
			assertEquals(0, this.bairroDAO.findAll().size());
			assertEquals(true, this.bairroDAO.merge(bairro));
			assertEquals(true, this.bairroDAO.merge(bairro));
			bairro.setNome("bairro de teste");
			assertEquals(true, this.bairroDAO.update(bairro));
			assertEquals(bairro.getNome(), this.bairroDAO.find(bairro)
					.getNome());
			assertEquals(1, this.bairroDAO.findAll().size());
			// deve lançar ma exceção
			try {
				ok = false;
				assertEquals(false, this.bairroDAO.save(bairro, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(true, this.bairroDAO.deleteAll());
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
			List<Bairro> bairros = BairroMock.getModelos();
			assertEquals(true, this.bairroDAO.deleteAll());
			assertEquals(true, this.bairroDAO.save(bairros, true));
			assertEquals(bairros.size(), this.bairroDAO.findAll().size());
			assertEquals(true, this.bairroDAO.merge(bairros));
			assertEquals(bairros.size(), this.bairroDAO.findAll().size());
			// deve lançar ma exceção
			try {
				ok = false;
				assertEquals(false, this.bairroDAO.save(bairros, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(true, this.bairroDAO.deleteAll());
			assertEquals(0, this.bairroDAO.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}
}
