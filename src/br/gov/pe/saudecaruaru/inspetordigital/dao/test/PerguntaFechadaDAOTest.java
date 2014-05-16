package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.GrupoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.OpcaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.PerguntaFechadaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Grupo;
import br.gov.pe.saudecaruaru.inspetordigital.model.Opcao;
import br.gov.pe.saudecaruaru.inspetordigital.model.PerguntaFechada;
import android.test.AndroidTestCase;

public class PerguntaFechadaDAOTest extends AndroidTestCase {

	private DivisaoDAO divisaoDao;
	private NaturezaDAO naturezaDao;
	private PerguntaFechadaDAO perguntaDao;
	private GrupoDAO grupoDao;
	private OpcaoDAO opcaoDAO;

	
	public PerguntaFechadaDAOTest() {
		super();

		this.divisaoDao = DivisaoDAO.getInstance();
		this.grupoDao = GrupoDAO.getInstance();
		this.naturezaDao = NaturezaDAO.getInstance();
		this.perguntaDao = PerguntaFechadaDAO.getInstance();
		this.opcaoDAO = OpcaoDAO.getInstance();
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

		this.divisaoDao.merge(DivisaoDAOTest.getDivisoes());
		this.naturezaDao.merge(NaturezaDAOTest.getnaturezas());
		this.grupoDao.merge(GrupoDAOTest.getGrupos());
		this.opcaoDAO.merge(OpcaoDAOTest.getOpcoes());
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
		this.grupoDao.deleteAll();
		this.naturezaDao.deleteAll();
		this.divisaoDao.deleteAll();
		this.opcaoDAO.deleteAll();
		this.perguntaDao.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			PerguntaFechada perguntaFechada = PerguntaFechadaDAOTest
					.getPerguntas().get(0);

			perguntaFechada.getOpcoes().clear();

			Opcao opcao1 = new Opcao("ceceio", 999123, Opcao.TIPO_FECHADA);
			Opcao opcao2 = new Opcao("mofqwije", 32443, Opcao.TIPO_FECHADA);

			perguntaFechada.getOpcoes().add(opcao1);

			assertEquals(true, this.perguntaDao.save(perguntaFechada, true));
			try {
				ok = false;
				assertEquals(false,
						this.perguntaDao.save(perguntaFechada, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(1, this.perguntaDao.findAll().size());
			PerguntaFechada tmp = this.perguntaDao.find(perguntaFechada);
			assertEquals(perguntaFechada, tmp);
			assertEquals(1, tmp.getOpcoes().size());
			// testa os atributos referenciados.
			Grupo grupo = GrupoDAOTest.getGrupos().get(2);
			perguntaFechada.setGrupo(grupo);
			perguntaFechada.getOpcoes().add(opcao2);
			perguntaFechada.setNome("testando mais uma vez");

			assertEquals(true, this.perguntaDao.merge(perguntaFechada));

			PerguntaFechada retrieved = (PerguntaFechada) this.perguntaDao
					.find(perguntaFechada);

			assertEquals(grupo, retrieved.getGrupo());
			assertEquals(perguntaFechada.getNome(), retrieved.getNome());
			assertEquals(2, retrieved.getOpcoes().size());
			assertEquals(true, this.perguntaDao.delete(perguntaFechada));
			assertEquals(0, this.perguntaDao.findAll().size());

			assertEquals(true, this.perguntaDao.deleteAll());
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
			List<PerguntaFechada> perguntaFechadas = PerguntaFechadaDAOTest
					.getPerguntas();

			assertEquals(true, this.perguntaDao.save(perguntaFechadas, true));
			try {
				ok = false;
				assertEquals(false,
						this.perguntaDao.save(perguntaFechadas, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(perguntaFechadas.size(), this.perguntaDao.findAll()
					.size());

			assertEquals(true, this.perguntaDao.merge(perguntaFechadas));
			assertEquals(perguntaFechadas.size(), this.perguntaDao.findAll()
					.size());

			assertEquals(true, this.perguntaDao.deleteAll());
			assertEquals(0, this.perguntaDao.findAll().size());

		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public void testAssignmentOpcao() {
		boolean ok = true;
		try {
			PerguntaFechada perguntaFechada = PerguntaFechadaDAOTest
					.getPerguntas().get(0);
			List<Opcao> opcoes = OpcaoDAOTest.getOpcoes();

			assertEquals(true, this.perguntaDao.save(perguntaFechada, true));
			assertEquals(
					true,
					this.perguntaDao.assignmentOpcao(perguntaFechada,
							opcoes.get(0)));
			assertEquals(opcoes.get(0), this.perguntaDao.find(perguntaFechada)
					.getOpcoes().iterator().next());
			assertEquals(
					true,
					this.perguntaDao.assignmentOpcao(perguntaFechada,
							opcoes.get(1)));
			assertEquals(2, this.perguntaDao.find(perguntaFechada).getOpcoes()
					.size());
			assertEquals(true, this.perguntaDao.assignmentAllOpcao(
					perguntaFechada, opcoes));
			Collection<Opcao> tes = this.perguntaDao.find(perguntaFechada)
					.getOpcoes();
			assertEquals(opcoes.size(), tes.size());
			assertEquals(true, this.perguntaDao.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public void testAssigmentAllOpcoes() {
		boolean ok = true;
		try {
			PerguntaFechada perguntaFechada = PerguntaFechadaDAOTest
					.getPerguntas().get(0);
			List<Opcao> opcoes = OpcaoDAOTest.getOpcoes();

			assertEquals(true, this.perguntaDao.save(perguntaFechada, true));
			assertEquals(
					true,
					this.perguntaDao.assignmentOpcao(perguntaFechada,
							opcoes.get(0)));
			assertEquals(1, this.perguntaDao.find(perguntaFechada).getOpcoes()
					.size());

			assertEquals(true, this.perguntaDao.removeOpcao(perguntaFechada,
					opcoes.get(0)));
			assertEquals(0, this.perguntaDao.find(perguntaFechada).getOpcoes()
					.size());

			assertEquals(true, this.perguntaDao.assignmentAllOpcao(
					perguntaFechada, opcoes));
			assertEquals(opcoes.size(), this.perguntaDao.find(perguntaFechada)
					.getOpcoes().size());

			assertEquals(true,
					this.perguntaDao.removeAllOpcao(perguntaFechada, opcoes));
			assertEquals(0, this.perguntaDao.find(perguntaFechada).getOpcoes()
					.size());

			assertEquals(true, this.perguntaDao.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<PerguntaFechada> getPerguntas() {
		List<Grupo> grupos = GrupoDAOTest.getGrupos();
		List<Opcao> opcoes = OpcaoDAOTest.getOpcoes();

		List<PerguntaFechada> perguntaFechadas = new ArrayList<PerguntaFechada>();
		PerguntaFechada p = new PerguntaFechada(1, grupos.get(0),
				"PERGUNTA DE TESTE 1", '1');
		p.getOpcoes().addAll(opcoes);
		perguntaFechadas.add(p);

		p = new PerguntaFechada(2, grupos.get(2), "PERGUNTA 0001", '1');
		p.getOpcoes().addAll(opcoes);
		perguntaFechadas.add(p);

		p = new PerguntaFechada(3, grupos.get(2), "PERGUNTA DE NADA", '1');
		p.getOpcoes().addAll(opcoes);
		perguntaFechadas.add(p);

		p = new PerguntaFechada(4, grupos.get(1), "PERGUNTA JA TERMINADA", '1');
		p.getOpcoes().addAll(opcoes);
		perguntaFechadas.add(p);

		return perguntaFechadas;
	}

}
