package com.example.leilafeiguin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnNextMain;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnNextMain = (Button) findViewById(R.id.btnNextMain);

        btnNextMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = txtNombre.getText().toString();
                if(nombre == null || nombre.isEmpty()){
                    Toast.makeText(MainActivity.this, "Debe completar el nombre.", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                }
            }
        });

    }
}
