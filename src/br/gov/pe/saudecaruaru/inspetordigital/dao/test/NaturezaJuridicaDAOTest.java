package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaJuridicaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.NaturezaJuridica;
import android.test.AndroidTestCase;

public class NaturezaJuridicaDAOTest extends AndroidTestCase {

	private NaturezaJuridicaDAO naturezaJuridicaDAO;

	
	public NaturezaJuridicaDAOTest() {
		super();

		this.naturezaJuridicaDAO = NaturezaJuridicaDAO.getInstance();
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
		this.naturezaJuridicaDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {

			NaturezaJuridica naturezaJuridica = NaturezaJuridicaDAOTest
					.getNaturezaJuridicas().get(0);

			assertEquals(true, this.naturezaJuridicaDAO.deleteAll());
			assertEquals(true,
					this.naturezaJuridicaDAO.save(naturezaJuridica, true));
			assertEquals(1, this.naturezaJuridicaDAO.findAll().size());
			assertEquals(naturezaJuridica,
					this.naturezaJuridicaDAO.find(naturezaJuridica));
			assertEquals(true,
					this.naturezaJuridicaDAO.delete(naturezaJuridica));
			assertEquals(0, this.naturezaJuridicaDAO.findAll().size());
			assertEquals(true, this.naturezaJuridicaDAO.merge(naturezaJuridica));
			assertEquals(true, this.naturezaJuridicaDAO.merge(naturezaJuridica));
			naturezaJuridica.setNome("bairro de teste");
			assertEquals(true,
					this.naturezaJuridicaDAO.update(naturezaJuridica));
			assertEquals(naturezaJuridica.getNome(), this.naturezaJuridicaDAO
					.find(naturezaJuridica).getNome());
			assertEquals(1, this.naturezaJuridicaDAO.findAll().size());
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false,
						this.naturezaJuridicaDAO.save(naturezaJuridica, true));
			} catch(Exception ex){
				ok=true;
			}
			finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(true, this.naturezaJuridicaDAO.deleteAll());

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
			List<NaturezaJuridica> NaturezaJuridicas = NaturezaJuridicaDAOTest
					.getNaturezaJuridicas();
			assertEquals(true, this.naturezaJuridicaDAO.deleteAll());
			assertEquals(true,
					this.naturezaJuridicaDAO.save(NaturezaJuridicas, true));
			assertEquals(NaturezaJuridicas.size(), this.naturezaJuridicaDAO
					.findAll().size());
			assertEquals(true,
					this.naturezaJuridicaDAO.merge(NaturezaJuridicas));
			assertEquals(NaturezaJuridicas.size(), this.naturezaJuridicaDAO
					.findAll().size());
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false,
						this.naturezaJuridicaDAO.save(NaturezaJuridicas, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(true, this.naturezaJuridicaDAO.deleteAll());
			assertEquals(0, this.naturezaJuridicaDAO.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public static List<NaturezaJuridica> getNaturezaJuridicas() {
		List<NaturezaJuridica> naturezaJuridicas = new ArrayList<NaturezaJuridica>();

		naturezaJuridicas.add(new NaturezaJuridica("governamental", (short) 1));
		naturezaJuridicas.add(new NaturezaJuridica("filantrópica", (short) 2));
		naturezaJuridicas.add(new NaturezaJuridica("privada", (short) 3));
		naturezaJuridicas.add(new NaturezaJuridica("publica", (short) 4));

		return naturezaJuridicas;
	}
}
