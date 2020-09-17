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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

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


        String respConfirmaMais = confirmaMais.getSelectedItem().toString();

        if(respConfirmaMais.equals("Sim")){
            conteudoEscondido.setVisibility(View.VISIBLE);
        }else{
            conteudoEscondido.setVisibility(View.INVISIBLE);
        }
    }

}