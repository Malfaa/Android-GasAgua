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



public class Principal extends AppCompatActivity {

    protected Spinner ep1, qtdp1,ep2, qtdp2,confirmaMais, formaDePag;
    protected LinearLayout conteudoEscondido;
    protected String  confirmaMaisVar,ep1Var,ep2Var;
    protected static int valorT, valorP1, valorP2;
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

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            confirmaMaisVar = confirmaMais.getSelectedItem().toString();
            ep1Var = ep1.getSelectedItem().toString();
            ep2Var = ep2.getSelectedItem().toString();

            if (ep1Var.equals("Gás 13KG")) {
                valorP1 = 85 *Integer.parseInt(qtdp1.getSelectedItem().toString());
            } else {
                valorP1 = 10 * Integer.parseInt(qtdp1.getSelectedItem().toString());}

            if (confirmaMaisVar.equals("Sim")) {
                conteudoEscondido.setVisibility(View.VISIBLE);
            }else {
                conteudoEscondido.setVisibility(View.GONE);

            }if (ep2Var.equals("Gás 13KG") && confirmaMaisVar.equals("Sim")) {
                valorP2 = (85 * Integer.parseInt(qtdp2.getSelectedItem().toString()));
            } else if (ep2Var.equals("Água 20L")&&confirmaMaisVar.equals("Sim")){
                valorP2 = (10 * Integer.parseInt(qtdp2.getSelectedItem().toString()));
            }else{
                valorP2 = 0;
            }
            if (parent.getItemAtPosition(position).equals("Dinheiro")) {
                troco.setVisibility(View.VISIBLE);
            } else {
                troco.setVisibility(View.GONE);
            }
            valorT= valorP1+valorP2;
            compraValorFinal.setText(String.valueOf(valorT));
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            compraValorFinal.setText(String.valueOf(valorT));
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

            enviarPedido.setOnClickListener(v -> {
                if(confirmaMaisVar.equals("Sim")){
                    String url = "https://api.whatsapp.com/send?phone=" + celularNumero.getText() + "&text=---NOVO%20PEDIDO---%20%0A%0ACliente%3A%20" + nome.getText()+"%0A%0AEndereco%3A%20"+
                            endereco.getText()+"%0A%0AQuantidade%2F%20Produto%3A%20%0A"+qtdp1.getSelectedItem()+
                            " "+ep1.getSelectedItem()+"%20%0A"+qtdp2.getSelectedItem()+" "+ep2.getSelectedItem()+"%0A%20%0AForma%20De%20Pagamento%3A%20"+
                            formaDePag.getSelectedItem()+"%0ATroco:%20"+troco.getText()+"%20%0AValor%20Total%3A%20R$%20"+valorT+"%0A%0A %20%0A FIM%20DO%20PEDIDO%0A";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                }else{
                    String url = "https://api.whatsapp.com/send?phone=" + celularNumero.getText() + "&text=---NOVO%20PEDIDO---%20%0A%0ACliente%3A%20" + nome.getText()+"%0A%0AEndereco%3A%20"+
                            endereco.getText()+"%0A%0AQuantidade%2F%20Produto%3A%20%0A"+qtdp1.getSelectedItem()+
                            " "+ep1.getSelectedItem()+"%20%0A%0AForma%20De%20Pagamento%3A%20"+
                            formaDePag.getSelectedItem()+"%0ATroco:%20"+troco.getText()+"%20%0AValor%20Total%3A%20R$%20"+valorT+"%0A%0A %20%0A FIM%20DO%20PEDIDO%0A";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        }
}