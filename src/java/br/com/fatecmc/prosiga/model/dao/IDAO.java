package br.com.fatecmc.prosiga.model.dao;

import br.com.fatecmc.prosiga.model.domain.EntidadeDominio;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface IDAO {
    
    public boolean salvar(EntidadeDominio entidade);
    public boolean alterar(EntidadeDominio entidade);
    public EntidadeDominio excluir(int entidade);
    public List consultar(EntidadeDominio entidade);
    
}
