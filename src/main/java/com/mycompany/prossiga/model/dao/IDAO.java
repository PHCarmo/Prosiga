package com.mycompany.prossiga.model.dao;

import br.com.fatecmc.prosiga.model.domain.EntidadeDominio;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface IDAO {
    
    public boolean salvar(EntidadeDominio entidade);
    public boolean alterar(EntidadeDominio entidade);
    public boolean excluir(int id);
    public List consultar();
    public List consultar(int id);
    
}
