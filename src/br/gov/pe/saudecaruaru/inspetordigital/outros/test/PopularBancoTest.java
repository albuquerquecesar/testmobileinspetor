package br.gov.pe.saudecaruaru.inspetordigital.outros.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.FormularioPerguntaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.FormularioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.GrupoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaJuridicaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.OpcaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.OrgaoReguladorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.PerguntaFechadaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ServidorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;
import br.gov.pe.saudecaruaru.inspetordigital.model.Cidade;
import br.gov.pe.saudecaruaru.inspetordigital.model.Divisao;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estado;
import br.gov.pe.saudecaruaru.inspetordigital.model.Formulario;
import br.gov.pe.saudecaruaru.inspetordigital.model.FormularioPergunta;
import br.gov.pe.saudecaruaru.inspetordigital.model.Grupo;
import br.gov.pe.saudecaruaru.inspetordigital.model.Natureza;
import br.gov.pe.saudecaruaru.inspetordigital.model.NaturezaJuridica;
import br.gov.pe.saudecaruaru.inspetordigital.model.OrgaoRegulador;
import br.gov.pe.saudecaruaru.inspetordigital.model.Pergunta;
import br.gov.pe.saudecaruaru.inspetordigital.model.PerguntaFechada;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.BairroWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.CidadeWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.DivisaoWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.EstadoWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.FormularioPerguntaWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.FormularioWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.GrupoWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.NaturezaJuridicaWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.NaturezaWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.OpcaoWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.OrgaoReguladorWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.PerguntaWebService;
import br.gov.pe.saudecaruaru.inspetordigital.webservices.ServidorWebService;
import android.test.AndroidTestCase;

public class PopularBancoTest extends AndroidTestCase {

	private DivisaoDAO divisaoDAO;
	private NaturezaDAO naturezaDAO;
	private NaturezaJuridicaDAO naturezaJuridicaDAO;
	private EstadoDAO estadoDAO;
	private CidadeDAO cidadeDAO;
	private BairroDAO bairroDAO;
	private OrgaoReguladorDAO orgaoReguladorDAO;
	private FormularioDAO formularioDAO;
	private GrupoDAO grupoDAO;
	private OpcaoDAO opcaoDAO;
	private FormularioPerguntaDAO formularioPerguntaDAO;
	private PerguntaFechadaDAO perguntaFechadaDAO;
	private ServidorDAO servidorDAO;

	private DivisaoWebService divisaoWebService;
	private NaturezaWebService naturezaWebService;
	private NaturezaJuridicaWebService naturezaJuridicaWebService;
	private EstadoWebService estadoWebService;
	private CidadeWebService cidadeWebService;
	private BairroWebService bairroWebService;
	private OrgaoReguladorWebService orgaoReguladorWebService;
	private FormularioWebService formularioWebService;
	private OpcaoWebService opcaoWebService;
	private GrupoWebService grupoWebService;
	private FormularioPerguntaWebService formularioPerguntaWebService;
	private PerguntaWebService perguntaWebService;
	private ServidorWebService servidorWebService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();

		this.divisaoDAO = DivisaoDAO.getInstance();
		this.naturezaDAO = NaturezaDAO.getInstance();
		this.naturezaJuridicaDAO = NaturezaJuridicaDAO.getInstance();
		this.estadoDAO = EstadoDAO.getInstance();
		this.cidadeDAO = CidadeDAO.getInstance();
		this.bairroDAO = BairroDAO.getInstance();
		this.orgaoReguladorDAO = OrgaoReguladorDAO.getInstance();
		this.formularioDAO = FormularioDAO.getInstance();
		this.opcaoDAO = OpcaoDAO.getInstance();
		this.grupoDAO = GrupoDAO.getInstance();
		this.formularioPerguntaDAO = FormularioPerguntaDAO.getInstance();
		this.perguntaFechadaDAO = PerguntaFechadaDAO.getInstance();
		this.servidorDAO = ServidorDAO.getInstance();

