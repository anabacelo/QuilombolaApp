package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.anapaula.quilombolaappv4.R;

import java.util.ArrayList;
import java.util.List;

public class NavCartilhaSaudeBucal extends Fragment {

    public NavCartilhaSaudeBucal() {
        // obrigatório
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cartilha_saude_bucal, container, false);

        ViewPager2 viewPager = view.findViewById(R.id.viewPagerCartilha);

        List<String> titulos = new ArrayList<>();
        List<String> textos = new ArrayList<>();

        // Conteúdo inicial (teste)
        titulos.add("Higiene Bucal");
        textos.add("Escove os dentes após as refeições.");

        titulos.add("Uso do fio dental");
        textos.add("Use fio dental diariamente.");

        titulos.add("Visite o dentista");
        textos.add("Consultas regulares são importantes.");

        CartilhaAdapter adapter = new CartilhaAdapter(titulos, textos);
        viewPager.setAdapter(adapter);

        return view;
    }
}
