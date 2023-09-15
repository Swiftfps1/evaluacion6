package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import com.example.evaluacion.Resultado;

public class calcular extends AppCompatActivity {
    private EditText editTextCV;
    private EditText editTextTH;
    private Button btcalcular;
    private Button btlimpiar; // Agrega el botón limpiar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        editTextCV = findViewById(R.id.txtcb);
        editTextTH = findViewById(R.id.txth);
        btcalcular = findViewById(R.id.btcalcular);
        btlimpiar = findViewById(R.id.btlimpiar); // Encuentra el botón limpiar

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cbText = editTextCV.getText().toString();
                String thText = editTextTH.getText().toString();

                if (!TextUtils.isEmpty(cbText) && !TextUtils.isEmpty(thText)) {
                    try {
                        double cb = Double.parseDouble(cbText);
                        double th = Double.parseDouble(thText);
                        double resultado = cb * th;

                        Intent intent = new Intent(calcular.this, Resultado.class);
                        // Pasa el resultado como un extra en el Intent
                        intent.putExtra("resultado", resultado);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese valores en ambos campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Agrega un OnClickListener para el botón limpiar
        btlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextCV.setText(""); // Limpia el campo cb
                editTextTH.setText(""); // Limpia el campo th
            }
        });
    }
}
