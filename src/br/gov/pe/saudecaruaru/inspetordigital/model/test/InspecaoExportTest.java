package br.gov.pe.saudecaruaru.inspetordigital.model.test;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.InspecaoDAO;
import br.gov.pe.saudecaruaru.inspetordigital.dao.RespostaDAO;
import br.gov.pe.saudecaruaru.inspetordigital.model.Inspecao;
import br.gov.pe.saudecaruaru.inspetordigital.model.InspecaoExport;
import br.gov.pe.saudecaruaru.inspetordigital.model.Resposta;
import br.gov.pe.saudecaruaru.inspetordigital.tools.DataSerializer;

import com.google.smsjson.Gson;
import com.google.smsjson.GsonBuilder;

import android.test.AndroidTestCase;

public class InspecaoExportTest extends AndroidTestCase{
	
	private InspecaoDAO inspecaoDAO;
	private RespostaDAO respostaDAO;
	
	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.inspecaoDAO=InspecaoDAO.getInstance();
		this.respostaDAO=RespostaDAO.getInstance();
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void testSerialization(){
		List<Inspecao> inspecoes=this.inspecaoDAO.findAll();

		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.registerTypeAdapter(Date.class, new DataSerializer())
				.setPrettyPrinting()
				.create();
		
		Inspecao inspecao=null;
				for (Inspecao i : inspecoes) {
					if (i.isFechada()){

						
						Collection<Resposta> respostas=this.respostaDAO.findAllByInspecao(i);
						
						System.out.println(gson.toJson(new InspecaoExport(i, respostas)));
					}
				}
		
	}

}
