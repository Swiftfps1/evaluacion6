package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtiene el resultado de los extras del Intent
        double resultado = getIntent().getDoubleExtra("resultado", 0.0);

        // Muestra el resultado en un TextView
        TextView txtResultado = findViewById(R.id.txtResultado);
        txtResultado.setText("Resultado: " + resultado);

        // Agrega un OnClickListener al botón "volver"
        Button btvolver = findViewById(R.id.btvolver);
        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un Intent para volver a la actividad "calcular"
                Intent intent = new Intent(Resultado.this, calcular.class);
                startActivity(intent);
            }
        });
    }
}
