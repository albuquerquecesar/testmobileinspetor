package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estado;
import android.test.AndroidTestCase;

public class EstadoDAOTest extends AndroidTestCase {

	private EstadoDAO estadoDao;

	
	public EstadoDAOTest() {
		super();
		this.estadoDao = EstadoDAO.getInstance();
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
		this.estadoDao.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Estado estado = new Estado("pernambuc", "PE", "34");

			assertEquals(true, this.estadoDao.deleteAll());

			assertEquals(true, this.estadoDao.save(estado, true));

			List<Estado> l = this.estadoDao.findAll();

			assertEquals(1, l.size());

			assertEquals(estado, l.get(0));

			assertEquals(true, this.estadoDao.delete(estado));

			l = this.estadoDao.findAll();

			assertEquals(0, l.size());

			estado.setNome("PERNAMBUCO");

			assertEquals(true, this.estadoDao.merge(estado));

			assertEquals(estado.getNome(), this.estadoDao.find(estado)
					.getNome());

			assertEquals(true,this.estadoDao.deleteAll());

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
			List<Estado> l = EstadoDAOTest.getEstados();
			assertEquals(true, this.estadoDao.deleteAll());

			assertEquals(true, this.estadoDao.save(l, true));

			assertEquals(l.size(), this.estadoDao.findAll().size());

			assertEquals(true, this.estadoDao.delete(l.get(0)));

			assertEquals((l.size() - 1), this.estadoDao.findAll().size());

			assertEquals(true, this.estadoDao.merge(l));

			assertEquals(l.size(), this.estadoDao.findAll().size());

			this.estadoDao.deleteAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public static List<Estado> getEstados() {
		List<Estado> list = new ArrayList<Estado>();

		list.add(new Estado("ALAGOAS", "AL", "12"));
		list.add(new Estado("pernambuco", "PE", "26"));
		list.add(new Estado("SÃO PAULO", "SP", "23"));
		list.add(new Estado("bahia", "BA", "29"));

		return list;
	}
}
