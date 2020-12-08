package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.Professor;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;

public class GeradorTabelaProfessor implements IGeradorJson{

	@Override
	public String gerar(List<EntidadeDominio> entidades) {
		
		String json = "{\"data\":[]}";
		String data = "";
		if(!(entidades.isEmpty())) {
                    int totalLista = entidades.size();
                    int cont = 1;
                    for(EntidadeDominio e: entidades) {
                        Professor p = (Professor) e;
                        data += " ["
                        		+"\""+ p.getId() + "\","
                                +"\""+ p.getNome() + "\","
                                +"\""+ p.getTitulacao() + "\","
								+"\"<a href='/eletivaWeb/faces/formProf1.jsp?nome="
								+p.getNome()
								+"&titulacao="
								+p.getTitulacao()
								+"&id="
								+p.getId()
								+"'>Atualizar</a>\","
								+"\"<a href='/eletivaWeb/ControleProfessor?action=delete"
								+"&id="
								+p.getId()
								+"'>Deletar</a>\""
								+"]";
                        
                        			//+ ","+"\"<a href='/eletivaWeb/faces/formProf.xhtml?nome="+p.getNome()+"&titulacao="+p.getTitulacao()+"'>Deletar</a>]";
                        if(cont < totalLista){
                            data += ",";
                        }
                        cont++;
                    }
                    json = "{"
                                    + "  \"draw\": 1,"
                                    + "  \"recordsTotal\": "+ entidades.size() +","
                                    + "  \"recordsFiltered\": "+ entidades.size() +","
                                    + "  \"data\": ["+
                                    data +
                                    "]"+
                                    "}";
		}
		return json;
	}
	

}
