package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.OrgaoReguladorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ServidorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.OrgaoRegulador;
import br.gov.pe.saudecaruaru.inspetordigital.model.Servidor;
import android.test.AndroidTestCase;

public class ServidorDAOTest extends AndroidTestCase {

	private ServidorDAO servidorDAO;
	private OrgaoReguladorDAO orgaoReguladorDAO;

	public ServidorDAOTest() {
		super();

		this.orgaoReguladorDAO = OrgaoReguladorDAO.getInstance();
		this.servidorDAO = ServidorDAO.getInstance();
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

		this.orgaoReguladorDAO.save(
				OrgaoReguladorDAOTest.getOrgaoReguladores(), true);

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
		this.orgaoReguladorDAO.deleteAll();
		this.servidorDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Servidor servidor = ServidorDAOTest.getServidores().get(0);

			assertEquals(true, this.servidorDAO.deleteAll());
			assertEquals(true, this.servidorDAO.save(servidor, true));
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false, this.servidorDAO.save(servidor, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(1, this.servidorDAO.findAll().size());
			assertEquals(servidor, this.servidorDAO.find(servidor));
			assertEquals(true, this.servidorDAO.merge(servidor));
			assertEquals(1, this.servidorDAO.findAll().size());

			OrgaoRegulador orgao = OrgaoReguladorDAOTest.getOrgaoReguladores()
					.get(3);

			servidor.setOrgaoRegulador(orgao);

			assertEquals(true, this.servidorDAO.update(servidor));
			assertEquals(orgao, this.servidorDAO.find(servidor)
					.getOrgaoRegulador());
			assertEquals(1, this.servidorDAO.findAll().size());

			assertEquals(true, this.servidorDAO.merge(servidor));
			assertEquals(orgao, this.servidorDAO.find(servidor)
					.getOrgaoRegulador());
			assertEquals(1, this.servidorDAO.findAll().size());

			assertEquals(true, this.servidorDAO.deleteAll());
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

			List<Servidor> servidores = ServidorDAOTest.getServidores();

			assertEquals(true, this.servidorDAO.deleteAll());
			assertEquals(true, this.servidorDAO.save(servidores, true));
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false, this.servidorDAO.save(servidores, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(servidores.size(), this.servidorDAO.findAll().size());
			assertEquals(true, this.servidorDAO.merge(servidores));

			List<Servidor> temp = this.servidorDAO.findAll();
			assertEquals(servidores.size(), temp.size());
			Servidor ser = new Servidor("874632334", "testinha", "4524");
			servidores.add(ser);
			assertEquals(true, this.servidorDAO.merge(servidores));
			assertEquals(servidores.size(), this.servidorDAO.findAll().size());
			assertEquals(true, this.servidorDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<Servidor> getServidores() {

		List<OrgaoRegulador> orgoes = OrgaoReguladorDAOTest
				.getOrgaoReguladores();
		List<Servidor> servidores = new ArrayList<Servidor>();

		servidores.add(new Servidor("0348581239", "cesar henrique", "3243243",
				orgoes.get(0), "3434"));
		servidores.add(new Servidor("033490343", "pires junior", "34954",
				orgoes.get(1), "55242"));
		servidores.add(new Servidor("0348512239", "cesar henrique", "3243243"));
		servidores.add(new Servidor("0348534909", "cesar henrique", "3243243"));

		return servidores;
	}

}
