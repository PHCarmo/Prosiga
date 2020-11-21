package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.*;

public class GeradorTabelaAluno implements IGeradorJson {

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
				Aluno a = (Aluno) e;
				if(entidades.indexOf(e) == (entidades.size() -1)) {
					json += "["
							+"\""+ a.getId() + "\","
							+"\""+ a.getNome() + "\","
							+"\""+ a.getRa() + "\","
							+"\""+ a.getTurma().getDescricao() + "\""
							+ "]";
				}else {
					json += "["
							+"\""+ a.getId() + "\","
							+"\""+ a.getNome() + "\","
							+"\""+ a.getRa() + "\","
							+"\""+ a.getTurma().getDescricao() + "\""
							+ "],";
				}
			}
			
			json += "]}";
		}	
		return json;
	}

}
