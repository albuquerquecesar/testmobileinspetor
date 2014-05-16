package br.gov.pe.saudecaruaru.inspetordigital.model.test;

import net.sf.oval.Validator;
import br.gov.pe.saudecaruaru.inspetordigital.model.Responsavel;
import android.test.AndroidTestCase;

public class ResponsavelTest extends AndroidTestCase {

	private Responsavel responsavel;
	
	public void testValidation(){
		this.responsavel=new Responsavel(null, null);
		Class<?> prop=this.responsavel.getClass();
		Validator validator=new Validator();
		
		try{
			
			//cpf
			assertEquals(0,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("cpf"), "08769213496").size());
			assertEquals(1,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("cpf"), "0876921349").size());
			assertEquals(1,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("cpf"), "08769214fr3s").size());
			assertEquals(1,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("cpf"), "087692134996").size());
			assertEquals(1,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("cpf"), null).size());
			
			//nome
			assertEquals(0,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("nome"), "rewqrqwr").size());
			assertEquals(1,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("nome"), null).size());
			
			//situacao
			assertEquals(0,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("nome"), 'S').size());
			assertEquals(1,validator.validateFieldValue(this.responsavel,prop.getDeclaredField("nome"), ' ').size());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
