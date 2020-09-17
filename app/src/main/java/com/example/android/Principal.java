package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {

    protected Spinner ep1, qtdp1,ep2, qtdp2,confirmaMais;
    protected LinearLayout conteudoEscondido;
    protected String ep1Var, confirmaMaisVar,ep2Var;
    protected static int valorT, qtdp1Var,qtdp2Var;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Spinner e variaveis de "reconhecimento"
        ep1 = findViewById(R.id.EP1);
        qtdp1 = findViewById(R.id.QTDP1);
        confirmaMais = findViewById(R.id.confirmMais);
        ep2 = findViewById(R.id.EP2);
        qtdp2 = findViewById(R.id.QTDP2);
        conteudoEscondido = findViewById(R.id.conteudoDois);

        conteudoEscondido.setVisibility(View.INVISIBLE);


        ArrayAdapter<CharSequence> adapterp1 = ArrayAdapter.createFromResource(this,
                R.array.produtos, android.R.layout.simple_spinner_item);
        ep1.setAdapter(adapterp1);


        ArrayAdapter<CharSequence> adapterqtdp1 = ArrayAdapter.createFromResource(this,
                R.array.quantidade, android.R.layout.simple_spinner_item);
        qtdp1.setAdapter(adapterqtdp1);


        ArrayAdapter<CharSequence> adapterConfirmaMais = ArrayAdapter.createFromResource(this,
                R.array.confirmaMais, android.R.layout.simple_spinner_item);
        confirmaMais.setAdapter(adapterConfirmaMais);


        //Variaveis objetos
        ep1Var = ep1.getSelectedItem().toString();
        qtdp1Var = Integer.parseInt(String.valueOf(qtdp1));

        confirmaMaisVar = confirmaMais.getSelectedItem().toString();

        ep2Var = ep2.getSelectedItem().toString();
        qtdp2Var = Integer.parseInt(String.valueOf(qtdp2));


        if(ep1Var.equals("Gás 13KG")){
            valorT += (85*qtdp1Var);
        }else{
            valorT += (10*qtdp1Var);
        }
        if(confirmaMaisVar.equals("Sim")){
            conteudoEscondido.setVisibility(View.VISIBLE);
        }else{
            assert true;
        }

        if(ep2Var.equals("Gás 13KG")){
            valorT += (85*qtdp2Var);
        }else{
            valorT += (10*qtdp2Var);
        }


    }

}