package br.gov.pe.saudecaruaru.inspetordigital.dao.test;

import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;
import br.gov.pe.saudecaruaru.inspetordigital.dao.BairroDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.CidadeDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.DivisaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstabelecimentoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.EstadoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.NaturezaJuridicaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.OrgaoReguladorDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ProprietarioDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.ResponsavelDAO;
import br.gov.pe.saudecaruaru.inspetordigital.mock.BairroMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.CidadeMock;
import br.gov.pe.saudecaruaru.inspetordigital.mock.EstadoMock;
import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;
import br.gov.pe.saudecaruaru.inspetordigital.model.Cidade;
import br.gov.pe.saudecaruaru.inspetordigital.model.Endereco;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estabelecimento;
import br.gov.pe.saudecaruaru.inspetordigital.model.Natureza;
import br.gov.pe.saudecaruaru.inspetordigital.model.NaturezaJuridica;
import br.gov.pe.saudecaruaru.inspetordigital.model.Proprietario;
import br.gov.pe.saudecaruaru.inspetordigital.model.Responsavel;

public class EstabelecimentoDAOTest extends AndroidTestCase {

	private EstadoDAO estadoDAO = EstadoDAO.getInstance();
	private CidadeDAO cidadeDAO = CidadeDAO.getInstance();
	private BairroDAO bairroDAO = BairroDAO.getInstance();
	private OrgaoReguladorDAO orgaoReguladorDAO = OrgaoReguladorDAO
			.getInstance();
	private ResponsavelDAO responsavelDAO = ResponsavelDAO.getInstance();
	private ProprietarioDAO proprietarioDAO = ProprietarioDAO.getInstance();
	private EstabelecimentoDAO estabelecimentoDAO = EstabelecimentoDAO
			.getInstance();
	private DivisaoDAO divisaoDAO = DivisaoDAO.getInstance();
	private NaturezaDAO naturezaDAO = NaturezaDAO.getInstance();
	private NaturezaJuridicaDAO naturezaJuridicaDAO = NaturezaJuridicaDAO
			.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.bairroDAO.deleteAll();
		this.cidadeDAO.deleteAll();
		this.estadoDAO.deleteAll();
		this.orgaoReguladorDAO.deleteAll();
		this.proprietarioDAO.deleteAll();
		this.responsavelDAO.deleteAll();
		this.estabelecimentoDAO.deleteAll();
		this.naturezaDAO.deleteAll();
		this.divisaoDAO.deleteAll();
		this.naturezaJuridicaDAO.deleteAll();

