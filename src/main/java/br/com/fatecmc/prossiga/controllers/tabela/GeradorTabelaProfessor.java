package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.Professor;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;

public class GeradorTabelaProfessor implements IGeradorJson{

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
				Professor p = (Professor) e;
				if(entidades.indexOf(e) == (entidades.size() -1)) {
					json += "["
							+"\""+ p.getId() + "\","
							+"\""+ p.getNome() + "\","
							+"\""+ p.getTitulacao() + "\""
							+ "]";
				}else {
					json += "["
							+"\""+ p.getId() + "\","
							+"\""+ p.getNome() + "\","
							+"\""+ p.getTitulacao() + "\""
							+ "],";
				}
			}
			
			json += "]}";
		}	
		return json;
	}
	

}
