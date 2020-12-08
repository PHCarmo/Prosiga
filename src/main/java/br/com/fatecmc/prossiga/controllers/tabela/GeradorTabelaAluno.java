package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.*;

public class GeradorTabelaAluno implements IGeradorJson {

	@Override
	public String gerar(List<EntidadeDominio> entidades) {
		
		String json = "{\"data\":[]}";
		String data = "";
		if(!(entidades.isEmpty())) {
                    int totalLista = entidades.size();
                    int cont = 1;
                    for(EntidadeDominio e: entidades) {
                        Aluno  c = (Aluno) e;
                        data += " ["
                        		+"\""+ c.getId() + "\","
                                +"\""+ c.getNome() + "\","
                                +"\""+ c.getRa() + "\","
                                +"\""+ c.getTurma().getId() + "\","
								+"\"<a href='/eletivaWeb/faces/formAluno.jsp?nome="
								+c.getNome()
								+"&ra="
								+c.getRa()
								+"&turma="
								+c.getTurma().getId()
								+"&id="
								+c.getId()
								+"'>Atualizar</a>\","
								+"\"<a href='/eletivaWeb/ControleAluno?action=delete"
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
