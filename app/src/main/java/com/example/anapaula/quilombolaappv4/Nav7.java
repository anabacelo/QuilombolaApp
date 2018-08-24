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
public class Nav7 extends Fragment {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Integer>> listHash;


    public Nav7() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav7, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstaceState)
    {
        listView = (ExpandableListView)getView().findViewById(R.id.lvExp);
        initializeData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    public void initializeData()
    {
        Integer layoutCadastroUnico = R.layout.layout_serv_ben_cadastro_unico;
        Integer layoutServicoBeneficioSocial = R.layout.layout_servico_beneficio_social;
        Integer layoutBeneficioPrestacaoContinuada = R.layout.layout_beneficio_continuado;

        listDataHeader = new ArrayList<String>();
        listHash = new HashMap<>();

        listDataHeader.add("Cadastro Único");
        listDataHeader.add("Programa Bolsa Família");
        listDataHeader.add("Benefício de Prestação Continuada");

        List<Integer> layoutList0 = new ArrayList<>();
        layoutList0.add(layoutServicoBeneficioSocial);

        List<Integer> layoutList1 = new ArrayList<>();
        layoutList1.add(layoutCadastroUnico);

        List<Integer> layoutList2 = new ArrayList<>();
        layoutList2.add(layoutBeneficioPrestacaoContinuada);

        listHash.put(listDataHeader.get(0), layoutList0);
        listHash.put(listDataHeader.get(1), layoutList1);
        listHash.put(listDataHeader.get(2), layoutList2);
    }
}
