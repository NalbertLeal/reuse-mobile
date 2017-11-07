package br.ufrn.reuse.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

/**
 * Created by Daniel on 10/31/2017.
 */
public abstract class AbstractActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_anunciar) {
            Intent intent = new Intent(this, AnunciarActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_interesses) {
            Intent intent = new Intent(this,InteressesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_anuncios) {
            Intent intent = new Intent(this, AnunciosActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    /**
     * Recupera o usuario logado e mostra seus dados
     */
    protected void recuperaUsuarioUnidade() {

        Long idUsuario = getIntent().getLongExtra("usuarioLogado", 0);
        Usuario usuarioLogado = new ReuseFacadeImpl(this).findUsuario(idUsuario);
        TextView nome = (TextView) findViewById(R.id.textUser);
        if(nome != null)
            nome.setText(usuarioLogado.getPessoa().getNome());
        TextView email = (TextView) findViewById(R.id.textEmailUser);
        if(email != null)
            email.setText(usuarioLogado.getEmail());

        Long unidadeLogada = getIntent().getLongExtra("unidadeLogada", 0);
        TextView unidade = (TextView) findViewById(R.id.textEmailUser);
        if(unidade != null && unidadeLogada >= 0)
            unidade.setText(unidadeLogada.toString());
    }

    protected void salvarUltimoUsuarioLogado(String usuario){
        SharedPreferences sp = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sp.edit();
        editor.putString("ultimoLogado", usuario);
        editor.putBoolean("logarAutomaticamente", true);
    }

    protected void salvarUnidadeUltimoLogado(Long unidade) {
        SharedPreferences sp = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sp.edit();
        editor.putLong("unidadeUltimoLogado", unidade);
    }

}
