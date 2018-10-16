package com.example.anapaula.quilombolaappv4;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nav11 extends Fragment {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Integer>> listHashMap;


    public Nav11() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav11, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        listView = (ExpandableListView)getView().findViewById(R.id.lvExpCalendario);
        dataStart();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void dataStart()
    {
        Integer layoutJaneiro = R.layout.layout_janeiro;
        Integer layoutFevereiro = R.layout.layout_fevereiro;
        Integer layoutMarco = R.layout.layout_marco;
        Integer layoutAbril = R.layout.layout_abril;
        Integer layoutMaio = R.layout.layout_maio;
        Integer layoutJunho = R.layout.layout_junho;
        Integer layoutJulho = R.layout.layout_julho;
        Integer layoutAgosto = R.layout.layout_agosto;
        Integer layoutSetembro = R.layout.layout_setembro;
        Integer layoutOutubro = R.layout.layout_outubro;
        Integer layoutNovembro = R.layout.layout_novembro;
        Integer layoutDezembro = R.layout.layout_dezembro;


        listDataHeader = new ArrayList<String>();
        listHashMap = new HashMap<String,List<Integer>>();


        listDataHeader.add("Janeiro");
        listDataHeader.add("Fevereiro");
        listDataHeader.add("Março");
        listDataHeader.add("Abril");
        listDataHeader.add("Maio");
        listDataHeader.add("Junho");
        listDataHeader.add("Julho");
        listDataHeader.add("Agosto");
        listDataHeader.add("Setembro");
        listDataHeader.add("Outubro");
        listDataHeader.add("Novembro");
        listDataHeader.add("Dezembro");


        List<Integer> layoutList0 = new ArrayList<>();
        layoutList0.add(layoutJaneiro);

        List<Integer> layoutList1 = new ArrayList<>();
        layoutList1.add(layoutFevereiro);

        List<Integer> layoutList2 = new ArrayList<>();
        layoutList2.add(layoutMarco);

        List<Integer> layoutList3 = new ArrayList<>();
        layoutList3.add(layoutAbril);

        List<Integer> layoutList4 = new ArrayList<>();
        layoutList4.add(layoutMaio);

        List<Integer> layoutList5 = new ArrayList<>();
        layoutList5.add(layoutJunho);

        List<Integer> layoutList6 = new ArrayList<>();
        layoutList6.add(layoutJulho);

        List<Integer> layoutList7 = new ArrayList<>();
        layoutList7.add(layoutAgosto);

        List<Integer> layoutList8 = new ArrayList<>();
        layoutList8.add(layoutSetembro);

        List<Integer> layoutList9 = new ArrayList<>();
        layoutList9.add(layoutOutubro);

        List<Integer> layoutList10 = new ArrayList<>();
        layoutList10.add(layoutNovembro);

        List<Integer> layoutList11 = new ArrayList<>();
        layoutList11.add(layoutDezembro);


        listHashMap.put(listDataHeader.get(0), layoutList0);
        listHashMap.put(listDataHeader.get(1), layoutList1);
        listHashMap.put(listDataHeader.get(2), layoutList2);
        listHashMap.put(listDataHeader.get(3), layoutList3);
        listHashMap.put(listDataHeader.get(4), layoutList4);
        listHashMap.put(listDataHeader.get(5), layoutList5);
        listHashMap.put(listDataHeader.get(6), layoutList6);
        listHashMap.put(listDataHeader.get(7), layoutList7);
        listHashMap.put(listDataHeader.get(8), layoutList8);
        listHashMap.put(listDataHeader.get(9), layoutList9);
        listHashMap.put(listDataHeader.get(10), layoutList10);
        listHashMap.put(listDataHeader.get(11), layoutList11);
    }
}
