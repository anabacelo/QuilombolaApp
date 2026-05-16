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
        List<Integer> imagens = new ArrayList<>();

        // PÁGINA 1
        titulos.add("Higiene Bucal");
        textos.add("Escove os dentes após as refeições e antes de dormir.");
        imagens.add(R.drawable.guide_img1);

        // PÁGINA 2
        titulos.add("Uso do fio dental");
        textos.add("Use fio dental diariamente para remover resíduos.");
        imagens.add(R.drawable.guide_img2);

        // PÁGINA 3
        titulos.add("Visite o dentista");
        textos.add("Consultas regulares ajudam na prevenção.");
        imagens.add(R.drawable.guide_img3);

        // PÁGINA 4
        titulos.add("Escovação correta");
        textos.add("Escove com movimentos suaves e circulares.");
        imagens.add(R.drawable.guide_img4);

        // PÁGINA 5
        titulos.add("Saúde Bucal");
        textos.add("Cuidar da boca é cuidar da saúde do corpo todo.");
        imagens.add(R.drawable.guide_img5);

        // PÁGINA 6
        titulos.add("Prevenção");
        textos.add("A prevenção é o melhor caminho para evitar doenças.");
        imagens.add(R.drawable.guide_img6);

        CartilhaAdapter adapter =
                new CartilhaAdapter(titulos, textos, imagens);

        viewPager.setAdapter(adapter);

        return view;
    }
}
