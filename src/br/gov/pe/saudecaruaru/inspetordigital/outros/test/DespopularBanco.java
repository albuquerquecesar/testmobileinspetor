package br.gov.pe.saudecaruaru.inspetordigital.outros.test;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.GenericDb4oDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaJuridicaDAO;
import android.test.AndroidTestCase;

public class DespopularBanco extends AndroidTestCase {

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
	}

	public void testFinish() {

		try {
			File file = new File(GenericDb4oDAO.DATA_BASE_FILE);
			assertEquals(true,file.delete());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
