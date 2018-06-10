package com.example.leilafeiguin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button btnNextSecond;
    private final int EDAD_MAXIMA = 60;
    private final int EDAD_MINIMA = 16;
    private RadioButton radioSaludo;
    private RadioButton radioDespedida;
    public final static int SALUDO = 0;
    public final static int DESPEDIDA = 1;
    private SeekBar seekBarAge;
    private int edad = 18;
    private TextView txtEdad;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Flecha para atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            nombre = bundle.getString("nombre");
        }

        txtEdad = (TextView) findViewById(R.id.txtEdad);
        btnNextSecond = (Button) findViewById(R.id.btnNextSecond);
        radioSaludo = (RadioButton) findViewById(R.id.radioSaludo);
        seekBarAge = (SeekBar) findViewById(R.id.seekBarAge);
        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                edad = i;
                txtEdad.setText(edad + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                edad = seekBar.getProgress();
                txtEdad.setText(edad + "");

                if(edad > EDAD_MAXIMA){
                    btnNextSecond.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "La edad maxima es 60.", Toast.LENGTH_SHORT).show();
                }else if(edad < EDAD_MINIMA){
                    btnNextSecond.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "La edad minima es 16.", Toast.LENGTH_SHORT).show();
                }else{
                    btnNextSecond.setVisibility(View.VISIBLE);
                }
            }
        });


        btnNextSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int opcion;
                if(radioSaludo.isChecked()){
                    opcion = SALUDO;
                }else{
                    opcion = DESPEDIDA;
                }
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("opcion", opcion);
                intent.putExtra("edad", edad);
                startActivity(intent);
            }
        });

    }
}
