package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prossiga.model.domain.Turma;

public class GeradorTabelaTurma implements IGeradorJson {

	@Override
	public String gerar(List<EntidadeDominio> entidades) {
		
		String json = "{\"data\":[]}";
		String data = "";
		if(!(entidades.isEmpty())) {
                    int totalLista = entidades.size();
                    int cont = 1;
                    for(EntidadeDominio e: entidades) {
                        Turma  c = (Turma) e;
                        data += " ["
                        		+"\""+ c.getId() + "\","
                                +"\""+ c.getDescricao() + "\","
                                +"\""+ c.getCurso().getId() + "\","
								+"\"<a href='/eletivaWeb/faces/formTurma.jsp?descricao="
								+c.getDescricao()
								+"&curso="
								+c.getCurso().getId()
								+"&descricao="
								+c.getDescricao()
								+"&id="
								+c.getId()
								+"'>Atualizar</a>\","
								+"\"<a href='/eletivaWeb/ControleTurma?action=delete"
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
		System.out.println(json);
		return json;
		
	}
	

}
