package com.example.anapaula.quilombolaappv4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class Nav5 extends Fragment {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Integer>> listHash;


    public Nav5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav5, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        listView = (ExpandableListView)getView().findViewById(R.id.lvExp);
        initializeData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initializeData()
    {
        Integer layoutSaudePopulacaoNegra = R.layout.layout_saude_populacao_negra;
        Integer layoutPoliticaNacionalDeSaudeIntegral = R.layout.layout_politica_nacional_integral;
        Integer layoutDoencasPrevalecenteNegra = R.layout.layout_doencas_prevalecente_negra;
        Integer layoutAnemiaFalciforme = R.layout.layout_anemia_falciforme;
        Integer layoutDiabeteMellitus = R.layout.layout_diabete_mellitus;
        Integer layoutHipertensaoArterial = R.layout.layout_hipertensao_arterial;
        Integer layoutMiomaUterino = R.layout.layout_mioma_uterino;
        Integer layoutQuilombosAtendidosSUS = R.layout.layout_quilombos_atendidos_sus;

        listDataHeader = new ArrayList<String>();
        listHash = new HashMap<>();

        listDataHeader.add("Saúde da População Negra");
        listDataHeader.add("Política Nacional de Saúde Integral da População Negra: Uma política para o SUS");
        listDataHeader.add("Doenças Prevalecentes na População Negra");
        listDataHeader.add("Anemia Falciforme");
        listDataHeader.add("Diabetes Mellitus");
        listDataHeader.add("Hipertensão Arterial Sistêmica");
        listDataHeader.add("Mioma Uterino");
        listDataHeader.add("Atendimento SUS para os Quilombos");

        List<Integer> layoutList0 = new ArrayList<>();
        layoutList0.add(layoutSaudePopulacaoNegra);

        List<Integer> layoutList1 = new ArrayList<>();
        layoutList1.add(layoutPoliticaNacionalDeSaudeIntegral);

        List<Integer> layoutList2 = new ArrayList<>();
        layoutList2.add(layoutDoencasPrevalecenteNegra);

        List<Integer> layoutList3 = new ArrayList<>();
        layoutList3.add(layoutAnemiaFalciforme);

        List<Integer> layoutList4 = new ArrayList<>();
        layoutList4.add(layoutDiabeteMellitus);

        List<Integer> layoutList5 = new ArrayList<>();
        layoutList5.add(layoutHipertensaoArterial);

        List<Integer> layoutList6 = new ArrayList<>();
        layoutList6.add(layoutMiomaUterino);

        List<Integer> layoutList7 = new ArrayList<>();
        layoutList7.add(layoutQuilombosAtendidosSUS);

        listHash.put(listDataHeader.get(0), layoutList0);
        listHash.put(listDataHeader.get(1), layoutList1);
        listHash.put(listDataHeader.get(2), layoutList2);
        listHash.put(listDataHeader.get(3), layoutList3);
        listHash.put(listDataHeader.get(4), layoutList4);
        listHash.put(listDataHeader.get(5), layoutList5);
        listHash.put(listDataHeader.get(6), layoutList6);
        listHash.put(listDataHeader.get(7), layoutList7);
    }
}