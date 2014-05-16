package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.FormularioPerguntaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.FormularioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.GrupoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.PerguntaFechadaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Formulario;
import br.gov.pe.saudecaruaru.inspetordigital.model.FormularioPergunta;
import br.gov.pe.saudecaruaru.inspetordigital.model.Grupo;
import br.gov.pe.saudecaruaru.inspetordigital.model.Pergunta;
import br.gov.pe.saudecaruaru.inspetordigital.model.PerguntaFechada;
import android.test.AndroidTestCase;

public class FormularioPerguntaDAOTest extends AndroidTestCase {

	private DivisaoDAO divisaoDAO;
	private NaturezaDAO naturezaDAO;
	private GrupoDAO grupoDAO;
	private PerguntaFechadaDAO perguntaFechadaDAO;
	private FormularioDAO formularioDAO;
	private FormularioPerguntaDAO formularioPerguntaDAO;

	public FormularioPerguntaDAOTest() {
		super();

		this.divisaoDAO = DivisaoDAO.getInstance();
		this.naturezaDAO = NaturezaDAO.getInstance();
		this.grupoDAO = GrupoDAO.getInstance();
		this.perguntaFechadaDAO = PerguntaFechadaDAO.getInstance();
		this.formularioDAO = FormularioDAO.getInstance();
		this.formularioPerguntaDAO = FormularioPerguntaDAO.getInstance();
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
		this.grupoDAO.merge(GrupoDAOTest.getGrupos());
		this.perguntaFechadaDAO.merge(PerguntaFechadaDAOTest.getPerguntas());
		this.formularioDAO.merge(FormularioDAOTest.getformularios());
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

	public void testCrud() {
		boolean ok = true;
		try {
			Formulario formulario = FormularioDAOTest.getformularios().get(0);
			List<PerguntaFechada> perguntaFechadas = PerguntaFechadaDAOTest
					.getPerguntas();
			FormularioPergunta form = null;

			form = new FormularioPergunta(formulario, perguntaFechadas.get(0));
			assertEquals(true, this.formularioPerguntaDAO.deleteAll());
			assertEquals(true, this.formularioPerguntaDAO.save(form, true));
			assertEquals(1, this.formularioPerguntaDAO.findAll().size());
			assertEquals(true, this.formularioPerguntaDAO.merge(form));
			assertEquals(1, this.formularioPerguntaDAO.findAll().size());
			// não deve salvar e sim lançar exceções
			try {
				ok = false;
				assertEquals(false, this.formularioPerguntaDAO.save(form, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			this.formularioPerguntaDAO.deleteAll();
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
			List<FormularioPergunta> formularioPerguntas = FormularioPerguntaDAOTest
					.getFormularioPergunta();

			assertEquals(true, this.formularioPerguntaDAO.deleteAll());
			assertEquals(true,
					this.formularioPerguntaDAO.save(formularioPerguntas, true));

			assertEquals(formularioPerguntas.size(), this.formularioPerguntaDAO
					.findAll().size());

			assertEquals(true,
					this.formularioPerguntaDAO.merge(formularioPerguntas));
			assertEquals(formularioPerguntas.size(), this.formularioPerguntaDAO
					.findAll().size());

			// não deve salvar e sim lançar exceções
			try {
				ok = false;
				assertEquals(false, this.formularioPerguntaDAO.save(
						formularioPerguntas, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;

			this.formularioPerguntaDAO.deleteAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public void testMergeWithPerguntas() {
		List<PerguntaFechada> perguntaFechadas = PerguntaFechadaDAOTest
				.getPerguntas();
		Formulario formulario = FormularioDAOTest.getformularios().get(0);

		assertEquals(true, this.formularioPerguntaDAO.deleteAll());
		assertEquals(true, this.formularioPerguntaDAO.merge(formulario,
				perguntaFechadas, '1'));
		assertEquals(perguntaFechadas.size(), this.formularioPerguntaDAO
				.findAll().size());

		assertEquals(true, this.formularioPerguntaDAO.merge(formulario,
				perguntaFechadas, '0'));
		assertEquals(perguntaFechadas.size(), this.formularioPerguntaDAO
				.findAll().size());

		assertEquals(true, this.formularioPerguntaDAO.deleteAll());
	}

	public void testBuscaGruposEPerguntas() {
		boolean ok = true;
		try {
			Set<Grupo> grupos = new HashSet<Grupo>();
			List<FormularioPergunta> formularioPerguntas = FormularioPerguntaDAOTest
					.getFormularioPergunta();
			Formulario tmp = formularioPerguntas.get(0).getFormulario();
			List<Pergunta> perguntas = new ArrayList<Pergunta>();

			for (FormularioPergunta formularioPergunta : FormularioPerguntaDAOTest
					.getFormularioPergunta()) {
				if (formularioPergunta.getFormulario().equals(tmp)) {
					perguntas.add(formularioPergunta.getPergunta());
					grupos.add(formularioPergunta.getPergunta().getGrupo());
				}
			}

			assertEquals(true,
					this.formularioPerguntaDAO.merge(formularioPerguntas));
			assertEquals(formularioPerguntas.size(), this.formularioPerguntaDAO
					.findAll().size());
			assertEquals(grupos.size(), this.formularioPerguntaDAO
					.findAllGrupos(tmp.getCodigo(), '1').size());
			assertEquals(perguntas.size(), this.formularioPerguntaDAO
					.findAllPerguntasOf(tmp.getCodigo(), '1', null).size());

			assertEquals(true, this.formularioPerguntaDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	/**
	 * Retorna 16 itens com 4 formulários diferentes, os quais têm 4 perguntas
	 * 
	 * @return
	 */
	public static List<FormularioPergunta> getFormularioPergunta() {
		List<Formulario> formularios = FormularioDAOTest.getformularios();
		List<PerguntaFechada> perguntaFechadas = PerguntaFechadaDAOTest
				.getPerguntas();

		List<FormularioPergunta> formularioPerguntas = new ArrayList<FormularioPergunta>();

		formularioPerguntas.add(new FormularioPergunta(formularios.get(0),
				perguntaFechadas.get(0)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(0),
				perguntaFechadas.get(1)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(0),
				perguntaFechadas.get(2)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(0),
				perguntaFechadas.get(3)));

		formularioPerguntas.add(new FormularioPergunta(formularios.get(1),
				perguntaFechadas.get(0)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(1),
				perguntaFechadas.get(1)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(1),
				perguntaFechadas.get(2)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(1),
				perguntaFechadas.get(3)));

		formularioPerguntas.add(new FormularioPergunta(formularios.get(2),
				perguntaFechadas.get(0)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(2),
				perguntaFechadas.get(1)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(2),
				perguntaFechadas.get(2)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(2),
				perguntaFechadas.get(3)));

		formularioPerguntas.add(new FormularioPergunta(formularios.get(3),
				perguntaFechadas.get(0)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(3),
				perguntaFechadas.get(1)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(3),
				perguntaFechadas.get(2)));
		formularioPerguntas.add(new FormularioPergunta(formularios.get(3),
				perguntaFechadas.get(3)));

		return formularioPerguntas;
	}
}
