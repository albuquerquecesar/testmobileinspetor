package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.gov.pe.saudecaruaru.inspetordigital.dao.GrupoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.InspecaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.OpcaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.PerguntaFechadaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ResponsavelDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.RespostaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.RespostaUnicaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Inspecao;
import br.gov.pe.saudecaruaru.inspetordigital.model.Opcao;
import br.gov.pe.saudecaruaru.inspetordigital.model.Pergunta;
import br.gov.pe.saudecaruaru.inspetordigital.model.PerguntaFechada;
import br.gov.pe.saudecaruaru.inspetordigital.model.Resposta;
import br.gov.pe.saudecaruaru.inspetordigital.model.RespostaUnica;
import android.test.AndroidTestCase;

public class RespostaUnicaDAOTest extends AndroidTestCase {

	private PerguntaFechadaDAO perguntaFechadaDAO;
	private RespostaUnicaDAO respostaUnicaDAO;
	private InspecaoDAOTest inspecaoDAOTest;
	private InspecaoDAO inspecaoDAO;
	private RespostaDAO respostaDAO;
	private GrupoDAO grupoDAO;
	private OpcaoDAO opcaoDAO;

	
	public RespostaUnicaDAOTest() {
		super();


		this.perguntaFechadaDAO = PerguntaFechadaDAO.getInstance();
		this.grupoDAO = GrupoDAO.getInstance();
		this.inspecaoDAO = InspecaoDAO.getInstance();
		this.inspecaoDAOTest = new InspecaoDAOTest();
		this.respostaDAO = RespostaDAO.getInstance();
		this.respostaUnicaDAO = RespostaUnicaDAO.getInstance();
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

		this.inspecaoDAOTest.setUp();
		this.grupoDAO.merge(GrupoDAOTest.getGrupos());
		this.perguntaFechadaDAO.merge(PerguntaFechadaDAOTest.getPerguntas());
		this.inspecaoDAO.merge(InspecaoDAOTest.getInspecoes());
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
		this.perguntaFechadaDAO.deleteAll();
		this.grupoDAO.deleteAll();
		this.inspecaoDAO.deleteAll();
		this.inspecaoDAOTest.tearDown();
		this.respostaUnicaDAO.deleteAll();
		this.opcaoDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			RespostaUnica respostaUnica = RespostaUnicaDAOTest
					.getRespostasUnicas().get(0);

			assertEquals(true, this.respostaUnicaDAO.save(respostaUnica, true));
			// deve lançar uma exceção
			try {
				ok = false;
				assertEquals(false,
						this.respostaUnicaDAO.save(respostaUnica, true));
			} catch (Exception ex) {
				ok = true;
			} finally {
				assertTrue(ok);
			}
			ok = true;
			assertEquals(respostaUnica,
					this.respostaUnicaDAO.find(respostaUnica));
			assertEquals(true, this.respostaUnicaDAO.merge(respostaUnica));
			assertEquals(1, this.respostaUnicaDAO.findAll().size());

			respostaUnica.setOpcao(OpcaoDAOTest.getOpcoes().get(1));

			assertEquals(true, this.respostaUnicaDAO.update(respostaUnica));

			RespostaUnica retrieved = this.respostaUnicaDAO.find(respostaUnica);

			assertEquals(respostaUnica.getOpcao(), retrieved.getOpcao());
			assertEquals(true, this.respostaUnicaDAO.delete(respostaUnica));
			assertEquals(0, this.respostaUnicaDAO.findAll().size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public void testSaveByInpecao() {
		boolean ok = true;
		try {

			List<RespostaUnica> list = getRespostasUnicas();
			Inspecao inspecao = list.get(0).getInspecao();
			Set<Inspecao> inspecoes = new HashSet<Inspecao>();
			assertEquals(true, this.respostaDAO.merge(inspecao, list, false));
			List<Resposta> tmp = this.respostaDAO.findAll();
			assertEquals(list.size(), tmp.size());
			for (Resposta respostaUnica : tmp) {
				inspecoes.add(respostaUnica.getInspecao());
			}

			assertEquals(1, inspecoes.size());
		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<RespostaUnica> getRespostasUnicas() {

		List<Inspecao> inspecoes = InspecaoDAOTest.getInspecoes();
		List<PerguntaFechada> perguntaFechadas = PerguntaFechadaDAOTest
				.getPerguntas();
		List<RespostaUnica> respostasUnicas = new ArrayList<RespostaUnica>();
		List<Opcao> opcoes = OpcaoDAOTest.getOpcoes();

		respostasUnicas.add(new RespostaUnica(perguntaFechadas.get(0),
				inspecoes.get(0), opcoes.get(0)));
		respostasUnicas.add(new RespostaUnica(perguntaFechadas.get(1),
				inspecoes.get(0), opcoes.get(0)));
		respostasUnicas.add(new RespostaUnica(perguntaFechadas.get(2),
				inspecoes.get(0), opcoes.get(0)));
		respostasUnicas.add(new RespostaUnica(perguntaFechadas.get(3),
				inspecoes.get(0), opcoes.get(0)));

		return respostasUnicas;
	}
}
