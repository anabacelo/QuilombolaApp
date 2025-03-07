package com.example.anapaula.quilombolaappv4.ui.navigation;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.anapaula.quilombolaappv4.R;
import com.example.anapaula.quilombolaappv4.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavQuilombosPortoAlegre extends Fragment
{
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Integer>> listHash;


    public NavQuilombosPortoAlegre() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav2, container, false);
    }

    public void onViewCreated(View view, Bundle saveInstanceState)
    {
        listView = (ExpandableListView)getView().findViewById(R.id.lvExp);
        initializeData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initializeData()
    {
        Integer layoutQuilombosPortoAlegre = R.layout.layout_quilombos_porto_alegre;
        Integer layoutQuilomboAlpes = R.layout.layout_quilombo_alpes;
        Integer layoutQuilomboMachado = R.layout.layout_quilombo_machado;
        Integer layoutQuilomboFlores = R.layout.layout_quilombo_flores;
        Integer layoutQuilomboAreal = R.layout.layout_quilombo_areal;
        Integer layoutQuilomboSilva = R.layout.layout_quilombo_silva;
        Integer layoutQuilomboFidelix = R.layout.layout_quilombo_fidelix;
        Integer layoutQuilomboLemos = R.layout.layout_quilombo_lemos;
        Integer layoutQuilomboOuro = R.layout.layout_quilombo_de_ouro;
        Integer layoutQuilomboMocambo = R.layout.layout_quilombo_mocambo;

        Integer layoutQuilomboAnastacia = R.layout.layout_quilombo_anastacia;

        Integer layoutEntrevistas = R.layout.layout_entrevistas;


        listDataHeader = new ArrayList<String>();
        listHash = new HashMap<>();

        listDataHeader.add("Quilombos de Porto Alegre");
        listDataHeader.add("Quilombo dos Alpes");
        listDataHeader.add("Quilombo Machado");
        listDataHeader.add("Quilombo Flores");
        listDataHeader.add("Quilombo Areal da Baronesa");
        listDataHeader.add("Quilombo Família Silva");
        listDataHeader.add("Quilombo Família Fidélix");
        listDataHeader.add("Quilombo Família Lemos");
        listDataHeader.add("Quilombo Família Ouro");
        listDataHeader.add("Quilombo Mocambo");

        listDataHeader.add("Quilombo Anastácia");

        listDataHeader.add("Entrevistas");


        List<Integer> layoutList0 = new ArrayList<>();
        layoutList0.add(layoutQuilombosPortoAlegre);

        List<Integer> layoutList1 = new ArrayList<>();
        layoutList1.add(layoutQuilomboAlpes);

        List<Integer> layoutList2 = new ArrayList<>();
        layoutList2.add(layoutQuilomboMachado);

        List<Integer> layoutList3 = new ArrayList<>();
        layoutList3.add(layoutQuilomboFlores);

        List<Integer> layoutList4 = new ArrayList<>();
        layoutList4.add(layoutQuilomboAreal);

        List<Integer> layoutList5 = new ArrayList<>();
        layoutList5.add(layoutQuilomboSilva);

        List<Integer> layoutList6 = new ArrayList<>();
        layoutList6.add(layoutQuilomboFidelix);

        List<Integer> layoutList7 = new ArrayList<>();
        layoutList7.add(layoutQuilomboLemos);

        List<Integer> layoutList8 = new ArrayList<>();
        layoutList8.add(layoutQuilomboOuro);

        List<Integer> layoutList9 = new ArrayList<>();
        layoutList9.add(layoutQuilomboMocambo);

        List<Integer> layoutList10 = new ArrayList<>();
        layoutList10.add(layoutQuilomboAnastacia);

        List<Integer> layoutList11 = new ArrayList<>();
        layoutList11.add(layoutEntrevistas);


        listHash.put(listDataHeader.get(0), layoutList0);
        listHash.put(listDataHeader.get(1), layoutList1);
        listHash.put(listDataHeader.get(2), layoutList2);
        listHash.put(listDataHeader.get(3), layoutList3);
        listHash.put(listDataHeader.get(4), layoutList4);
        listHash.put(listDataHeader.get(5), layoutList5);
        listHash.put(listDataHeader.get(6), layoutList6);
        listHash.put(listDataHeader.get(7), layoutList7);
        listHash.put(listDataHeader.get(8), layoutList8);
        listHash.put(listDataHeader.get(9), layoutList9);
        listHash.put(listDataHeader.get(10), layoutList10);
        listHash.put(listDataHeader.get(11), layoutList11);
    }
}