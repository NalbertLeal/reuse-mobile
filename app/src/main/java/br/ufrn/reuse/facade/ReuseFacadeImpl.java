package br.ufrn.reuse.facade;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.repository.AnuncioRepository;

/**
 * Created by nalbertg on 26/10/17.
 */

public class ReuseFacadeImpl implements ReuseFacade {

    private AnuncioRepository anuncioRepository;

    @Override
    public List<Anuncio> findAllAnuncios(Usuario usuario) {
        List<Anuncio> anuncios = anuncioRepository.findAll(usuario);





        return anuncios;
    }
}