		this.divisaoDAO.save(DivisaoDAOTest.getDivisoes(), true);
		this.naturezaDAO.save(NaturezaDAOTest.getnaturezas(), true);
		this.naturezaJuridicaDAO.save(
				NaturezaJuridicaDAOTest.getNaturezaJuridicas(), true);
		this.estadoDAO.save(EstadoMock.getModelos(), true);
		this.bairroDAO.save(BairroMock.getModelos(), true);
		this.cidadeDAO.save(CidadeMock.getModelos(), true);
		this.orgaoReguladorDAO.save(
				OrgaoReguladorDAOTest.getOrgaoReguladores(), true);
		this.proprietarioDAO.save(ProprietarioDAOTest.getProprietarios(), true);
		this.responsavelDAO.save(ResponsavelDAOTest.getResponsaveis(), true);
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
		this.bairroDAO.deleteAll();
		this.cidadeDAO.deleteAll();
		this.estadoDAO.deleteAll();
		this.orgaoReguladorDAO.deleteAll();
		this.proprietarioDAO.deleteAll();
		this.responsavelDAO.deleteAll();
		this.naturezaDAO.deleteAll();
		this.divisaoDAO.deleteAll();
		this.naturezaJuridicaDAO.deleteAll();
		this.estabelecimentoDAO.deleteAll();
	}

	public void testCrud() {
		boolean ok = true;
		try {
			Estabelecimento estabelecimento = EstabelecimentoDAOTest
					.getEstabelecimentos().get(0);

			assertEquals(true,
					this.estabelecimentoDAO.save(estabelecimento, true));
			// assertEquals(false,
			// this.estabelecimentoDAO.save(estabelecimento));
			Estabelecimento tmp = this.estabelecimentoDAO.find(estabelecimento);
			assertEquals(estabelecimento, tmp);
			assertEquals(1, this.estabelecimentoDAO.findAll().size());
			// assertEquals(true,
			// this.estabelecimentoDAO.merge(estabelecimento));
			assertEquals(estabelecimento,
					this.estabelecimentoDAO.find(estabelecimento));
			assertEquals(1, this.estabelecimentoDAO.findAll().size());

			estabelecimento.setInscricaoEstadual("9999999");
			estabelecimento.getEndereco().setBairro(
					BairroMock.getModelos().get(2));
			estabelecimento.getEndereco().setCidade(
					CidadeMock.getModelos().get(2));
			estabelecimento.getEndereco().setComplemento(
					"testando o complemento");
			estabelecimento.setResponsavel(ResponsavelDAOTest.getResponsaveis()
					.get(3));
			estabelecimento.setProprietario(ProprietarioDAOTest
					.getProprietarios().get(3));
			estabelecimento.setNatureza(NaturezaDAOTest.getnaturezas().get(2));
			estabelecimento.setNaturezaJuridica(NaturezaJuridicaDAOTest
					.getNaturezaJuridicas().get(2));

			assertEquals(true, this.estabelecimentoDAO.merge(estabelecimento));

			Estabelecimento estabelecimentoRetrieved = this.estabelecimentoDAO
					.find(estabelecimento);
			assertNotNull(estabelecimentoRetrieved);

			assertEquals(estabelecimento.getInscricaoEstadual(),
					estabelecimentoRetrieved.getInscricaoEstadual());

			assertEquals(estabelecimento.getProprietario(),
					estabelecimentoRetrieved.getProprietario());
			assertEquals(estabelecimento.getResponsavel(),
					estabelecimentoRetrieved.getResponsavel());
			assertEquals(estabelecimento.getNatureza(),
					estabelecimentoRetrieved.getNatureza());
			assertEquals(estabelecimento.getNaturezaJuridica(),
					estabelecimentoRetrieved.getNaturezaJuridica());
			assertEquals(estabelecimento.getEndereco().getBairro(),
					estabelecimentoRetrieved.getEndereco().getBairro());
			assertEquals(estabelecimento.getEndereco().getCidade(),
					estabelecimentoRetrieved.getEndereco().getCidade());
			assertEquals(estabelecimento.getEndereco().getComplemento(),
					estabelecimentoRetrieved.getEndereco().getComplemento());

			// testa a remoção de proprietário
			estabelecimento.setProprietario(null);
			assertEquals(true, this.estabelecimentoDAO.update(estabelecimento));

			estabelecimentoRetrieved = this.estabelecimentoDAO
					.find(estabelecimento);
			assertEquals(estabelecimento.getProprietario(),
					estabelecimentoRetrieved.getProprietario());

			estabelecimento.setProprietario(ProprietarioDAOTest
					.getProprietarios().get(3));
			assertEquals(true, this.estabelecimentoDAO.update(estabelecimento));

			estabelecimentoRetrieved = this.estabelecimentoDAO
					.find(estabelecimento);
			assertEquals(estabelecimento.getProprietario(),
					estabelecimentoRetrieved.getProprietario());

			assertEquals(true, this.estabelecimentoDAO.delete(estabelecimento));
			assertEquals(0, this.estabelecimentoDAO.findAll().size());
			assertEquals(true, this.estabelecimentoDAO.deleteAll());

		} catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		} finally {
			assertTrue(ok);
		}
	}

	public static List<Estabelecimento> getEstabelecimentos() {

		List<Cidade> cidades = CidadeMock.getModelos();
		List<Bairro> bairros = BairroMock.getModelos();
		List<Responsavel> responsaveis = ResponsavelDAOTest.getResponsaveis();
		List<Proprietario> proprietarios = ProprietarioDAOTest
				.getProprietarios();
		List<Natureza> naturezas = NaturezaDAOTest.getnaturezas();
		List<NaturezaJuridica> naturezasJuridicas = NaturezaJuridicaDAOTest
				.getNaturezaJuridicas();

		List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

		estabelecimentos
				.add(new Estabelecimento("1", "022234424422",
						"america airlines", naturezas.get(0),
						naturezasJuridicas.get(0), responsaveis.get(0),
						proprietarios.get(0), new Endereco(1, "55938838",
								"rua da matriz", bairros.get(0),
								cidades.get(0), null, null), null, null));

		estabelecimentos.add(new Estabelecimento("2", "022235555",
				"laboratorio de protese", naturezas.get(3), naturezasJuridicas
						.get(3), responsaveis.get(3), proprietarios.get(3),
				new Endereco(2, "55938838", "rua da matriz", bairros.get(3),
						cidades.get(3), null, null), null, null));
		estabelecimentos
				.add(new Estabelecimento("3", "022234726653",
						"consultorio odontológico", naturezas.get(2),
						naturezasJuridicas.get(2), responsaveis.get(2),
						proprietarios.get(2), new Endereco(2, "55938838",
								"rua da matriz", bairros.get(2),
								cidades.get(2), null, null), null, null));
		estabelecimentos.add(new Estabelecimento("4", "02223498432",
				"joao capotaria", naturezas.get(1), naturezasJuridicas.get(1),
				responsaveis.get(1), proprietarios.get(1), new Endereco(4,
						"55938838", "rua da matriz", bairros.get(1), cidades
								.get(1), null, null), null, null));

		return estabelecimentos;
	}

}
