package br.gov.pe.saudecaruaru.inspetordigital.model.test;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import br.gov.pe.saudecaruaru.inspetordigital.model.Divisao;
import br.gov.pe.saudecaruaru.inspetordigital.model.Endereco;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estabelecimento;
import br.gov.pe.saudecaruaru.inspetordigital.model.Natureza;
import br.gov.pe.saudecaruaru.inspetordigital.model.NaturezaJuridica;
import br.gov.pe.saudecaruaru.inspetordigital.model.Responsavel;
import android.test.AndroidTestCase;

public class EstabelecimentoTest extends AndroidTestCase {

	private Estabelecimento estabelecimento;

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

	public void testValidation() {
		try {
			Validator validator = new Validator();
			
			this.estabelecimento = new Estabelecimento("1");
			Class<?> esta = this.estabelecimento.getClass();

			//cpfCnpj
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("cpfCnpj"), "08769213496").size());
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("cpfCnpj"), "08769213496345").size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("cpfCnpj"), "0876921349634").size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("cpfCnpj"), "087692ioriiiii").size());
			
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("cpfCnpj"), "0876921349").size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("cpfCnpj"), "087692134963455").size());
			
			//razaoSocial
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("razaoSocial"), "nome da empresa").size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("razaoSocial"), "").size());
			
			//natureza
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("natureza"), new Natureza("", new Divisao((short)1))).size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("natureza"), null).size());
			
			//naturezaJuridica
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("naturezaJuridica"), new NaturezaJuridica((short) 1)).size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("naturezaJuridica"), null).size());
			
			//responsável
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("responsavel"), new Responsavel(null, null)).size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("responsavel"), null).size());
			
			//Endereco
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("endereco"), new Endereco(0, null, null, null, null, null, null)).size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("endereco"), null).size());
			
			//situacao
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("situacao"), 'S').size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("situacao"), ' ').size());
			
			//telefone
			assertEquals(0,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("telefone"),  "234341").size());
			assertEquals(1,validator.validateFieldValue(estabelecimento,esta.getDeclaredField("telefone"), null).size());
			

			List<ConstraintViolation> list = validator
					.validate(estabelecimento);

			for (ConstraintViolation constraintViolation : list) {
				constraintViolation.getContext();
				System.out.println(constraintViolation.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
