package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.GrupoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Grupo;
import android.test.AndroidTestCase;

public class GrupoDAOTest extends AndroidTestCase {

	private GrupoDAO grupoDao;

	public GrupoDAOTest() {
		super();

		this.grupoDao = GrupoDAO.getInstance();
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

		this.grupoDao.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Grupo grupo = GrupoDAOTest.getGrupos().get(0);

			assertEquals(true, this.grupoDao.deleteAll());

			assertEquals(true, this.grupoDao.save(grupo, true));

			assertEquals(grupo, this.grupoDao.find(grupo));

			grupo.setSituacao('0');

			assertEquals(true, this.grupoDao.merge(grupo));

			assertEquals(grupo.getSituacao(), this.grupoDao.find(grupo)
					.getSituacao());

			assertEquals(true, this.grupoDao.delete(grupo));

			assertEquals(0, this.grupoDao.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public static List<Grupo> getGrupos() {
		List<Grupo> grupos = new ArrayList<Grupo>();

		grupos.add(new Grupo((short) 1, "BAR DE ESQUINA",
				"QUALQUER BAR QUE A GENTE BEBI POR AI", '1'));
		grupos.add(new Grupo((short) 2, "LANCHONETE", "PEQUENOS PETISCOS", '1'));
		grupos.add(new Grupo((short) 3, "SUPERMERCADO",
				"GRANDES DISTRIBUIDORES", '1'));
		grupos.add(new Grupo((short) 4, "FARMÁCIA", "FARMÁCIA DE MANIPULAÇÃO",
				'1'));

		return grupos;
	}
}
