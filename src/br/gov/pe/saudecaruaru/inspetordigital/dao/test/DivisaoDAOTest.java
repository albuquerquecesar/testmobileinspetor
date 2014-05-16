package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Divisao;
import android.test.AndroidTestCase;

public class DivisaoDAOTest extends AndroidTestCase {

	private DivisaoDAO dao;

	
	public DivisaoDAOTest() {
		super();

		this.dao = DivisaoDAO.getInstance();
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

		this.dao.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Divisao l = DivisaoDAOTest.getDivisoes().get(0);
			assertEquals(true, this.dao.deleteAll());

			assertEquals(true, this.dao.save(l, true));

			assertEquals(this.dao.find(l), l);

			assertEquals(true, this.dao.delete(l));

			assertNull(this.dao.find(l));

			assertEquals(true, this.dao.merge(l));

			assertEquals(this.dao.find(l), l);

			l.setNome("DIVTESTE");

			assertEquals(true, this.dao.update(l));

			assertEquals(this.dao.find(l).getNome(), l.getNome());
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
			List<Divisao> l = DivisaoDAOTest.getDivisoes();
			assertEquals(true, this.dao.deleteAll());

			assertEquals(true, this.dao.merge(l));

			assertEquals(l.size(), this.dao.findAll().size());

			assertEquals(true, this.dao.update(l));

			assertEquals(this.dao.findAll().size(), l.size());

		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public static List<Divisao> getDivisoes() {
		List<Divisao> div = new ArrayList<Divisao>();

		div.add(new Divisao((short) 1, "DICONA", "NOME DE TUDO"));
		div.add(new Divisao((short) 2, "DICMEC", "MEDICAMENTOS"));
		div.add(new Divisao((short) 3, "DITEP", "DIVISÃO DE TECNOLOGIA"));
		div.add(new Divisao((short) 4, "DIPA", "DIVISÃO DE PIPAS"));
		return div;
	}

}
