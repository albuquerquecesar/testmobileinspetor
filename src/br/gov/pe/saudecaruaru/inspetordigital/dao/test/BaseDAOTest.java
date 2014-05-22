package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.GenericDb4oDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estado;
import br.gov.pe.saudecaruaru.inspetordigital.model.IModel;
import android.test.AndroidTestCase;

public class BaseDAOTest<T extends IModel<T>> extends AndroidTestCase{

	private GenericDb4oDAO<T> dao;

	public BaseDAOTest(GenericDb4oDAO<T> dao) {
		super();
		this.dao = dao;
	}
	
	
	
	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}



	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		this.dao.deleteAll();
		super.tearDown();
	}



	public void crud(T model) {
		boolean ok = true;
		try {


			assertEquals(true, this.dao.save(model, true));

			List<T> l = this.dao.findAll();

			assertEquals(1, l.size());

			assertEquals(model, l.get(0));

			assertEquals(true, this.dao.delete(model));

			l = this.dao.findAll();

			assertEquals(0, l.size());


			assertEquals(true, this.dao.merge(model));

			assertEquals(model, this.dao.find(model)
					);


		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public void crudWithList(List<T> modelos) {
		boolean ok = true;
		try {

			assertEquals(true, this.dao.save(modelos, true));

			assertEquals(modelos.size(), this.dao.findAll().size());

			assertEquals(true, this.dao.delete(modelos.get(0)));

			assertEquals((modelos.size() - 1), this.dao.findAll().size());

			assertEquals(true, this.dao.merge(modelos));

			assertEquals(modelos.size(), this.dao.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}
}
