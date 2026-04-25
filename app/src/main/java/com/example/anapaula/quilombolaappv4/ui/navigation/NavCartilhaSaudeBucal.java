package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.anapaula.quilombolaappv4.R;

public class NavCartilhaSaudeBucal extends Fragment {

    public NavCartilhaSaudeBucal() {
        // obrigatório
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.layout_cartilha_saude_bucal, container, false);
    }
}
