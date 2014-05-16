package br.gov.pe.saudecaruaru.inspetordigital.model.test;

import net.sf.oval.Validator;
import br.gov.pe.saudecaruaru.inspetordigital.model.Proprietario;
import android.test.AndroidTestCase;

public class ProprietarioTest extends AndroidTestCase{

	private Proprietario proprietario;
	
	public void testValidation(){
		this.proprietario=new Proprietario(null,null,null);
		Class<?> prop=this.proprietario.getClass();
		Validator validator=new Validator();
		
		try{
			
			//cpf
			assertEquals(0,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("cpf"), "08769213496").size());
			assertEquals(1,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("cpf"), "0876921349").size());
			assertEquals(1,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("cpf"), "08769213fgg").size());
			assertEquals(1,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("cpf"), "087692134996").size());
			assertEquals(1,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("cpf"), null).size());
			
			//nome
			assertEquals(0,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("nome"), "rewqrqwr").size());
			assertEquals(1,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("nome"), null).size());
			
			//situacao
			assertEquals(0,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("nome"), 'S').size());
			assertEquals(1,validator.validateFieldValue(this.proprietario,prop.getDeclaredField("nome"), ' ').size());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
