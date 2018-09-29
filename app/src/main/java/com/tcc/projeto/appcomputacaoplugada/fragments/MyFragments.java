package com.tcc.projeto.appcomputacaoplugada.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.activitys.ExerciciosActivity;
import com.tcc.projeto.appcomputacaoplugada.aplication.MyApplication;
import com.tcc.projeto.appcomputacaoplugada.objetos.Carta;

/**
 * Created by matheus.barbosa on 25/09/2018.
 */

public abstract class MyFragments extends Fragment {
    protected EditText mNum1, mNum2, mNum3, mNum4, mNum5, mNum6, mNum7, mNum8, mNum9, mNum10, mNum11,
            mNum12, mNum13, mNum14, mNum15, mTextoTraduzido, mTextoNome;
    protected ImageButton mCarta1, mCarta2, mCarta4, mCarta8, mCarta16, mDicas;
    protected TextView numTxt1, numTxt2, numTxt4, numTxt8, numTxt16, perg1, perg2, perg3, mNumerosSelecionados;
    protected RadioGroup radioGroup1, radioGroup2, radioGroup3;
    protected RadioButton certo1, certo2, certo3, errado11, errado12, errado21, errado22, errado31, errado32;
    protected Carta carta01, carta02, carta04, carta08, carta16;
    protected Button mFinalizar;

    protected boolean checked1 = false;
    protected boolean checked3 = false;
    protected boolean checked2 = false;
    protected boolean passou1 = true;
    protected boolean passou2 = true;
    protected boolean passou3 = true;
    protected boolean exibir;

    protected String num1 = "";
    protected String num2 = "";
    protected String num3 = "";
    protected String num4 = "";
    protected String num5 = "";
    protected String num6 = "";
    protected String num7 = "";
    protected String num8 = "";
    protected String num9 = "";
    protected String num10 = "";
    protected String num11 = "";
    protected String num12 = "";
    protected String num13 = "";
    protected String num14 = "";
    protected String num15 = "";

    protected MyApplication myApplication;

    protected void initVerify() {
        if (!respostasIsEmpty()) {
            validarCampos();
        }
    }
    protected void gerenciarResultados(int position, Context context) {
        if (!exibir) {
            editarPositionExercicio(position, context);
            callNextFragment();
        } else {
            restartFragment();
        }

    }

    protected void editarPositionExercicio(int position, Context context) {
        myApplication = (MyApplication) context.getApplicationContext();
        if(myApplication.getPositionExercicio()<position){
            myApplication.setPositionExercicio(position);
        }

        //myApplication.updateDataBase();;
    }

    protected void restartFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    protected void onCreateDialog(String title, String mensagem, int icon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
        builder.setMessage(mensagem).setTitle(title).setIcon(icon);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void callNextFragment() {
        Intent intent = new Intent(getActivity().getApplicationContext(), ExerciciosActivity.class);
        startActivity(intent);
    }

    protected void virarCarta(Carta carta, TextView num, ImageButton mCarta) {
        if (carta.isFrente()) {
            carta.setFrente(false);
            carta.setImagem(R.mipmap.fundocarta);
            num.setText("0");
        } else {
            carta.setFrente(true);
            mudarImagem(carta);
            num.setText("1");
        }
        mCarta.setBackgroundResource(carta.getImagem());
    }

    protected void mudarImagem(Carta carta) {
        switch (carta.getNumero()) {
            case 1:
                carta.setImagem(R.mipmap.carta1);
                break;
            case 2:
                carta.setImagem(R.mipmap.carta2);
                break;
            case 4:
                carta.setImagem(R.mipmap.carta4);
                break;
            case 8:
                carta.setImagem(R.mipmap.carta8);
                break;
            case 16:
                carta.setImagem(R.mipmap.carta16);
                break;
        }
    }

    protected void onRadioButtonClicked1(int checked) {
        checked1 = true;
        passou1 = false;
        switch (checked) {
            case R.id.certo1:
                passou1 = true;
                break;
            case R.id.errado11:
                passou1 = false;
                break;
            case R.id.errado12:
                passou1 = false;
                break;
        }
    }

    protected void onRadioButtonClicked2(int checked) {
        checked2 = true;
        passou2 = false;
        switch (checked) {
            case R.id.certo2:
                passou2 = true;
                break;
            case R.id.errado21:
                passou2 = false;
                break;

            case R.id.errado22:
                passou2 = false;
                break;
        }
    }

    protected void onRadioButtonClicked3(int checked) {
        checked3 = true;
        passou3 = false;
        switch (checked) {
            case R.id.certo3:
                passou3 = true;
                break;
            case R.id.errado31:
                passou3 = false;
                break;
            case R.id.errado32:
                passou3 = false;
                break;
        }
    }

    protected String montarNumerosET() {
        return mNum1.getText().toString() + " " + mNum2.getText().toString() + " " + mNum3.getText().toString() + " "
                + mNum4.getText().toString() + " " + mNum5.getText().toString() + " - " + mNum6.getText().toString() + " "
                + mNum7.getText().toString() + " " + mNum8.getText().toString() + " "  + mNum9.getText().toString() + " "
                + mNum10.getText().toString() + " - " + mNum11.getText().toString() + " " + mNum12.getText().toString() + " "
                + mNum13.getText().toString() + " " + mNum14.getText().toString() + " " + mNum15.getText().toString();
    }

    protected void initViews(View view) {}

    protected void createCartas() {
        carta01 = new Carta(R.id.carta1, R.mipmap.carta1, 1, true);
        carta02 = new Carta(R.id.carta2, R.mipmap.carta2, 2, true);
        carta04 = new Carta(R.id.carta4, R.mipmap.carta4, 4, true);
        carta08 = new Carta(R.id.carta8, R.mipmap.carta8, 8, true);
        carta16 = new Carta(R.id.carta16, R.mipmap.carta16, 16, true);

    }

    protected abstract boolean respostasIsEmpty();

    protected abstract boolean validarCampos();


}
