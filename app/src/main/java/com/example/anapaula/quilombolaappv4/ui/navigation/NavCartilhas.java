package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.anapaula.quilombolaappv4.R;

public class NavCartilhas extends Fragment {

    public NavCartilhas() {
        // Construtor obrigatório
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.nav_cartilhas,
                container,
                false
        );

        Button btnMudancasClimaticas =
                view.findViewById(R.id.btnCartilhaMudancasClimaticas);

        Button btnVigilanciaPopular =
                view.findViewById(R.id.btnCartilhaVigilanciaPopular);

        btnMudancasClimaticas.setOnClickListener(v -> {

            abrirPdf("mudancas_climaticas_saude_das_quilombolas.pdf");

        });

        btnVigilanciaPopular.setOnClickListener(v -> {

            abrirPdf("vigilancia_popular_saude_quilombolas.pdf");

        });

        return view;
    }

    private void abrirPdf(String nomePdf) {

        NavVisualizarPdf fragment =
                NavVisualizarPdf.newInstance(nomePdf);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}