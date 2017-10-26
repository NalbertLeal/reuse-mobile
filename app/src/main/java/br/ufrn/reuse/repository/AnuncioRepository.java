package br.ufrn.reuse.repository;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.AnuncioRemoteService;
import br.ufrn.reuse.repository.local.AnuncioLocalRepository;

/**
 * Created by nalbertg on 26/10/17.
 */

public class AnuncioRepository {

    private AnuncioRemoteService remoteService;
    private AnuncioLocalRepository localRepository;

    public List<Anuncio> findAll(Usuario usuario) {
        return remoteService.findAll(usuario);
    }
}
