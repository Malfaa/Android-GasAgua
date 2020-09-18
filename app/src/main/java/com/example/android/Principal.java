package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class Principal extends AppCompatActivity {

    protected Spinner ep1, qtdp1,ep2, qtdp2,confirmaMais, formaDePag;
    protected LinearLayout conteudoEscondido;
    protected String ep1Var, confirmaMaisVar, ep2Var, formaDePagVar;
    protected static int valorT , qtdp1Var,qtdp2Var;
    protected static float trocoVar;
    protected EditText troco, celularNumero, nome, endereco;
    protected Button enviarPedido;
    protected TextView compraValorFinal;

    private void variablesIdSpinner(){
        ep1 = findViewById(R.id.EP1);
        qtdp1 = findViewById(R.id.QTDP1);
        confirmaMais = findViewById(R.id.confirmMais);
        ep2 = findViewById(R.id.EP2);
        qtdp2 = findViewById(R.id.QTDP2);
        conteudoEscondido = findViewById(R.id.conteudoDois);
        formaDePag = findViewById(R.id.formaDePaga);
        troco = findViewById(R.id.troco);
        nome = findViewById(R.id.NOME);
        endereco = findViewById(R.id.ENDERECO);
        celularNumero = findViewById(R.id.numero);
        compraValorFinal = findViewById(R.id.totalValorVar);
        enviarPedido = findViewById(R.id.enviarPedido);
    }

    private void arrayAdapterSpinner(){
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

    }

    class listenerDoSpinner implements AdapterView.OnItemSelectedListener {
        protected int valorT;

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //Variaveis objetos
            ep1Var = ep1.getSelectedItem().toString();
            qtdp1Var = Integer.parseInt(qtdp1.getSelectedItem().toString());

            confirmaMaisVar = confirmaMais.getSelectedItem().toString();

            ep2Var = ep2.getSelectedItem().toString();
            qtdp2Var = Integer.parseInt(qtdp2.getSelectedItem().toString());

            formaDePagVar = formaDePag.getSelectedItem().toString();
            trocoVar = troco.getInputType();


            if (ep1Var.equals("Gás 13KG")) {
                valorT += (85 * qtdp1Var);
            } else {
                valorT += (10 * qtdp1Var);
            }
            if (confirmaMaisVar.equals("Sim")) {
                conteudoEscondido.setVisibility(View.VISIBLE);
            } else {
                conteudoEscondido.setVisibility(View.GONE);
            }

            if (ep2Var.equals("Gás 13KG")) {
                valorT += (85 * qtdp2Var);
            } else {
                valorT += (10 * qtdp2Var);
            }
            if (formaDePagVar.equals("Dinheiro")) {
                troco.setVisibility(View.VISIBLE);
            } else {
                troco.setVisibility(View.GONE);
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private void setandoListenerSpinner(){
        ep1.setOnItemSelectedListener(new listenerDoSpinner());
        qtdp1.setOnItemSelectedListener(new listenerDoSpinner());
        qtdp2.setOnItemSelectedListener(new listenerDoSpinner());
        ep2.setOnItemSelectedListener(new listenerDoSpinner());
        formaDePag.setOnItemSelectedListener(new listenerDoSpinner());
        confirmaMais.setOnItemSelectedListener(new listenerDoSpinner());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principal);


            variablesIdSpinner();

            conteudoEscondido.setVisibility(View.GONE);

            arrayAdapterSpinner();

            setandoListenerSpinner();


            nome.getText();
            endereco.getText();
            troco.getText();
            celularNumero.getText();

            //compraValorFinal.append("R$ " +valorT + ".00");
            compraValorFinal.setText("R$ ");
            compraValorFinal.append(""+valorT);
            compraValorFinal.getText();


            enviarPedido.setOnClickListener(v -> {
                String url = "https://api.whatsapp.com/send?phone=" + celularNumero;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            });
        }
}//https://api.whatsapp.com/send?phone=0&text=----%20NOVO%20PEDIDO%20----%0A%0A CLIENTE%3A%20a%0A%0A ENDEREÇO%3A%20b%0A%0A QTD%20/%20PRODUTO%3A%0A0%20Água 20L%0A 0%20%0A%0A FORMA%20DE%20PAGAMENTO%3A%20Cartão%20%0A VALOR%20TOTAL%3A%20R$ 0.00%0A%0A %20%0A FIM%20DO%20PEDIDO%0A