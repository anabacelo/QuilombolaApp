package com.example.anapaula.quilombolaappv4;

import android.content.Intent;
import android.net.Uri;
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
        return inflater.inflate(R.layout.layout_servico_enfrentamento_violencia, container, false);
    }

    public void linkMeuExemplo(View view)
    {
        Intent meuLink = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(meuLink);
    }
}
