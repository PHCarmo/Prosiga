package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.Disciplina;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;

public class GeradorTabelaDisciplina implements IGeradorJson {

	@Override
	public String gerar(List<EntidadeDominio> entidades) {
		
		String json = "{\"data\":[]}";
		String data = "";
		if(!(entidades.isEmpty())) {
                    int totalLista = entidades.size();
                    int cont = 1;
                    for(EntidadeDominio e: entidades) {
                        Disciplina  c = (Disciplina) e;
                        data += " ["
                        		+"\""+ c.getId() + "\","
                                +"\""+ c.getNome() + "\","
                                +"\""+ c.getCarga_horaria() + "\","
                                +"\""+ c.getEmenta()+ "\","
                                +"\""+ c.getCurso().getId()+ "\","
                                +"\""+ c.getProfessor().getId()+ "\","
								+"\"<a href='/eletivaWeb/faces/formDscp.jsp?nome="
								+c.getNome()
								+"&ch="
								+c.getCarga_horaria()
								+"&ementa="
								+c.getEmenta()
								+"&curso="
								+c.getCurso().getId()
								+"&professor="
								+c.getProfessor().getId()
								+"&id="
								+c.getId()
								+"'>Atualizar</a>\","
								+"\"<a href='/eletivaWeb/ControleDscp?action=delete"
								+"&id="
								+c.getId()
								+"'>Deletar</a>\""
								+"]";
                        
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
