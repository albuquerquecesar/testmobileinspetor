package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.OrgaoReguladorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ResponsavelDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.OrgaoRegulador;
import br.gov.pe.saudecaruaru.inspetordigital.model.Responsavel;
import android.test.AndroidTestCase;

public class ResponsavelDAOTest extends AndroidTestCase {

	private ResponsavelDAO responsavelDAO;
	private OrgaoReguladorDAO orgaoReguladorDAO;

	
	public ResponsavelDAOTest() {
		super();

		this.orgaoReguladorDAO = OrgaoReguladorDAO.getInstance();
		this.responsavelDAO = ResponsavelDAO.getInstance();
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
		this.responsavelDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Responsavel responsavel = ResponsavelDAOTest.getResponsaveis().get(
					0);

			assertEquals(true, this.responsavelDAO.deleteAll());
			assertEquals(true, this.responsavelDAO.save(responsavel, true));
			try {
				ok = false;
				assertEquals(false, this.responsavelDAO.save(responsavel, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(1, this.responsavelDAO.findAll().size());
			assertEquals(responsavel, this.responsavelDAO.find(responsavel));
			assertEquals(true, this.responsavelDAO.merge(responsavel));
			assertEquals(1, this.responsavelDAO.findAll().size());

			OrgaoRegulador orgao = OrgaoReguladorDAOTest.getOrgaoReguladores()
					.get(3);

			responsavel.setOrgaoRegulador(orgao);

			assertEquals(true, this.responsavelDAO.update(responsavel));
			assertEquals(orgao, this.responsavelDAO.find(responsavel)
					.getOrgaoRegulador());
			assertEquals(1, this.responsavelDAO.findAll().size());

			assertEquals(true, this.responsavelDAO.merge(responsavel));
			assertEquals(orgao, this.responsavelDAO.find(responsavel)
					.getOrgaoRegulador());
			assertEquals(1, this.responsavelDAO.findAll().size());

			assertEquals(true, this.responsavelDAO.deleteAll());
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

			List<Responsavel> responsaveis = ResponsavelDAOTest
					.getResponsaveis();

			assertEquals(true, this.responsavelDAO.deleteAll());
			assertEquals(true, this.responsavelDAO.save(responsaveis, true));
			try {
				ok = false;
				assertEquals(false,
						this.responsavelDAO.save(responsaveis, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(responsaveis.size(), this.responsavelDAO.findAll()
					.size());
			assertEquals(true, this.responsavelDAO.merge(responsaveis));

			List<Responsavel> temp = this.responsavelDAO.findAll();
			assertEquals(responsaveis.size(), temp.size());
			Responsavel respon = new Responsavel("874632334", "testinha");
			responsaveis.add(respon);
			assertEquals(true, this.responsavelDAO.merge(responsaveis));
			assertEquals(responsaveis.size(), this.responsavelDAO.findAll()
					.size());
			assertEquals(true, this.responsavelDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<Responsavel> getResponsaveis() {

		List<OrgaoRegulador> orgoes = OrgaoReguladorDAOTest
				.getOrgaoReguladores();
		List<Responsavel> responsaveis = new ArrayList<Responsavel>();

		responsaveis.add(new Responsavel("0348581239", "cesar henrique", orgoes
				.get(0), "3434"));
		responsaveis.add(new Responsavel("033490343", "pires junior", orgoes
				.get(1), "55242"));
		responsaveis.add(new Responsavel("0348512239", "cesar henrique"));
		responsaveis.add(new Responsavel("0348534909", "cesar henrique"));

		return responsaveis;
	}
}
