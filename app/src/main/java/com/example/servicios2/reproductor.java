package com.example.servicios2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class reproductor extends AppCompatActivity {

    String nombre;
    int cancion;
    int numero;

    Button btn1;

    Context ctx;

    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        tv1 = (TextView) findViewById(R.id.tv_nombre);
        btn1 = (Button) findViewById(R.id.button);

        nombre = getIntent().getStringExtra("nombre");
        numero = getIntent().getIntExtra("numero", 1);


        Bundle extras = getIntent().getExtras(); if(extras !=null) {
            nombre = extras.getString("nombre");
            numero = extras.getInt("numero");
            int bloquear = extras.getInt("bloquea");
            if(bloquear!=1){
                btn1.setEnabled(false);
            }
            Toast.makeText(this,""+bloquear, Toast.LENGTH_SHORT).show();
        }

        tv1.setText(nombre);


        ctx=this;

        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                stopService(new Intent(ctx, MyService.class));
                btn1.setEnabled(true);
            }
        });

        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                stopService(new Intent(ctx, MyService.class));
                Intent intent = new Intent(ctx, MainActivity.class);
                ctx.startActivity(intent);
                btn1.setEnabled(true);
            }
        });
    }


    public void play(View view){
        Intent intent = new Intent(this, MyService.class);
        int param = 1;
        intent.putExtra("nombre", nombre);
        intent.putExtra("param", param);
        intent.putExtra("numero", numero);
        this.startService(intent);
        Toast.makeText(this,"se inicio", Toast.LENGTH_SHORT).show();
        btn1.setEnabled(false);
    }

}
