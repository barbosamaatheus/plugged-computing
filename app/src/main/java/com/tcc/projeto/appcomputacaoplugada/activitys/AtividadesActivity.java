package com.tcc.projeto.appcomputacaoplugada.activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.tcc.projeto.appcomputacaoplugada.objetos.Atividade;
import com.tcc.projeto.appcomputacaoplugada.adapter.CardAdapter;
import com.tcc.projeto.appcomputacaoplugada.R;
import com.tcc.projeto.appcomputacaoplugada.RecyclerViewOnClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class AtividadesActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividades);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        initviews();
    }

    private void initviews(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_atividades);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CardAdapter(this, getAtividadesList());
        mAdapter.setRecyclerViewOnClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<Atividade> getAtividadesList() {
        List<Atividade> atividadesList = new ArrayList<Atividade>();
        atividadesList.add(criarAtiviade());
        return atividadesList;
    }

    @NonNull
    private Atividade criarAtiviade() {
        Atividade tarefa01 = new Atividade();
        tarefa01.setTitulo("Contando os Pontos");
        tarefa01.setSubTitulo("Números Binários");
        tarefa01.setDescricao(getString(R.string.descricao_card));
        tarefa01.setMaterias("Matematica");
        tarefa01.setHabilidades("Contar, Correlacionar, Ordenar");
        tarefa01.setIdade("A partir de 7 anos");
        return tarefa01;
    }

    @Override
    public void onClickListener(View view, int positon) {
        switch(positon +1){
            case 1:
                Intent intent = new Intent(getApplicationContext(), ExerciciosActivity.class);
                startActivity(intent);
                break;
        }

    }
}
