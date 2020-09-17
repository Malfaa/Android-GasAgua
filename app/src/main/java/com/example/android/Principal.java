package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {

    protected Spinner ep1, qtdp1,ep2, qtdp2,confirmaMais, formaDePag;
    protected LinearLayout conteudoEscondido;
    protected String ep1Var, confirmaMaisVar, ep2Var, formaDePagVar;
    protected static int valorT, qtdp1Var,qtdp2Var;
    protected static float trocoVar;
    protected EditText troco, number;
    protected Button enviarPedido;


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
        formaDePag = findViewById(R.id.formaDePaga);
        troco = findViewById(R.id.troco);
        number = findViewById(R.id.numero);


        conteudoEscondido.setVisibility(View.GONE);


        ArrayAdapter<CharSequence> adapterp = ArrayAdapter.createFromResource(this,
                R.array.produtos, android.R.layout.simple_spinner_item);
        ep1.setAdapter(adapterp);
        ep2.setAdapter(adapterp);


        ArrayAdapter<CharSequence> adapterqtdp = ArrayAdapter.createFromResource(this,
                R.array.quantidade, android.R.layout.simple_spinner_item);
        qtdp1.setAdapter(adapterqtdp);
        qtdp2.setAdapter(adapterqtdp);



        ArrayAdapter<CharSequence> adapterConfirmaMais = ArrayAdapter.createFromResource(this,
                R.array.confirmaMais, android.R.layout.simple_spinner_item);
        confirmaMais.setAdapter(adapterConfirmaMais);

        ArrayAdapter<CharSequence> adapterFormaDePag = ArrayAdapter.createFromResource(this,
                R.array.formaPagamento, android.R.layout.simple_spinner_item);
        formaDePag.setAdapter(adapterFormaDePag);


        //Variaveis objetos
        ep1Var = ep1.getSelectedItem().toString();

        qtdp1Var = Integer.parseInt(qtdp1.getSelectedItem().toString());

        confirmaMaisVar = confirmaMais.getSelectedItem().toString();

        ep2Var = ep2.getSelectedItem().toString();
        qtdp2Var =  Integer.parseInt(qtdp2.getSelectedItem().toString());

        formaDePagVar = formaDePag.getSelectedItem().toString();
        trocoVar = troco.getInputType();

        if(ep1Var.equals("Gás 13KG")){
            valorT += (85*qtdp1Var);
        }else{
            valorT += (10*qtdp1Var);
        }
        if(confirmaMaisVar.equals("Sim")){
            TransitionManager.beginDelayedTransition(conteudoEscondido);

            conteudoEscondido.setVisibility(View.VISIBLE);
        }else{
            assert true;
        }

        if(ep2Var.equals("Gás 13KG")){
            valorT += (85*qtdp2Var);
        }else{
            valorT += (10*qtdp2Var);
        }
        if (formaDePagVar.equals("Dinheiro")){
            troco.setVisibility(View.VISIBLE);
        }else{
            assert true;
        }

        enviarPedido = findViewById(R.id.enviarPedido);

        enviarPedido.setOnClickListener(v -> {
            String url = "https://api.whatsapp.com/send?phone="+number;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });


    }

}