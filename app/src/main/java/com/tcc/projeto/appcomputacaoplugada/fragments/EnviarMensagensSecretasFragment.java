package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcc.projeto.appcomputacaoplugada.R;

public class EnviarMensagensSecretasFragment extends Fragment {

    public EnviarMensagensSecretasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_enviar_mensagens_secretas, container, false);




        return view;
    }

}