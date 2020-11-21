package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.Disciplina;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;

public class GeradorTabelaDisciplina implements IGeradorJson {

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
				Disciplina d = (Disciplina) e;
				if(entidades.indexOf(e) == (entidades.size() -1)) {
					json += "["
							+"\""+ d.getId() + "\","
							+"\""+ d.getCarga_horaria() + "\","
							+"\""+ d.getEmenta() + "\","
							+"\""+ d.getCurso().getNome() + "\","
							+"\""+ d.getProfessor().getNome() + "\""
							+ "]";
				}else {
					json += "["
							+"\""+ d.getId() + "\","
							+"\""+ d.getCarga_horaria() + "\","
							+"\""+ d.getEmenta() + "\","
							+"\""+ d.getCurso().getNome() + "\","
							+"\""+ d.getProfessor().getNome() + "\""
							+ "],";
				}
			}
			
			json += "]}";
		}	
		return json;
		
	}

}
