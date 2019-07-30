package com.example.anapaula.quilombolaappv4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

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
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, homepage).commit();
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
            return true;
        }
        else if (id == R.id.ajuda){ //ABA AJUDA.
            return true;
        }
        else if (id == R.id.sobre_nos){ //ABA SOBRE NÓS.
            setTitle("Sobre nós");
            NavAboutUs navAboutUs = new NavAboutUs();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, navAboutUs).commit();
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
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, homepage).commit();
        }

        else if (id == R.id.nav_1) {
            setTitle("Aplicativo Quilombola");  // O QUE É SER QUILOMBOLA
            Nav1 nav1 = new Nav1();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav1).commit();
        }

        else if (id == R.id.nav_2) {
            setTitle("Aplicativo Quilombola"); //QUILOMBOS DE PORTO ALEGRE
            Nav2 nav2 = new Nav2();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav2).commit();


        } else if (id == R.id.nav_3) {
            setTitle("Aplicativo Quilombola");  // LEGISLAÇÃO
            Nav3 nav3 = new Nav3();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav3).commit();
        }

        else if (id == R.id.nav_4) {
            setTitle("Aplicativo Quilombola");  // HISTORIA CULTURA E TRADIÇÃO
            Nav4 nav4 = new Nav4();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav4).commit();

        }

        else if (id == R.id.nav_5) {
            setTitle("Aplicativo Quilombola");  // SAUDE DA POPULÇÃO NEGRA
            Nav5 nav5 = new Nav5();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav5).commit();

        }

        else if (id == R.id.nav_6) {
            setTitle("Aplicativo Quilombola");  // REDES DE ATENDIMENTO
            Nav6 nav6 = new Nav6();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav6).commit();
        }

        else if (id == R.id.nav_7) {
            setTitle("Aplicativo Quilombola");  // SERVIÇÕES E BENEFICIOS
            Nav7 nav7 = new Nav7();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav7).commit();
        }

        else if (id == R.id.nav_8) {
            setTitle("Aplicativo Quilombola");  // REPRESENTAÇÕES QUILOMBOLAS
            Nav8 nav8 = new Nav8();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav8).commit();
        }

        else if (id == R.id.nav_9) {
            setTitle("Aplicativo Quilombola");  // CURIOSIDADES
            Nav9 nav9 = new Nav9();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav9).commit();
        }

        else if (id == R.id.nav_11) {
            setTitle("Aplicativo Quilombola");  // CALENDÁRIO
            Nav11 nav11 = new Nav11();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav11).commit();
        }

        else if (id == R.id.nav_10) {
            setTitle("Aplicativo Quilombola");  // MULHERES Negras Quilombola
            Nav10 nav10 = new Nav10();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav10).commit();
        }

        else if (id == R.id.nav_Login) {
            setTitle("Login");
            Nav_Login nav_login = new Nav_Login();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, nav_login).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}