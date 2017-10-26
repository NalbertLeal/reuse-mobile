package br.ufrn.reuse.facade;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by nalbertg on 26/10/17.
 */

public interface ReuseFacade {
    List<Anuncio> findAllAnuncios(Usuario usuario);
}
