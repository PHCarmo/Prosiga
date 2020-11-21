package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;

public class GeradorTabelaCurso implements IGeradorJson {

	@Override
	public String gerar(List<EntidadeDominio> entidades) {
		
		String json = "";
		
		if(!(entidades.isEmpty())) {
			json = "{"
					+ "  \"draw\": 1,"
					+ "  \"recordsTotal\": "+ entidades.size() +","
					+ "  \"recordsFiltered\": "+ entidades.size() +","
					+ "  \"data\": [";
			
			for(EntidadeDominio e: entidades) {
				Curso c = (Curso) e;
				if(entidades.indexOf(e) == (entidades.size() -1)) {
					json += "["
							+"\""+ c.getId() + "\","
							+"\""+ c.getNome() + "\","
							+"\""+ c.getTurno() + "\","
							+"\""+ c.getDescricao() + "\""
							+ "]";
				}else {
					json += "["
							+"\""+ c.getId() + "\","
							+"\""+ c.getNome() + "\","
							+"\""+ c.getTurno() + "\","
							+"\""+ c.getDescricao() + "\""
							+ "],";
				}
			}
			
			json += "]}";
		}	
		return json;
	}

}
