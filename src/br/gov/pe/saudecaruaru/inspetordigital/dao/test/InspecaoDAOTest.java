package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.EstabelecimentoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.FormularioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.InspecaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.OrgaoReguladorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ServidorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estabelecimento;
import br.gov.pe.saudecaruaru.inspetordigital.model.Formulario;
import br.gov.pe.saudecaruaru.inspetordigital.model.Inspecao;
import br.gov.pe.saudecaruaru.inspetordigital.model.Servidor;
import android.test.AndroidTestCase;

public class InspecaoDAOTest extends AndroidTestCase {

	private InspecaoDAO inspecaoDAO;
	private EstabelecimentoDAOTest estabelecimentoDAOTest;
	private EstabelecimentoDAO estabelecimentoDAO;
	private FormularioDAO formularioDAO;
	private ServidorDAO servidorDAO;
	private OrgaoReguladorDAO orgaoReguladorDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.estabelecimentoDAOTest = new EstabelecimentoDAOTest();
		this.formularioDAO = FormularioDAO.getInstance();
		this.estabelecimentoDAO = EstabelecimentoDAO.getInstance();
		this.inspecaoDAO = InspecaoDAO.getInstance();
		this.servidorDAO = ServidorDAO.getInstance();
		this.orgaoReguladorDAO = OrgaoReguladorDAO.getInstance();

		this.estabelecimentoDAOTest.setUp();
		this.formularioDAO.merge(FormularioDAOTest.getformularios());
		this.estabelecimentoDAO.merge(EstabelecimentoDAOTest
				.getEstabelecimentos());
		this.orgaoReguladorDAO.merge(OrgaoReguladorDAOTest
				.getOrgaoReguladores());
		this.servidorDAO.merge(ServidorDAOTest.getServidores());
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
		this.estabelecimentoDAO.deleteAll();
		this.inspecaoDAO.deleteAll();
		this.servidorDAO.deleteAll();
		this.orgaoReguladorDAO.deleteAll();
		this.estabelecimentoDAOTest.tearDown();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Inspecao inspecao = InspecaoDAOTest.getInspecoes().get(0);
			inspecao.getFiscais().clear();

			Servidor serivor1 = ServidorDAOTest.getServidores().get(0);
			Servidor serivor2 = ServidorDAOTest.getServidores().get(1);

			inspecao.getFiscais().add(serivor1);