		this.divisaoWebService = new DivisaoWebService();
		this.naturezaWebService = new NaturezaWebService();
		this.naturezaJuridicaWebService = new NaturezaJuridicaWebService();
		this.estadoWebService = new EstadoWebService();
		this.cidadeWebService = new CidadeWebService();
		this.bairroWebService = new BairroWebService();
		this.formularioWebService = new FormularioWebService();
		this.orgaoReguladorWebService = new OrgaoReguladorWebService();
		this.grupoWebService = new GrupoWebService();
		this.opcaoWebService = new OpcaoWebService();
		this.formularioPerguntaWebService = new FormularioPerguntaWebService();
		this.perguntaWebService = new PerguntaWebService();
		this.servidorWebService = new ServidorWebService();
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

	public void testStart() {
		boolean ok = true;
		try {
			List<Divisao> divisoes = this.divisaoWebService.getAll(0, 0);
			assertEquals(false, divisoes.isEmpty());
			assertEquals(true, this.divisaoDAO.merge(divisoes));

			List<Natureza> naturezas = this.naturezaWebService.getAll(0, 0);
			assertEquals(false, naturezas.isEmpty());
			assertEquals(true, this.naturezaDAO.merge(naturezas));

			List<NaturezaJuridica> naturezasJuridicas = this.naturezaJuridicaWebService
					.getAll(0, 0);
			assertEquals(false, naturezasJuridicas.isEmpty());
			assertEquals(true,
					this.naturezaJuridicaDAO.merge(naturezasJuridicas));

			List<Estado> estados = this.estadoWebService.getAll(0, 0);
			assertEquals(false, estados.isEmpty());
			assertEquals(true, this.estadoDAO.merge(estados));

			List<Cidade> cidades = this.cidadeWebService.getAll(100, 0);
			assertEquals(false, cidades.isEmpty());
			assertEquals(true, this.cidadeDAO.merge(cidades));

			List<Bairro> bairros = this.bairroWebService.getAll(100, 0);
			assertEquals(false, bairros.isEmpty());
			assertEquals(true, this.bairroDAO.merge(bairros));

			List<OrgaoRegulador> orgaos = this.orgaoReguladorWebService.getAll(
					0, 0);
			assertEquals(false, orgaos.isEmpty());
			assertEquals(true, this.orgaoReguladorDAO.merge(orgaos));

			List<Formulario> formularios = this.formularioWebService.getAll(0,
					0);
			assertEquals(false, formularios.isEmpty());
			assertEquals(true, this.formularioDAO.merge(formularios));

			// List<Opcao> opcoes=this.opcaoWebService.getAll(0, 0);
			// assertEquals(false, opcoes.isEmpty());
			// assertEquals(true, this.opcaoDAO.merge(opcoes));

			List<Grupo> grupos = this.grupoWebService.getAll(0, 0);
			assertEquals(false, grupos.isEmpty());
			assertEquals(true, this.grupoDAO.merge(grupos));

			List<Pergunta> ptmp = this.perguntaWebService.getAll(0, 0);
			List<PerguntaFechada> perguntas = new ArrayList<PerguntaFechada>();
			for (Pergunta pergunta : ptmp) {
				perguntas.add((PerguntaFechada) pergunta);
			}
			assertEquals(false, perguntas.isEmpty());
			assertEquals(true, this.perguntaFechadaDAO.merge(perguntas));

			// for (Pergunta pergunta : perguntasFechadas) {
			// assertEquals(true, actual)
			// }
			List<FormularioPergunta> formularioPerguntas = this.formularioPerguntaWebService
					.getAll(0, 0);
			assertEquals(false, formularioPerguntas.isEmpty());
			assertEquals(true,
					this.formularioPerguntaDAO.merge(formularioPerguntas));

			// List<Servidor> servidores=this.servidorWebService.getAll(0, 0);
			// assertEquals(false, servidores.isEmpty());
			// assertEquals(true, this.servidorDAO.merge(servidores));

		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}
}
