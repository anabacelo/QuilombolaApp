package com.example.anapaula.quilombolaappv4.ui.navigation;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import com.example.anapaula.quilombolaappv4.R;
import com.example.anapaula.quilombolaappv4.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavServicosSociais extends Fragment {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Integer>> listHash;


    public NavServicosSociais() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav7, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.lvExp);

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
        layoutList0.add(layoutCadastroUnico);

        List<Integer> layoutList1 = new ArrayList<>();
        layoutList1.add(layoutServicoBeneficioSocial);

        List<Integer> layoutList2 = new ArrayList<>();
        layoutList2.add(layoutBeneficioPrestacaoContinuada);

        listHash.put(listDataHeader.get(0), layoutList0);
        listHash.put(listDataHeader.get(1), layoutList1);
        listHash.put(listDataHeader.get(2), layoutList2);
    }
}