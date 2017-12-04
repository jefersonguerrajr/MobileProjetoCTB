package adapter.android.dominando.mobileprojetoctb.Maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import adapter.android.dominando.mobileprojetoctb.cadastros.LoginActivity;
import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.cadastros.ListaServicos;
import adapter.android.dominando.mobileprojetoctb.settings.help.HelpActivity;

public class ActivityPrincipalCTB extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager; // esse objeto será responsavel pelos fragmentos do meu activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_ctb);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*butão flutuante caso precise deixei ele comentado


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle); // esse metodo estar ouvindo os eventos quando for abrir e fechar o item do menu inicial
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();// recuperando o objeto fragmente
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //adcionando o fragmente ao meu activit
        transaction.add(R.id.containerMaps, new MapsFragment(), "Mapsfragment");

        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {  // aqui estou chamando o menu do layaut inicial
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_principal_ctb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_help){
            Intent helpIntent = new Intent(this, HelpActivity.class);
            startActivity(helpIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showFragment(Fragment fragment,String name){

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //adcionando o fragmente ao meu activit
        transaction.replace(R.id.containerMaps, fragment,name); ///

        transaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.nav_exemplomenu:
                showFragment(new MapsFragment(),"MapsFragment");

                break;
           // case R.id.nav_exemploProvaiderV1:
              //  showFragment(new MapsFragment(),"ProvaiderV1MapsFragment");
            //    break;

         //   case R.id.nav_mapsGPS:
             //   showFragment(new MapsFragment(),"MapsGPS");
           //     break;

            case R.id.logintelainicio:
//// chamar uma Activity a partir de um item de um navigation drawer
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                    break;


            case R.id.nav_servicos:
//// chamar uma Activity a partir de um item de um navigation drawer
                Intent intentServicos = new Intent(this, ListaServicos.class);
                startActivity(intentServicos);
                break;

        }

        /*os itens de menus caso precise já temos aqui
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
