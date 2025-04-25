package com.example.anapaula.quilombolaappv4;

import android.os.Bundle;
import androidx.fragment.app.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.example.anapaula.quilombolaappv4.databinding.ActivityMainBinding;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavAboutUs;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavAcoesAfirmativas;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavAtencaoAosQuilombos;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavCalendario;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavComoSolicitarBeneficios;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavComoUsarOPIAPS;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavCuriosidades;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavHistoriaCulturaTradicao;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavLegislacao;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavMulheresQuilombolas;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavQuilombosPortoAlegre;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavRedesAtendimento;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavRepresentacao;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavSaudeNegra;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavSerQuilombola;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavServicosSociais;
import com.example.anapaula.quilombolaappv4.ui.navigation.HomePage;
import com.example.anapaula.quilombolaappv4.ui.navigation.NavVacinacao;
import com.example.anapaula.quilombolaappv4.utils.IOnBackPressed;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

import androidx.navigation.ui.AppBarConfiguration;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private FragmentActivity myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("Quilombytes");

//        Menu menu = navigationView.getMenu();
//
//        MenuItem communicateItem = menu.findItem(R.id.nav_communicate);
//
//        if (communicateItem != null) {
//            SpannableString s = new SpannableString(communicateItem.getTitle());
//            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, s.length(), 0);
//            communicateItem.setTitle(s);
//        }

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
            setTitle("Sobre Nós");
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
            setTitle("Quilombytes");  // PÁGINA INICIAL
            HomePage homepage = new HomePage();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, homepage).commit();
        }

        else if (id == R.id.nav_1) {
            setTitle("O que é ser Quilombola");  // O QUE É SER QUILOMBOLA
            NavSerQuilombola navSerQuilombola = new NavSerQuilombola();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navSerQuilombola).commit();
        }

        else if (id == R.id.nav_2) {
            setTitle("Quilombos de Porto Alegre"); //QUILOMBOS DE PORTO ALEGRE
            NavQuilombosPortoAlegre navQuilombosPortoAlegre = new NavQuilombosPortoAlegre();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navQuilombosPortoAlegre).commit();

	    }

        else if (id == R.id.nav_3) {
            setTitle("Legislação");  // LEGISLAÇÃO
            NavLegislacao navLegislacao = new NavLegislacao();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navLegislacao).commit();
        }

        else if (id == R.id.nav_acoes) {
            setTitle("Ações Afirmativas");  // AÇÕES AFIRMATIVAS
            NavAcoesAfirmativas navAcoesAfirmativas = new NavAcoesAfirmativas();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navAcoesAfirmativas).commit();
        }

        else if (id == R.id.nav_4) {
            setTitle("História, Cultura e Tradição");  // HISTORIA CULTURA E TRADIÇÃO
            NavHistoriaCulturaTradicao navHistoriaCulturaTradicao = new NavHistoriaCulturaTradicao();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navHistoriaCulturaTradicao).commit();
        }

        else if (id == R.id.nav_5) {
            setTitle("Saúde da População Negra");  // SAUDE DA POPULÇÃO NEGRA
            NavSaudeNegra navSaudeNegra = new NavSaudeNegra();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navSaudeNegra).commit();

        }

        else if (id == R.id.nav_vacinacao) {
            setTitle("Informações sobre vacinação");
            NavVacinacao vacinacao = new NavVacinacao();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, vacinacao).commit();
        }

        else if (id == R.id.nav_6) {
            setTitle("Redes de Atendimento");  // REDES DE ATENDIMENTO
            NavRedesAtendimento navRedesAtendimento = new NavRedesAtendimento();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navRedesAtendimento).commit();
        }

        else if (id == R.id.nav_7) {
            setTitle("Serviços e Benefícios");  // SERVIÇÕES E BENEFICIOS
            NavServicosSociais navServicosSociais = new NavServicosSociais();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navServicosSociais).commit();
        }

        else if (id == R.id.nav_conseguir_beneficios) { // Como Solicitar Benefícios
            setTitle("Como Solicitar Benefícios");
            NavComoSolicitarBeneficios nav_conseguir_beneficios = new NavComoSolicitarBeneficios();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav_conseguir_beneficios).commit();
        }

        else if (id == R.id.nav_usar_piaps) { // Como Usar o PIAPS
            setTitle("Como Usar o PIAPS");
            NavComoUsarOPIAPS nav_como_usar_o_piaps = new NavComoUsarOPIAPS();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav_como_usar_o_piaps).commit();
        }

        else if (id == R.id.nav_atencao_aos_quilombolas) { // ATENÇÃO À SAÚDE DA POPULAÇÃO QUILOMBOLA
            setTitle("Atenção à Saúde da População Quilombola");
            NavAtencaoAosQuilombos nav_atencao_aos_quilombos = new NavAtencaoAosQuilombos();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, nav_atencao_aos_quilombos).commit();
        }

        else if (id == R.id.nav_8) {
            setTitle("Representações Culturais");  // REPRESENTAÇÕES QUILOMBOLAS
            NavRepresentacao navRepresentacao = new NavRepresentacao();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navRepresentacao).commit();
        }

        else if (id == R.id.nav_9) {
            setTitle("Curiosidades");  // CURIOSIDADES
            NavCuriosidades navCuriosidades = new NavCuriosidades();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navCuriosidades).commit();
        }

        else if (id == R.id.nav_11) {
            setTitle("Calendário");  // CALENDÁRIO
            NavCalendario navCalendario = new NavCalendario();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navCalendario).commit();
        }

        else if (id == R.id.nav_10) {
            setTitle("Mulheres Negras Quilombola");  // MULHERES Negras Quilombola
            NavMulheresQuilombolas navMulheresQuilombolas = new NavMulheresQuilombolas();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment, navMulheresQuilombolas).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}