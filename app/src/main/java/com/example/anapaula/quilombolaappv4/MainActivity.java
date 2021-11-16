package com.example.anapaula.quilombolaappv4;

import android.os.Bundle;
import androidx.fragment.app.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.example.anapaula.quilombolaappv4.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.navigation.ui.AppBarConfiguration;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private FragmentActivity myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "[EM CONSTRUÇÃO] Este botão será para envio de publicações", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomePage homepage = new HomePage();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment, homepage).commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.config) { //ABA CONFIGURAÇÕES.
            //Será feito em versões futuras
            return true;
        }
        else if (id == R.id.ajuda){ //ABA AJUDA.
            //Será feito em versões futuras
            return true;
        }
        else if (id == R.id.sobre_nos){ //ABA SOBRE NÓS.
            setTitle("Sobre nós");
            NavAboutUs navAboutUs = new NavAboutUs();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navAboutUs).commit();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_homepage)
        {
            setTitle("Aplicativo Quilombola");  // PÁGINA INICIAL
            HomePage homepage = new HomePage();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, homepage).commit();
        }

        else if (id == R.id.nav_1) {
            setTitle("Aplicativo Quilombola");  // O QUE É SER QUILOMBOLA
            Nav1 nav1 = new Nav1();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav1).commit();
        }

        else if (id == R.id.nav_2) {
            setTitle("Aplicativo Quilombola"); //QUILOMBOS DE PORTO ALEGRE
            Nav2 nav2 = new Nav2();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav2).commit();

	    }

	    else if (id == R.id.nav_Login) {      // ABA LOGIN
            setTitle("Login");
            Nav_Login nav_login = new Nav_Login();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav_login).commit();
        }

        else if (id == R.id.nav_3) {
            setTitle("Aplicativo Quilombola");  // LEGISLAÇÃO
            Nav3 nav3 = new Nav3();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav3).commit();
        }

        else if (id == R.id.nav_acoes) {
            setTitle("Aplicativo Quilombola");  // AÇÕES AFIRMATIVAS
            NavAcoesAfirmativas navAcoesAfirmativas = new NavAcoesAfirmativas();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navAcoesAfirmativas).commit();
        }

        else if (id == R.id.nav_4) {
            setTitle("Aplicativo Quilombola");  // HISTORIA CULTURA E TRADIÇÃO
            Nav4 nav4 = new Nav4();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav4).commit();
        }

        else if (id == R.id.nav_5) {
            setTitle("Aplicativo Quilombola");  // SAUDE DA POPULÇÃO NEGRA
            Nav5 nav5 = new Nav5();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav5).commit();

        }

	    else if (id == R.id.navCovid) {
            setTitle("Aplicativo Quilombola");  // SAUDE NA PANDEMIA
            NavCovid navCovid = new NavCovid();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navCovid).commit();
        }

        else if (id == R.id.nav_6) {
            setTitle("Aplicativo Quilombola");  // REDES DE ATENDIMENTO
            Nav6 nav6 = new Nav6();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav6).commit();
        }

        else if (id == R.id.nav_7) {
            setTitle("Aplicativo Quilombola");  // SERVIÇÕES E BENEFICIOS
            Nav7 nav7 = new Nav7();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav7).commit();
        }

        else if (id == R.id.nav_8) {
            setTitle("Aplicativo Quilombola");  // REPRESENTAÇÕES QUILOMBOLAS
            Nav8 nav8 = new Nav8();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav8).commit();
        }

        else if (id == R.id.nav_9) {
            setTitle("Aplicativo Quilombola");  // CURIOSIDADES
            Nav9 nav9 = new Nav9();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav9).commit();
        }

        else if (id == R.id.nav_11) {
            setTitle("Aplicativo Quilombola");  // CALENDÁRIO
            Nav11 nav11 = new Nav11();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav11).commit();
        }

        else if (id == R.id.nav_10) {
            setTitle("Aplicativo Quilombola");  // MULHERES Negras Quilombola
            Nav10 nav10 = new Nav10();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav10).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}