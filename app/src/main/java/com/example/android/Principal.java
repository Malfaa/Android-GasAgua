package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {

    protected Spinner ep1, qtdp1;
    protected int qtd1;
    //protected String p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ep1 = findViewById(R.id.EP1);
        qtdp1 = findViewById(R.id.QTDP1);


        ArrayAdapter<CharSequence> adapterp1 = ArrayAdapter.createFromResource(this,
                R.array.produtos, android.R.layout.simple_spinner_item);
        ep1.setAdapter(adapterp1);

        ArrayAdapter<CharSequence> adapterqtdp1 = ArrayAdapter.createFromResource(this,
                R.array.quantidade, android.R.layout.simple_spinner_item);

        //testando
        qtdp1.setAdapter(adapterqtdp1);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String p1 = parent.getItemAtPosition(position).toString();
    }


}