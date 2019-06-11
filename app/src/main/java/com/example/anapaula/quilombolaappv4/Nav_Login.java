package com.example.anapaula.quilombolaappv4;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.example.anapaula.quilombolaappv4.R.id.fab;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nav_Login extends Fragment
{


    public Nav_Login()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav__login, container, false);
    }


}