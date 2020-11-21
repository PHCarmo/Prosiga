package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prossiga.model.domain.Turma;

public class GeradorTabelaTurma implements IGeradorJson {

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
				Turma t = (Turma) e;
				if(entidades.indexOf(e) == (entidades.size() -1)) {
					json += "["
							+"\""+ t.getId() + "\","
							+"\""+ t.getDescricao() + "\","
							+"\""+ t.getCurso().getDescricao() + "\""
							+ "]";
				}else {
					json += "["
							+"\""+ t.getId() + "\","
							+"\""+ t.getDescricao() + "\","
							+"\""+ t.getCurso().getDescricao() + "\""
							+ "],";
				}
			}
			
			json += "]}";
		}	
		return json;
	}

}
