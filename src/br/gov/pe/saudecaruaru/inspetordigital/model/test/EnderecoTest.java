package br.gov.pe.saudecaruaru.inspetordigital.model.test;

import net.sf.oval.Validator;
import br.gov.pe.saudecaruaru.inspetordigital.model.Bairro;
import br.gov.pe.saudecaruaru.inspetordigital.model.Endereco;
import br.gov.pe.saudecaruaru.inspetordigital.model.Responsavel;
import android.test.AndroidTestCase;

public class EnderecoTest extends AndroidTestCase{

	private Endereco endereco;

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
		super.tearDown();
	}
	
	public void testValidation(){
		this.endereco=new Endereco(0, null, null, null, null, null, null);
		Class<?> ender=this.endereco.getClass();
		Validator validator=new Validator();
		try{
			
			//logradouro
			assertEquals(0,validator.validateFieldValue(this.endereco,ender.getDeclaredField("logradouro"), "r4rr1").size());
			assertEquals(1,validator.validateFieldValue(this.endereco,ender.getDeclaredField("logradouro"), null).size());
			
			//cep
			assertEquals(0,validator.validateFieldValue(this.endereco,ender.getDeclaredField("cep"), "55380000").size());
			assertEquals(1,validator.validateFieldValue(this.endereco,ender.getDeclaredField("cep"), null).size());
			assertEquals(1,validator.validateFieldValue(this.endereco,ender.getDeclaredField("cep"),"5538000").size());
			assertEquals(1,validator.validateFieldValue(this.endereco,ender.getDeclaredField("cep"), "553800000").size());
			
			//bairro
			assertEquals(0,validator.validateFieldValue(this.endereco,ender.getDeclaredField("bairro"), new Bairro(null)).size());
			assertEquals(1,validator.validateFieldValue(this.endereco,ender.getDeclaredField("bairro"), null).size());
			
			//cidade
			assertEquals(0,validator.validateFieldValue(this.endereco,ender.getDeclaredField("cidade"), "r4rr1").size());
			assertEquals(1,validator.validateFieldValue(this.endereco,ender.getDeclaredField("cidade"), null).size());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
