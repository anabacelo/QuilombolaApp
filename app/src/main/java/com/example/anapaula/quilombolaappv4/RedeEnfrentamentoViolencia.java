package com.example.anapaula.quilombolaappv4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RedeEnfrentamentoViolencia extends Fragment
{
    public RedeEnfrentamentoViolencia(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.layout_rede_enfrentamento_violencia, container, false);
    }
}
