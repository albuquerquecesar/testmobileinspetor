package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ProprietarioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Proprietario;

public class ProprietarioDAOTest extends AndroidTestCase {

	private ProprietarioDAO proprietarioDAO;

	
	public ProprietarioDAOTest() {
		super();

		this.proprietarioDAO = ProprietarioDAO.getInstance();
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

		this.proprietarioDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Proprietario proprietario = ProprietarioDAOTest.getProprietarios()
					.get(0);

			assertEquals(true, this.proprietarioDAO.deleteAll());
			assertEquals(true, this.proprietarioDAO.save(proprietario, true));
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false,
						this.proprietarioDAO.save(proprietario, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(1, this.proprietarioDAO.findAll().size());
			assertEquals(proprietario, this.proprietarioDAO.find(proprietario));
			assertEquals(true, this.proprietarioDAO.merge(proprietario));
			assertEquals(1, this.proprietarioDAO.findAll().size());

			proprietario.setNome("joaozinho");

			assertEquals(true, this.proprietarioDAO.update(proprietario));
			assertEquals(proprietario.getNome(),
					this.proprietarioDAO.find(proprietario).getNome());
			assertEquals(1, this.proprietarioDAO.findAll().size());

			assertEquals(true, this.proprietarioDAO.merge(proprietario));
			assertEquals(proprietario.getNome(),
					this.proprietarioDAO.find(proprietario).getNome());
			assertEquals(1, this.proprietarioDAO.findAll().size());

			assertEquals(true, this.proprietarioDAO.deleteAll());
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
			List<Proprietario> servidores = ProprietarioDAOTest
					.getProprietarios();

			assertEquals(true, this.proprietarioDAO.deleteAll());
			assertEquals(true, this.proprietarioDAO.save(servidores, true));
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false, this.proprietarioDAO.save(servidores, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(servidores.size(), this.proprietarioDAO.findAll()
					.size());
			assertEquals(true, this.proprietarioDAO.merge(servidores));

			List<Proprietario> temp = this.proprietarioDAO.findAll();
			assertEquals(servidores.size(), temp.size());
			Proprietario ser = new Proprietario("874632334", "testinha",
					"america@yahoo.com.br");
			servidores.add(ser);
			assertEquals(true, this.proprietarioDAO.merge(servidores));
			assertEquals(servidores.size(), this.proprietarioDAO.findAll()
					.size());
			assertEquals(true, this.proprietarioDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public static List<Proprietario> getProprietarios() {

		List<Proprietario> proprietarios = new ArrayList<Proprietario>();

		proprietarios.add(new Proprietario("0348581239", "cesar henrique",
				"cesar@dimb.com)"));
		proprietarios.add(new Proprietario("033490343", "pires junior",
				"pires@gmail.com"));
		proprietarios.add(new Proprietario("0348512239", "cesar henrique",
				"henrique@gmail.com"));
		proprietarios.add(new Proprietario("0348534909", "cesar albuquerque",
				"albuquerque@hotmail.com"));

		return proprietarios;
	}
}
