package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;


public class TrabalharComNumerosBinariosFragment extends MyFragments {

    public TrabalharComNumerosBinariosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabalhar_com_numeros_binarios, container, false);
        initViews(view);
        initVerify();

        mFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respostasIsEmpty()) {
                    onCreateDialog();
                } else {
                    validarCampos();
                    gerenciarResultados(3, getActivity());
                }
            }
        });
        return view;
    }



    @Override
    protected boolean validarCampos() {
        View focus = null;
        exibir = false;
        if (!num1.equalsIgnoreCase("9")) {
            mNum1.setError("Resposta incorreta");
            focus = mNum1;
            exibir = true;
        }
        if (!num2.equalsIgnoreCase("10")) {
            mNum2.setError("Resposta incorreta");
            focus = mNum2;
            exibir = true;
        }
        if (!num3.equalsIgnoreCase("5")) {
            mNum3.setError("Resposta incorreta");
            focus = mNum3;
            exibir = true;
        }
        if (!num4.equalsIgnoreCase("11")) {
            mNum4.setError("Resposta incorreta");
            focus = mNum4;
            exibir = true;
        }
        if (!num5.equalsIgnoreCase("0")) {
            mNum5.setError("Resposta incorreta");
            focus = mNum5;
            exibir = true;
        }

        if (!num6.equalsIgnoreCase("17")) {
            mNum6.setError("Resposta incorreta");
            focus = mNum6;
            exibir = true;
        }
        if (!num7.equalsIgnoreCase("2")) {
            mNum7.setError("Resposta incorreta");
            focus = mNum7;
            exibir = true;
        }
        if (!num8.equalsIgnoreCase("20")) {
            mNum8.setError("Resposta incorreta");
            focus = mNum8;
            exibir = true;
        }
        if (!num9.equalsIgnoreCase("0")) {
            mNum9.setError("Resposta incorreta");
            focus = mNum9;
            exibir = true;
        }
        if (!num10.equalsIgnoreCase("31")) {
            mNum10.setError("Resposta incorreta");
            focus = mNum10;
            exibir = true;
        }
        if (exibir) {
            focus.requestFocus();
        }
        return exibir;
    }

    @Override
    protected boolean respostasIsEmpty() {
        validarClicked();
        boolean isEmpty;
        if (!checked1) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    private void validarClicked() {
        if (mNum1.getText().toString().isEmpty() || mNum2.getText().toString().isEmpty() || mNum3.getText().toString().isEmpty() ||
                mNum4.getText().toString().isEmpty() || mNum5.getText().toString().isEmpty() || mNum6.getText().toString().isEmpty() ||
                mNum7.getText().toString().isEmpty() || mNum8.getText().toString().isEmpty() || mNum9.getText().toString().isEmpty() ||
                mNum10.getText().toString().isEmpty()) {
            checked1 = false;
        } else {
            getTextDoEditText();
            checked1 = true;
        }
        if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty() ||
                num4.isEmpty() || num5.isEmpty() || num6.isEmpty() ||
                num7.isEmpty() || num8.isEmpty() || num9.isEmpty() ||
                num10.isEmpty()) {
            checked1 = false;
        } else {
            checked1 = true;
        }
    }

    private void getTextDoEditText() {
        num1 = mNum1.getText().toString();
        num2 = mNum2.getText().toString();
        num3 = mNum3.getText().toString();
        num4 = mNum4.getText().toString();
        num5 = mNum5.getText().toString();
        num6 = mNum6.getText().toString();
        num7 = mNum7.getText().toString();
        num8 = mNum8.getText().toString();
        num9 = mNum9.getText().toString();
        num10 = mNum10.getText().toString();
    }

    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
        builder.setMessage(R.string.texto_alert_sem_resposta).setTitle("Algo deu errado :(");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void initViews(View view) {
        initEditText(view);
        mFinalizar = (Button) view.findViewById(R.id.btn_finalizar_tnb);

    }

    private void initEditText(View view) {
        mNum1 = (EditText) view.findViewById(R.id.num1TNB);
        mNum2 = (EditText) view.findViewById(R.id.num2TNB);
        mNum3 = (EditText) view.findViewById(R.id.num3TNB);
        mNum4 = (EditText) view.findViewById(R.id.num4TNB);
        mNum5 = (EditText) view.findViewById(R.id.num5TNB);

        mNum6 = (EditText) view.findViewById(R.id.num6TNB);
        mNum7 = (EditText) view.findViewById(R.id.num7TNB);
        mNum8 = (EditText) view.findViewById(R.id.num8TNB);
        mNum9 = (EditText) view.findViewById(R.id.num9TNB);
        mNum10 = (EditText) view.findViewById(R.id.num10TNB);
    }

    @Override
    protected void createCartas() {
    }

}
