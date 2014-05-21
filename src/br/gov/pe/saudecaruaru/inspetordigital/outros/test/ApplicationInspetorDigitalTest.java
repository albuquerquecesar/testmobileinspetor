package br.gov.pe.saudecaruaru.inspetordigital.outros.test;

import br.gov.pe.saudecaruaru.inspetordigital.model.Usuario;
import br.gov.pe.saudecaruaru.inspetordigital.tools.ApplicationInspetorDigital;

public class ApplicationInspetorDigitalTest extends ApplicationInspetorDigital{

	public static void setConnectedUser(Usuario usuario){
		ApplicationInspetorDigital.usuarioConnected=usuario;
	}
}
