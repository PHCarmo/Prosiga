package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;

public interface IGeradorJson {
	
	public String gerar(List<EntidadeDominio> entidades);

}
