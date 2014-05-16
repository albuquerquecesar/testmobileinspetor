package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Divisao;
import br.gov.pe.saudecaruaru.inspetordigital.model.Natureza;
import android.test.AndroidTestCase;

public class NaturezaDAOTest extends AndroidTestCase {

	private NaturezaDAO naturezaDao;
	private DivisaoDAO divisaoDao;
	private List<Natureza> naturezas;

	
	public NaturezaDAOTest() {
		super();

		this.naturezaDao = NaturezaDAO.getInstance();
		this.naturezas = NaturezaDAOTest.getnaturezas();

		divisaoDao = DivisaoDAO.getInstance();
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
		this.naturezaDao.deleteAll();
		divisaoDao.merge(DivisaoDAOTest.getDivisoes());
	}

	public void testCrudList() {
		boolean ok = true;
		try {
			assertEquals(true, this.naturezaDao.deleteAll());

			assertEquals(0, this.naturezaDao.findAll().size());

			assertEquals(true, this.naturezaDao.merge(this.naturezas));
			List<Natureza> temp = this.naturezaDao.findAll();
			assertEquals(this.naturezas.size(), temp.size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public static List<Natureza> getnaturezas() {
		List<Divisao> divisoes = DivisaoDAOTest.getDivisoes();

		List<Natureza> naturezas = new ArrayList<Natureza>();

		naturezas.add(new Natureza("01", "BAR", divisoes.get(0)));
		naturezas.add(new Natureza("02", "BAR", divisoes.get(1)));
		naturezas.add(new Natureza("02", "BAR", divisoes.get(2)));
		naturezas.add(new Natureza("03", "BAR", divisoes.get(2)));

		return naturezas;
	}

	public void testCrud() {
		boolean ok = true;

		try {
			Natureza nat = new Natureza("0345", "natureza de teste",
					new Divisao((short) 1, ""));
			assertEquals(true, this.naturezaDao.save(nat,true));

			assertEquals(nat, this.naturezaDao.find(nat));
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}
}
