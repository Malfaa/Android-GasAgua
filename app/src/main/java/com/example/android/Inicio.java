package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button fazerPedido = findViewById(R.id.fazerPedido);

        fazerPedido.setOnClickListener(v -> {
            Intent intent = new Intent(this, Principal.class);

            startActivity(intent);
        });

    }
}