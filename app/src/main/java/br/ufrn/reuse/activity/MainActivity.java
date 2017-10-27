package br.ufrn.reuse.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.facade.ReuseFacade;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

public class MainActivity extends AppCompatActivity {

    private ReuseFacade reuseFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        reuseFacade = new ReuseFacadeImpl();

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        List<Anuncio> anunciosUsuario = reuseFacade.findAllAnuncios(usuario);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
