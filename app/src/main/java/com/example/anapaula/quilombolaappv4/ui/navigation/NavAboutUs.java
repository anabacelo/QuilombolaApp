package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anapaula.quilombolaappv4.R;


/**
 * A simple {@link Fragment} subclass.
 */

public class NavAboutUs extends Fragment {
    public NavAboutUs() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navaboutus, container, false);
    }
}
