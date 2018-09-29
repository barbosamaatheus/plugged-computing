package com.tcc.projeto.appcomputacaoplugada.adapter;

import android.app.ActionBar;

import com.tcc.projeto.appcomputacaoplugada.objetos.Tabela;

import java.util.ArrayList;
import java.util.List;

public class TabelaAdapter {
    private List<Tabela> tabela = new ArrayList<Tabela>();

    public List<Tabela> getTabela(){
        if (tabela.isEmpty()){
            gerarTabela();
        }
        return this.tabela;
    }

    private void gerarTabela() {
        tabela.add(new Tabela('a', 1, 00001));
        tabela.add(new Tabela('b', 2, 00010));
        tabela.add(new Tabela('c', 3, 00011));
        tabela.add(new Tabela('d', 4, 00100));
        tabela.add(new Tabela('e', 5, 00101));
        tabela.add(new Tabela('f', 6, 00110));
        tabela.add(new Tabela('g', 7, 00111));
        tabela.add(new Tabela('h', 8, 01000));
        tabela.add(new Tabela('i', 9, 01001));
        tabela.add(new Tabela('j', 10, 01010));
        tabela.add(new Tabela('k', 11, 01011));
        tabela.add(new Tabela('l', 12, 01100));
        tabela.add(new Tabela('m', 13, 01101));
        tabela.add(new Tabela('n', 14, 01110));
        tabela.add(new Tabela('o', 15, 01111));
        tabela.add(new Tabela('p', 16, 10000));
        tabela.add(new Tabela('q', 17, 10001));
        tabela.add(new Tabela('r', 18, 10010));
        tabela.add(new Tabela('s', 19, 10011));
        tabela.add(new Tabela('t', 20, 10100));
        tabela.add(new Tabela('u', 21, 10101));
        tabela.add(new Tabela('v', 22, 10110));
        tabela.add(new Tabela('w', 23, 10111));
        tabela.add(new Tabela('x', 24, 11000));
        tabela.add(new Tabela('y', 25, 11001));
        tabela.add(new Tabela('z', 26, 11010));

    }

}
