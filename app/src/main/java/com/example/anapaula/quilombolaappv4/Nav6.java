package com.example.anapaula.quilombolaappv4;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
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
public class Nav6 extends Fragment {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Integer>> listHash;


    public Nav6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav6, container, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState){
        listView = (ExpandableListView)getView().findViewById(R.id.lvExp);
        initializeData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    public void initializeData()
    {
        Integer layoutRedeAtendimentoIntro = R.layout.layout_rede_atendimento_intro;
        Integer layoutRedeAtendimentoSobre = R.layout.layout_rede_atendimento_sobre;
        Integer layoutRedeAtendimentoServicoConveniencia = R.layout.layout_rede_atendimento_servico_conveniencia;
        Integer layoutRedeAtendimentoContato = R.layout.layout_rede_atendimento_contato;
        Integer layoutServicoEnfrentamentoViolencia = R.layout.layout_servico_enfrentamento_violencia;


        listDataHeader = new ArrayList<String>();
        listHash = new HashMap<>();

        listDataHeader.add("Redes de Atendimento");
        listDataHeader.add("O que é? Onde? Como acessar?");
        listDataHeader.add("Serviço de Convivência - SCFV");
        listDataHeader.add("Telefones Úteis em Porto Alegre");
        listDataHeader.add("Serviços de Enfrentamento à Violência");

        List<Integer> layoutList0 = new ArrayList<>();
        layoutList0.add(layoutRedeAtendimentoIntro);

        List<Integer> layoutList1 = new ArrayList<>();
        layoutList1.add(layoutRedeAtendimentoSobre);

        List<Integer> layoutList2 = new ArrayList<>();
        layoutList2.add(layoutRedeAtendimentoServicoConveniencia);

        List<Integer> layoutList3 = new ArrayList<>();
        layoutList3.add(layoutRedeAtendimentoContato);

        List<Integer> layoutList4 = new ArrayList<>();
        layoutList4.add(layoutServicoEnfrentamentoViolencia);

        listHash.put(listDataHeader.get(0), layoutList0);
        listHash.put(listDataHeader.get(1), layoutList1);
        listHash.put(listDataHeader.get(2), layoutList2);
        listHash.put(listDataHeader.get(3), layoutList3);
        listHash.put(listDataHeader.get(4), layoutList4);
    }
}