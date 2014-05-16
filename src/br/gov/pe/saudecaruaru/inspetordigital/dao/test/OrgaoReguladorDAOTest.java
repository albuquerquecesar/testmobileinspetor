package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;
import br.gov.pe.saudecaruaru.inspetordigital.dao.OrgaoReguladorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.OrgaoRegulador;

public class OrgaoReguladorDAOTest extends AndroidTestCase {

	private OrgaoReguladorDAO orgaoReguladorDAO;

	public OrgaoReguladorDAOTest() {
		super();

		this.orgaoReguladorDAO = OrgaoReguladorDAO.getInstance();
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
		this.orgaoReguladorDAO.deleteAll();
	}


	public void testCrud() {
		boolean ok = true;
		try {
			OrgaoRegulador orgaoRegulador = OrgaoReguladorDAOTest
					.getOrgaoReguladores().get(0);

			assertEquals(true, this.orgaoReguladorDAO.deleteAll());
			assertEquals(true,
					this.orgaoReguladorDAO.save(orgaoRegulador, true));
			assertEquals(1, this.orgaoReguladorDAO.findAll().size());
			assertEquals(orgaoRegulador,
					this.orgaoReguladorDAO.find(orgaoRegulador));
			assertEquals(true, this.orgaoReguladorDAO.delete(orgaoRegulador));
			assertEquals(0, this.orgaoReguladorDAO.findAll().size());
			assertEquals(true, this.orgaoReguladorDAO.merge(orgaoRegulador));
			assertEquals(true, this.orgaoReguladorDAO.merge(orgaoRegulador));
			orgaoRegulador.setNome("bairro de teste");
			assertEquals(true, this.orgaoReguladorDAO.update(orgaoRegulador));
			assertEquals(orgaoRegulador.getNome(),
					this.orgaoReguladorDAO.find(orgaoRegulador).getNome());
			assertEquals(1, this.orgaoReguladorDAO.findAll().size());
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false,
						this.orgaoReguladorDAO.save(orgaoRegulador, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(true, this.orgaoReguladorDAO.deleteAll());
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
			List<OrgaoRegulador> orgaoReguladores = OrgaoReguladorDAOTest
					.getOrgaoReguladores();
			assertEquals(true, this.orgaoReguladorDAO.deleteAll());
			assertEquals(true,
					this.orgaoReguladorDAO.save(orgaoReguladores, true));
			assertEquals(orgaoReguladores.size(), this.orgaoReguladorDAO
					.findAll().size());
			assertEquals(true, this.orgaoReguladorDAO.merge(orgaoReguladores));
			assertEquals(orgaoReguladores.size(), this.orgaoReguladorDAO
					.findAll().size());
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false,
						this.orgaoReguladorDAO.save(orgaoReguladores, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(true, this.orgaoReguladorDAO.deleteAll());
			assertEquals(0, this.orgaoReguladorDAO.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<OrgaoRegulador> getOrgaoReguladores() {
		List<OrgaoRegulador> orgaoReguladores = new ArrayList<OrgaoRegulador>();

		orgaoReguladores.add(new OrgaoRegulador(1L,
				"conselho regional de medicina", "CRM"));
		orgaoReguladores.add(new OrgaoRegulador(2L,
				"conselho regional de enfermagem", "COREN"));
		orgaoReguladores.add(new OrgaoRegulador(3L,
				"conselho regional de nutrição", "CRN"));
		orgaoReguladores.add(new OrgaoRegulador(4L,
				"conselho regional de farmácia", "CRF"));

		return orgaoReguladores;
	}
}
