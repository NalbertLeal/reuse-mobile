package br.ufrn.reuse.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.ufrn.reuse.R;

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

}
