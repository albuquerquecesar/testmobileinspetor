package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.FormularioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Formulario;
import br.gov.pe.saudecaruaru.inspetordigital.model.Natureza;

import android.test.AndroidTestCase;

public class FormularioDAOTest extends AndroidTestCase {

	private DivisaoDAO divisaoDAO;
	private NaturezaDAO naturezaDAO;
	private FormularioDAO formularioDAO;

	
	public FormularioDAOTest() {
		super();

		this.divisaoDAO = DivisaoDAO.getInstance();
		this.naturezaDAO = NaturezaDAO.getInstance();
		this.formularioDAO = FormularioDAO.getInstance();
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

		this.divisaoDAO.merge(DivisaoDAOTest.getDivisoes());
		this.naturezaDAO.merge(NaturezaDAOTest.getnaturezas());

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

		this.formularioDAO.deleteAll();
		this.naturezaDAO.deleteAll();
		this.divisaoDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Formulario formulario = FormularioDAOTest.getformularios().get(0);

			assertEquals(true, this.formularioDAO.deleteAll());
			assertEquals(true, this.formularioDAO.save(formulario, true));
			assertEquals(formulario, this.formularioDAO.find(formulario));
			assertEquals(1, this.formularioDAO.findAll().size());
			assertEquals(true, this.formularioDAO.delete(formulario));
			assertEquals(0, this.formularioDAO.findAll().size());

			assertEquals(true, this.formularioDAO.merge(formulario));
			assertEquals(1, this.formularioDAO.findAll().size());
			assertEquals(true, this.formularioDAO.deleteAll());
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
			List<Formulario> formularios = FormularioDAOTest.getformularios();

			assertEquals(true, this.formularioDAO.deleteAll());
			assertEquals(true, this.formularioDAO.save(formularios, true));
			assertEquals(formularios.size(), this.formularioDAO.findAll()
					.size());
			assertEquals(true, this.formularioDAO.deleteAll());
			assertEquals(0, this.formularioDAO.findAll().size());
			assertEquals(true, this.formularioDAO.merge(formularios));
			assertEquals(true, this.formularioDAO.merge(formularios));

			Natureza natureza = formularios.get(0).getNatureza();
			assertEquals(false, this.formularioDAO.findAllBy(natureza)
					.isEmpty());
			assertEquals(formularios.size(), this.formularioDAO.findAll()
					.size());
			assertEquals(true, this.formularioDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public static List<Formulario> getformularios() {
		List<Natureza> naturezas = NaturezaDAOTest.getnaturezas();
		List<Formulario> formularios = new ArrayList<Formulario>();

		formularios.add(new Formulario("Formulario de lanchonete",
				"para pequenas lanchonetes", naturezas.get(0), 1));
		formularios.add(new Formulario("Formulario de padaria",
				"padarias e restaurantes", naturezas.get(3), 2));
		formularios.add(new Formulario("Formulario de carro pipa",
				"caminhões que vendem água potável", naturezas.get(1), 3));
		formularios.add(new Formulario("Formulario de barraquinha",
				"carrinhos de doce e ambulantes", naturezas.get(2), 4));

		return formularios;
	}
}
