package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.adapter.TabelaAdapter;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;

public class IntroducaoFragment extends MyFragments {

    private TextView showNumber;

    public IntroducaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introducao, container, false);
        initViews(view);
        initVerify();

        mCarta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta01, numTxt1, mCarta1);
                setNumber();
            }
        });
        mCarta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta02, numTxt2, mCarta2);
                setNumber();
            }
        });
        mCarta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta04, numTxt4, mCarta4);
                setNumber();
            }
        });
        mCarta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta08, numTxt8, mCarta8);
                setNumber();
            }
        });
        mCarta16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                virarCarta(carta16, numTxt16, mCarta16);
                setNumber();
            }
        });
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked1(checkedId);
            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked2(checkedId);
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked3(checkedId);
            }
        });
        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    vibrar();
                    onCreateDialog("Algo deu errado", getString(R.string.texto_alert_sem_resposta),
                           1,getActivity());
                } else {
                    validarCampos();
                    gerenciarResultados(1, getActivity());
                }
            }
        });
        mDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog("Dicas", getString(R.string.dicas_intro), 1, getActivity());
            }
        });
        return view;
    }

    private void setNumber() {
        String binarios = numTxt16.getText().toString() + numTxt8.getText().toString()
                + numTxt4.getText().toString() + numTxt2.getText().toString() + numTxt1.getText().toString();
        TabelaAdapter tabelaAdapter = new TabelaAdapter();
        showNumber.setText("As cartas abaixo estão representando o número " + tabelaAdapter.obterNumeroDoBinario(binarios));
    }

    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!passou1) {
            focus = showError(perg1);
        }
        if (!passou2) {
            focus = showError(perg2);
        }
        if (!passou3) {
            focus = showError(perg3);
        }
        if (exibir) {
            vibrar();
            focus.requestFocus();
        }
        return exibir;
    }


    @Override
    protected boolean respostasIsEmpty() {
        boolean isEmpty;
        if (!checked1 || !checked2 || !checked3) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;

    }

    @Override
    protected void createCartas() {
        carta01 = new Carta(R.id.carta1, R.mipmap.carta1, 1, true);
        carta02 = new Carta(R.id.carta2, R.mipmap.carta2, 2, false);
        carta04 = new Carta(R.id.carta4, R.mipmap.carta4, 4, false);
        carta08 = new Carta(R.id.carta8, R.mipmap.carta8, 8, true);
        carta16 = new Carta(R.id.carta16, R.mipmap.carta16, 16, false);
    }

    @Override
    protected void initViews(View view) {
        showNumber = (TextView) view.findViewById(R.id.showNumber);
        initButtons(view);
        initCartas(view);
        initNum(view);
        createCartas();
        initRadioGroups(view);
        initPerguntas(view);
    }
}