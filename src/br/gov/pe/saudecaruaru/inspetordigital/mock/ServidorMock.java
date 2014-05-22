package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.dao.test.OrgaoReguladorDAOTest;
import br.gov.pe.saudecaruaru.inspetordigital.model.OrgaoRegulador;
import br.gov.pe.saudecaruaru.inspetordigital.model.Servidor;

public class ServidorMock {

	public static List<Servidor> getModelos() {
	
		List<OrgaoRegulador> orgoes = OrgaoReguladorDAOTest
				.getOrgaoReguladores();
		List<Servidor> servidores = new ArrayList<Servidor>();
	
		servidores.add(new Servidor("0348581239", "cesar henrique", "3243243",
				orgoes.get(0), "3434"));
		servidores.add(new Servidor("033490343", "pires junior", "34954",
				orgoes.get(1), "55242"));
		servidores.add(new Servidor("0348512239", "cesar henrique", "3243243"));
		servidores.add(new Servidor("0348534909", "cesar henrique", "3243243"));
	
		return servidores;
	}

}
