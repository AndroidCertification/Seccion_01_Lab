package com.example.leilafeiguin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private String nombre;
    private int opcion;
    private int edad;
    private String mensaje;
    private ImageButton imgConfirm;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //Flecha para atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            nombre = bundle.getString("nombre");
            opcion = bundle.getInt("opcion");
            edad = bundle.getInt("edad");
        }

        if(opcion == SecondActivity.SALUDO){
            mensaje = "Hola " + nombre + ", ¿Cómo llevas esos " + edad + " años? #MyForm";
        }else{
            mensaje = "Espero verte pronto " + nombre + ", antes que cumplas " + (edad + 1) + ".. #MyForm";
        }

        imgConfirm = (ImageButton) findViewById(R.id.imgConfirm);
        btnShare = (Button) findViewById(R.id.btnShare);
        imgConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgConfirm.setVisibility(View.INVISIBLE);
                Toast.makeText(ThirdActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                btnShare.setVisibility(View.VISIBLE);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                startActivity(intent);
            }
        });

    }
}
