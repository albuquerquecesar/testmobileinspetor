package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.OpcaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Opcao;
import android.test.AndroidTestCase;

public class OpcaoDAOTest extends AndroidTestCase {

	private OpcaoDAO opcaoDAO;

	
	public OpcaoDAOTest() {
		super();

		this.opcaoDAO = OpcaoDAO.getInstance();
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
		this.opcaoDAO.deleteAll();
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
		this.opcaoDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Opcao opcao = OpcaoDAOTest.getOpcoes().get(0);

			assertEquals(true, this.opcaoDAO.deleteAll());
			assertEquals(true, this.opcaoDAO.save(opcao, true));
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false, this.opcaoDAO.save(opcao, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(1, this.opcaoDAO.findAll().size());
			assertEquals(opcao, this.opcaoDAO.find(opcao));
			assertEquals(true, this.opcaoDAO.merge(opcao));
			assertEquals(1, this.opcaoDAO.findAll().size());

			opcao.setNome("teste");

			assertEquals(true, this.opcaoDAO.update(opcao));
			assertEquals("teste", this.opcaoDAO.find(opcao).getNome());
			assertEquals(1, this.opcaoDAO.findAll().size());

			assertEquals(true, this.opcaoDAO.merge(opcao));
			assertEquals(1, this.opcaoDAO.findAll().size());

			assertEquals(true, this.opcaoDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public void testCrudWithList() {
		boolean ok = true;
		try {
			List<Opcao> opcoes = OpcaoDAOTest.getOpcoes();

			assertEquals(true, this.opcaoDAO.deleteAll());
			assertEquals(true, this.opcaoDAO.save(opcoes, true));
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false, this.opcaoDAO.save(opcoes, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(opcoes.size(), this.opcaoDAO.findAll().size());
			assertEquals(true, this.opcaoDAO.merge(opcoes));

			List<Opcao> temp = this.opcaoDAO.findAll();
			assertEquals(opcoes.size(), temp.size());
			Opcao opcao = new Opcao("mais um teste", 8, 1);
			opcoes.add(opcao);
			assertEquals(true, this.opcaoDAO.merge(opcoes));
			assertEquals(opcoes.size(), this.opcaoDAO.findAll().size());
			assertEquals(true, this.opcaoDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<Opcao> getOpcoes() {

		List<Opcao> opcoes = new ArrayList<Opcao>();

		opcoes.add(new Opcao("sim", 1, Opcao.TIPO_FECHADA));
		opcoes.add(new Opcao("não", 2, Opcao.TIPO_FECHADA));
		opcoes.add(new Opcao("não se aplica", 3, Opcao.TIPO_FECHADA));
		opcoes.add(new Opcao("outro", 4, Opcao.TIPO_FECHADA));

		return opcoes;
	}

}