			assertEquals(true, this.inspecaoDAO.save(inspecao, true));
			// deve lançar ma exceção
			try {
				ok = false;
				assertEquals(false, this.inspecaoDAO.save(inspecao, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok=true;
			Inspecao tmp = this.inspecaoDAO.find(inspecao);
			assertEquals(inspecao, tmp);
			assertEquals(inspecao.getFiscais().size(), tmp.getFiscais().size());

			assertEquals(1, this.inspecaoDAO.findAll().size());
			inspecao.setObservacao("teste");
			inspecao.getFiscais().add(serivor2);
			assertEquals(true, this.inspecaoDAO.update(inspecao));

			tmp = this.inspecaoDAO.find(inspecao);
			assertEquals(inspecao.getObservacao(), tmp.getObservacao());
			assertEquals(2, tmp.getFiscais().size());

			// Verifica a mudança de formulario e estabelecimento
			inspecao.setFormulario(FormularioDAOTest.getformularios().get(2));
			inspecao.setEstabelecimento(EstabelecimentoDAOTest
					.getEstabelecimentos().get(2));

			assertEquals(true, this.inspecaoDAO.merge(inspecao));
			Inspecao retrieved = this.inspecaoDAO.find(inspecao);

			assertEquals(inspecao.getFormulario(), retrieved.getFormulario());
			assertEquals(inspecao.getEstabelecimento(),
					retrieved.getEstabelecimento());
			assertEquals(1, this.inspecaoDAO.findAll().size());
			assertEquals(true, this.inspecaoDAO.delete(inspecao));
			assertEquals(0, this.inspecaoDAO.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public void testSaveWithEstabelecimento() {
		boolean ok = true;
		try {
			Inspecao inspecao = InspecaoDAOTest.getInspecoes().get(0);

			inspecao.getEstabelecimento().setCodigo("43898723");
			inspecao.setCodigo("ijfj834ioeqnfueq");
			assertEquals(true,
					this.inspecaoDAO.saveWithEstabelecimento(inspecao));
			assertEquals(inspecao, this.inspecaoDAO.find(inspecao));
			assertEquals(1, this.inspecaoDAO.findAll().size());
			inspecao.setObservacao("teste");
			assertEquals(true, this.inspecaoDAO.update(inspecao));
			assertEquals(inspecao.getObservacao(),
					this.inspecaoDAO.find(inspecao).getObservacao());

			// Verifica a mudança de formulario e estabelecimento
			inspecao.setFormulario(FormularioDAOTest.getformularios().get(2));
			inspecao.setEstabelecimento(EstabelecimentoDAOTest
					.getEstabelecimentos().get(2));

			assertEquals(true, this.inspecaoDAO.merge(inspecao));
			Inspecao retrieved = this.inspecaoDAO.find(inspecao);

			assertEquals(inspecao.getFormulario(), retrieved.getFormulario());
			assertEquals(inspecao.getEstabelecimento(),
					retrieved.getEstabelecimento());
			assertEquals(1, this.inspecaoDAO.findAll().size());
			assertEquals(true, this.inspecaoDAO.delete(inspecao));
			assertEquals(0, this.inspecaoDAO.findAll().size());
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
			List<Inspecao> inspecoes = InspecaoDAOTest.getInspecoes();

			assertEquals(true, this.inspecaoDAO.save(inspecoes, true));
			// deve lançar ma exceção
			try {
				ok = false;
				assertEquals(false, this.inspecaoDAO.save(inspecoes, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok=true;
			assertEquals(inspecoes.size(), this.inspecaoDAO.findAll().size());
			assertEquals(true, this.inspecaoDAO.merge(inspecoes));
			assertEquals(inspecoes.size(), this.inspecaoDAO.findAll().size());
			assertEquals(true, this.inspecaoDAO.delete(inspecoes.get(0)));
			assertEquals(inspecoes.size() - 1, this.inspecaoDAO.findAll()
					.size());
			assertEquals(true, this.inspecaoDAO.deleteAll());
			assertEquals(0, this.inspecaoDAO.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}

	}

	public void testAssignmentAllFiscais() {
		boolean ok = true;
		try {
			List<Servidor> servidores = ServidorDAOTest.getServidores();
			Inspecao inspecao = InspecaoDAOTest.getInspecoes().get(0);

			assertEquals(true, this.inspecaoDAO.save(inspecao, true));
			assertEquals(true,
					this.inspecaoDAO.assignmentAllFiscais(inspecao, servidores));
			assertEquals(servidores.size(), this.inspecaoDAO.find(inspecao)
					.getFiscais().size());
			assertEquals(true, this.inspecaoDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public void testFindAllNotFechada() {

		boolean ok = true;
		try {
			List<Inspecao> list = InspecaoDAOTest.getInspecoes();
			boolean flag = false;
			for (Inspecao inspecao : list) {
				if (flag) {
					inspecao.setSituacao(Inspecao.SITUACAO_ABERTA);
					flag = false;
				} else {
					inspecao.setSituacao(Inspecao.SITUACAO_EM_ANDAMENTO);
					flag = true;
				}
			}
			// todas as inspeções salvas não estão fechadas
			assertEquals(true, this.inspecaoDAO.save(list, true));
			assertEquals(list.size(), this.inspecaoDAO.findAllNotEncerrada()
					.size());

			flag = true;
			int notFechada = 0;
			for (Inspecao inspecao : list) {
				if (flag) {
					inspecao.setSituacao(Inspecao.SITUACAO_FECHADA);
					flag = false;
				} else {
					inspecao.setSituacao(Inspecao.SITUACAO_EM_ANDAMENTO);
					flag = true;
					notFechada++;
				}
			}
			// algumas inspeções atualizadas estão fechadas outras não
			assertEquals(true, this.inspecaoDAO.update(list));
			assertEquals(notFechada, this.inspecaoDAO.findAllNotEncerrada()
					.size());

			for (Inspecao inspecao : list) {
				inspecao.setSituacao(Inspecao.SITUACAO_FECHADA);
			}
			// todas as inspeções atualizadas estão fechadas
			assertEquals(true, this.inspecaoDAO.update(list));
			assertEquals(0, this.inspecaoDAO.findAllNotEncerrada().size());

			assertEquals(true, this.inspecaoDAO.deleteAll());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<Inspecao> getInspecoes() {
		List<Formulario> formularios = FormularioDAOTest.getformularios();
		List<Estabelecimento> estabelecimentos = EstabelecimentoDAOTest
				.getEstabelecimentos();
		List<Inspecao> inspecoes = new ArrayList<Inspecao>();

		inspecoes.add(new Inspecao("w94298484893", formularios.get(0),
				estabelecimentos.get(0), new Date(), new Date(), '2', '1'));
		inspecoes.add(new Inspecao("w9420858434", formularios.get(1),
				estabelecimentos.get(1), new Date(), new Date(), '1', '1'));
		inspecoes.add(new Inspecao("w85774374831", formularios.get(2),
				estabelecimentos.get(2), new Date(), new Date(), '2', '1'));
		inspecoes.add(new Inspecao("w98598543551", formularios.get(3),
				estabelecimentos.get(3), new Date(), new Date(), '3', '1'));

		return inspecoes;

	}
}
