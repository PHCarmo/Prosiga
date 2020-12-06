package br.com.fatecmc.prossiga.controllers.tabela;

import java.util.List;

import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;

public class GeradorTabelaCurso implements IGeradorJson {

	@Override
	public String gerar(List<EntidadeDominio> entidades) {
		
		String json = "";
		String data = "";
		if(!(entidades.isEmpty())) {
                    int totalLista = entidades.size();
                    int cont = 1;
                    for(EntidadeDominio e: entidades) {
                        Curso  c = (Curso) e;
                        data += " ["
                        		+"\""+ c.getId() + "\","
                                +"\""+ c.getNome() + "\","
                                +"\""+ c.getTurno() + "\","
                                +"\""+ c.getDescricao() + "\","
								+"\"<a href='/eletivaWeb/faces/formCurso.jsp?nome="
								+c.getNome()
								+"&turno="
								+c.getTurno()
								+"&descricao="
								+c.getDescricao()
								+"&id="
								+c.getId()
								+"'>Atualizar</a>\","
								+"\"<a href='/eletivaWeb/ControleCurso?action=delete"
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
