package br.gov.pe.saudecaruaru.inspetordigital.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.gov.pe.saudecaruaru.inspetordigital.model.Comercio;
import br.gov.pe.saudecaruaru.inspetordigital.model.Evento;
import br.gov.pe.saudecaruaru.inspetordigital.model.Problema;
import br.gov.pe.saudecaruaru.inspetordigital.model.Servidor;
import br.gov.pe.saudecaruaru.inspetordigital.model.Situacao;
import br.gov.pe.saudecaruaru.inspetordigital.model.VisitaSanitaria;

public class VisitaSanitariaMock {

	public static List<VisitaSanitaria> getModelos() {
		List<VisitaSanitaria> visitas = new ArrayList<VisitaSanitaria>();
		List<Problema> problemas = ProblemaMock.getModelos();
		List<Comercio> comercios = ComercioMock.getModelos();
		List<Evento> eventos = EventoMock.getModelos();
		List<Servidor> fiscais = ServidorMock.getModelos();
		List<Situacao> situacoes=SituacaoMock.getModelos();
		
		visitas.add(new VisitaSanitaria("cnwqenoi", null, new Date(), fiscais
				.get(0), situacoes.get(0), problemas, comercios.get(0), eventos.get(0)));
		
		visitas.add(new VisitaSanitaria("cghbey546345i", null, new Date(),
				fiscais.get(1), situacoes.get(1), problemas, comercios.get(1), eventos
						.get(1)));
		
		visitas.add(new VisitaSanitaria("y45y54wytgsegesw", null, new Date(),
				fiscais.get(2), situacoes.get(2), problemas, comercios.get(2), eventos
						.get(2)));
		
		visitas.add(new VisitaSanitaria("bw45yh45wyh45gr", null, new Date(),
				fiscais.get(3), situacoes.get(3), problemas, comercios.get(3), eventos
						.get(3)));

		return visitas;
	}
}
