package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.fragments.EnviarMensagensSecretasFragment;
import com.tcc.projeto.appcomputacaoplugada.fragments.IntroducaoFragment;
import com.tcc.projeto.appcomputacaoplugada.fragments.NumerosBinariosFragment;
import com.tcc.projeto.appcomputacaoplugada.fragments.TrabalharComNumerosBinariosFragment;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class TarefaActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        getDadosBundle();
    }

    private void getDadosBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int position = bundle.getInt("positon");
        initFragment(position);
    }

    private void initFragment(int position) {
        switch (position) {
            case 1:
                initFragment1();
                break;
            case 2:
                initFragment2();
                break;
            case 3:
                initFragment3();
                break;
            case 4:
                initFragment4();
                break;
            case 5:
                initFragment5();
                break;
            case 6:
                initFragment6();
                break;
            case 7:
                initFragment7();
                break;
            case 8:
                initFragment8();
                break;
        }

    }

    private void initFragment1() {
        FragmentTransaction ft = fm.beginTransaction();
        IntroducaoFragment introducaoFragment = new IntroducaoFragment();
        ft.add(R.id.fragment_content, introducaoFragment);
        ft.commit();
    }

    private void initFragment2() {
        FragmentTransaction ft = fm.beginTransaction();
        NumerosBinariosFragment numerosBinariosFragment = new NumerosBinariosFragment();
        ft.add(R.id.fragment_content, numerosBinariosFragment);
        ft.commit();
    }

    private void initFragment3() {
        FragmentTransaction ft = fm.beginTransaction();
        TrabalharComNumerosBinariosFragment trabalharComNumerosBinariosFragment = new TrabalharComNumerosBinariosFragment();
        ft.add(R.id.fragment_content, trabalharComNumerosBinariosFragment);
        ft.commit();
    }

    private void initFragment4() {
        FragmentTransaction ft = fm.beginTransaction();
        EnviarMensagensSecretasFragment enviarMensagensSecretasFragment = new EnviarMensagensSecretasFragment();
        ft.add(R.id.fragment_content, enviarMensagensSecretasFragment);
        ft.commit();
    }

    private void initFragment5() {
        Toast.makeText(getApplicationContext(), "Fragment5", Toast.LENGTH_LONG).show();
    }

    private void initFragment6() {
        Toast.makeText(getApplicationContext(), "Fragment6", Toast.LENGTH_LONG).show();
    }

    private void initFragment7() {
        Toast.makeText(getApplicationContext(), "Fragment7", Toast.LENGTH_LONG).show();
    }

    private void initFragment8() {
        Toast.makeText(getApplicationContext(), "Fragment8", Toast.LENGTH_LONG).show();
    }

}
