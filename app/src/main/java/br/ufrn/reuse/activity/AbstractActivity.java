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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.facade.ReuseFacade;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

/**
 * Classe que contém comportamentos padrão para todas as activity do sistema.
 *
 * @author Daniel
 * @author Esther
 *
 */
public abstract class AbstractActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    /**
     * Dependência da Fachada do Reuse.
     */
    protected ReuseFacade reuseFacade;

    /**
     * Logger da aplicação.
     */
    protected Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Usuário logado.
     */
    protected Usuario usuarioLogado;

    /**
     * Mapa que contem a associação entre item de menu e activity que será aberta ao clicar.
     */
    private static Map<Integer, Class<? extends Activity>> activitiesMenuMap = getActivitiesMap();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(this,getActivityClass(item.getItemId())));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    /**
     * Retorna a activity que será criada ao abrir um item do menu.
     *
     * @param idLink
     * @return
     */
    public Class<?> getActivityClass(int idLink){

        Map<Integer, Class<? extends Activity>> activitiesMenuMap = getActivitiesMap();

        if (activitiesMenuMap.containsKey(idLink)) {
            return activitiesMenuMap.get(idLink);
        }

        throw new IllegalStateException("O id passado deve estar associado à um menu da aplicação");

    }

    /**
     * Associa o item do menu à activity que será iniciada no click.
     *
     * @return
     */
    @NonNull
    private static Map<Integer, Class<? extends Activity>> getActivitiesMap() {

        if(activitiesMenuMap == null) {
            activitiesMenuMap = new HashMap<>();

            activitiesMenuMap.put(R.id.nav_anunciar, AnunciarActivity.class);
            activitiesMenuMap.put(R.id.nav_interesses, InteressesActivity.class);
            activitiesMenuMap.put(R.id.nav_anuncios, MeusAnunciosActivity.class);
        }

        return activitiesMenuMap;
    }


    /**
     * Recupera o usuario logado e mostra seus dados
     */
    protected void recuperaUsuarioUnidade() {

        //TODO: Olhar isso
        Long idUsuario = getIntent().getLongExtra("usuarioLogado", 0);
        usuarioLogado = new ReuseFacadeImpl(this).findUsuarioById(idUsuario);

        View navView = findViewById(R.id.nav_view);
        TextView nome = (TextView) navView.findViewById(R.id.textUser);
        if(nome != null)
            nome.setText(usuarioLogado.getPessoa().getNome());
        TextView email = (TextView) navView.findViewById(R.id.textEmailUser);
        if(email != null)
            email.setText(usuarioLogado.getEmail());

        /*Long unidadeLogada = getIntent().getLongExtra("unidadeLogada", 0);
        Unidade uni = new ReuseFacadeImpl(this).findUnidadeById(unidadeLogada);
        TextView unidade = (TextView) navView.findViewById(R.id.textUnidadeUser);
        if(unidade != null && unidadeLogada >= 0) {
            unidade.setText(unidadeLogada.toString());
        }*/
    }

    /**
     * Salva o usuario logado nas shared preferences
     * @param usuario
     */
    protected void salvarUltimoUsuarioLogado(String usuario){
        SharedPreferences sp = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sp.edit();
        editor.putString("ultimoLogado", usuario);
        editor.apply();
        editor.putBoolean("logarAuto", true);
        editor.apply();
    }

    /**
     * Salva a unidade do usuário logado nas shared preferences.
     * @param unidade
     */
    protected void salvarUnidadeUltimoLogado(Long unidade) {
        SharedPreferences sp = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sp.edit();
        editor.putLong("unidadeUltimoLogado", unidade);
        editor.apply();
    }

    public void showErrorOnToast(String error, int duration){
        Toast.makeText(this,error, duration);
    }

    public void iniciaBarraSuperior(String titulo) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(titulo);
    }
}

