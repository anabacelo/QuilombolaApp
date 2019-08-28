package com.example.anapaula.quilombolaappv4;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nav3 extends Fragment implements IOnBackPressed{

    private WebView mWebView;

    //    lista dropDown -- início
//    private ExpandableListView listView;
//    private ExpandableListAdapter listAdapter;
//    private List<String> listDataHeader;
//    private HashMap<String, List<Integer>> listHash;
    //    lista dropDown -- fim

    public Nav3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_web, container, false);

        mWebView = (WebView) view.findViewById(R.id.webViewMain);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Stop local links and redirects from opening in browser instead of WebView
        mWebView.setWebViewClient(new WebViewClientOverride());

        if(CheckInternetConnection.simpleServerCheck()){
            mWebView.loadUrl("http://app-quilombola.epizy.com/legislacao.html");
            Toast.makeText(GlobalApplication.getAppContext(), "Versão web carregada!", Toast.LENGTH_LONG).show();
        }
        else {
            mWebView.loadUrl("file:///android_asset/www/legislacao.html");
            Toast.makeText(GlobalApplication.getAppContext(), "Não foi possivel acessar o servidor. Versão local carregada!", Toast.LENGTH_LONG).show();
        }

        //Toast.makeText(GlobalApplication.getAppContext(), "Servidor remoto: " + CheckInternetConnection.simpleServerCheck(), Toast.LENGTH_LONG).show();
        //return inflater.inflate(R.layout.fragment_home_page, container, false);
        return view;

        //return inflater.inflate(R.layout.fragment_nav3, container, false);
    }

    @Override
    public boolean onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            //action not popBackStack
            return true;
        } else {
            return false;
        }
    }

//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState)
//    {
//        listView = (ExpandableListView)getView().findViewById(R.id.lvExp);
//        iniData();
//        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
//        listView.setAdapter(listAdapter);
//    }
//
//    private void iniData()
//    {
//        Integer layoutEstatutoIdoso = R.layout.layout_estatuto_idoso;
//        Integer layoutEstatutoCrianca = R.layout.layout_estatuto_crianca;
//        Integer layoutEstatutoIgualdadeRacial = R.layout.layout_estatuto_igualdade_racial;
//        Integer layoutEstatutoJuventude = R.layout.layout_estatudo_juventude;
//        Integer layoutPoliticaNacionalDeAssistenciaSocial = R.layout.layout_politica_nacional_de_assistencia_social;
//        Integer layoutProgramaBrasilQuilombola = R.layout.layout_programa_brasil_quilombola;
//        Integer layoutLeiMariaDaPenha = R.layout.layout_lei_maria_da_penha;
//
//
//        listDataHeader = new ArrayList<String>();
//        listHash = new HashMap<>();
//
//        listDataHeader.add("Estatuto do Idoso");
//        listDataHeader.add("Estatuto da Criança e do Adolescente");
//        listDataHeader.add("Estatuto da Igualdade Racial");
//        listDataHeader.add("Estatuto da Juventude");
//        listDataHeader.add("Politica Nacional de Assistencia Social");
//        listDataHeader.add("Programa Brasil Quilombola");
//        listDataHeader.add("Lei Maria da Penha");
//
//
//        List<Integer> layoutList0 = new ArrayList<>();
//        layoutList0.add(layoutEstatutoIdoso);
//
//        List<Integer> layoutList1 = new ArrayList<>();
//        layoutList1.add(layoutEstatutoCrianca);
//
//        List<Integer> layoutList2 = new ArrayList<>();
//        layoutList2.add(layoutEstatutoIgualdadeRacial);
//
//        List<Integer> layoutList3 = new ArrayList<>();
//        layoutList3.add(layoutEstatutoJuventude);
//
//        List<Integer> layoutList4 = new ArrayList<>();
//        layoutList4.add(layoutPoliticaNacionalDeAssistenciaSocial);
//
//        List<Integer> layoutList5 = new ArrayList<>();
//        layoutList5.add(layoutProgramaBrasilQuilombola);
//
//        List<Integer> layoutList6 = new ArrayList<>();
//        layoutList6.add(layoutLeiMariaDaPenha);
//
//
//        listHash.put(listDataHeader.get(0), layoutList0);
//        listHash.put(listDataHeader.get(1), layoutList1);
//        listHash.put(listDataHeader.get(2), layoutList2);
//        listHash.put(listDataHeader.get(3), layoutList3);
//        listHash.put(listDataHeader.get(4), layoutList4);
//        listHash.put(listDataHeader.get(5), layoutList5);
//        listHash.put(listDataHeader.get(6), layoutList6);
//    }
}