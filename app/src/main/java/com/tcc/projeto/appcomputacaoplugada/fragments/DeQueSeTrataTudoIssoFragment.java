package com.tcc.projeto.appcomputacaoplugada.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.tcc.projeto.appcomputacaoplugada.R;
public class DeQueSeTrataTudoIssoFragment extends MyFragments {
    private Button mFormulario;
    private String textoTraduzido = "";

    public DeQueSeTrataTudoIssoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_de_que_se_trata_tudo_isso, container, false);
        initViews(view);
        initVerify();

        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog("Dicas", getString(R.string.dicas_tti), R.drawable.ic_help_outline_black_24dp);
            }
        });

        mFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "https://goo.gl/forms/J1mmJ4A0MRFQihvC3";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta), R.drawable.ic_error_outline_black_24dp);
                } else {
                    validarCampos();
                    gerenciarResultados(8, getActivity());
                }
            }
        });

        return view;
    }

    @Override
    protected void initViews(View view) {
        textInputLayout1 = (TextInputLayout) view.findViewById(R.id.textInputLayoutTTI);
        mTextoTraduzido = (TextInputEditText) view.findViewById(R.id.textoTraduzidoTTI);
        mFormulario = (Button) view.findViewById(R.id.formulario);
        initButtons(view);
    }

    @Override
    protected boolean respostasIsEmpty() {
        validarClicked1();
        boolean isEmpty;
        if (!checked1) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }
    private void validarClicked1() {
        if (mTextoTraduzido.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            textoTraduzido = mTextoTraduzido.getText().toString();
            checked1 = true;
        }
        if (textoTraduzido.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }
    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!validarTexto(textoTraduzido)) {
            focus = showError(mTextoTraduzido);
        }
        if (exibir) {
            vibrar();
            focus.requestFocus();
        }
        return exibir;
    }

    private boolean validarTexto(String textoTraduzido) {
        if (textoTraduzido.equalsIgnoreCase("77096")){
            return true;
        }
        return false;
    }
}
