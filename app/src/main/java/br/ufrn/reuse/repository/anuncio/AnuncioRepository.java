package br.ufrn.reuse.repository.anuncio;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.AnuncioRemoteService;
import br.ufrn.reuse.repository.patrimonio.BemRepository;
import br.ufrn.reuse.repository.comum.UnidadeRepository;
import br.ufrn.reuse.repository.comum.UsuarioRepository;
import br.ufrn.reuse.repository.anuncio.local.AnuncioLocalRepository;
import br.ufrn.reuse.utils.SincronizacaoUtils;

/**
 * Created by nalbertg on 26/10/17.
 */

public class AnuncioRepository {

    public static final int QUANTIDADE_DIAS_SINCRONIZADO_ANUNCIO = 1;

    private AnuncioRemoteService remoteService;
    private AnuncioLocalRepository localRepository;

    public List<Anuncio> findAll(Usuario usuario) {
        return remoteService.findAll(usuario);
    }

    public Anuncio findAnuncioById(Long idAnuncio) {

        Anuncio anuncio = localRepository.findById(idAnuncio);

        if(anuncio != null && SincronizacaoUtils.isSincronizado(anuncio.getDataSincronizacao(), QUANTIDADE_DIAS_SINCRONIZADO_ANUNCIO)){
            anuncio = remoteService.findById(idAnuncio);
        }

        return remoteService.findById(idAnuncio);
    }

    public Anuncio cadastrar(Anuncio anuncio) {
        return remoteService.cadatrar(anuncio);
    }

}
