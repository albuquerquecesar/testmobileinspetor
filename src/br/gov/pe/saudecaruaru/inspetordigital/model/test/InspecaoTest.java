package br.gov.pe.saudecaruaru.inspetordigital.model.test;

import java.util.Date;

import net.sf.oval.Validator;
import br.gov.pe.saudecaruaru.inspetordigital.model.Estabelecimento;
import br.gov.pe.saudecaruaru.inspetordigital.model.Formulario;
import br.gov.pe.saudecaruaru.inspetordigital.model.Inspecao;
import br.gov.pe.saudecaruaru.inspetordigital.model.Proprietario;
import android.test.AndroidTestCase;

public class InspecaoTest extends AndroidTestCase{
	
	private Inspecao inspecao;

	public void testValidation(){
	this.inspecao=new Inspecao("");
	Class<?> ins=this.inspecao.getClass();
	Validator validator=new Validator();
	
	try{
		
		//formulario
		assertEquals(0,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("formulario"),new Formulario(3L) ).size());
		assertEquals(1,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("formulario"), null).size());
		
		//estabelecimento
		assertEquals(0,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("estabelecimento"),new Estabelecimento() ).size());
		assertEquals(1,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("estabelecimento"), null).size());
		
		//inicio
		assertEquals(0,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("inicio"),new Date()).size());
		assertEquals(1,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("inicio"), null).size());
		
		//data
		assertEquals(0,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("data"),new Date()).size());
		assertEquals(1,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("data"), null).size());
		
		//motivo
		assertEquals(0,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("motivo"),'1').size());
		assertEquals(1,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("motivo"), ' ').size());
		
		//situacao
		assertEquals(0,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("situacao"),'1').size());
		assertEquals(1,validator.validateFieldValue(this.inspecao,ins.getDeclaredField("situacao"), ' ').size());
		
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
}
