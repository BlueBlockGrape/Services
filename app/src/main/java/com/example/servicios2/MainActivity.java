package com.example.servicios2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/


    ArrayList<cancionVo> listaCanciones;
    RecyclerView recyclerCancion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCanciones=new ArrayList<>();
        recyclerCancion=(RecyclerView)findViewById(R.id.recyclerId);
        recyclerCancion.setLayoutManager(new LinearLayoutManager(this));

        Bundle datos = getIntent().getExtras();
        int b;
        if(datos != null)
            b =datos.getInt("cancion");
        else
            b = 0;

        Toast.makeText(this,"Manejo"+b, Toast.LENGTH_SHORT).show();
        llenarCanciones(b);

        adapterDatos adapter=new adapterDatos(listaCanciones);
        adapter.setOnClikListener(new View.OnClickListener() {
            @Override
            public void onClick(View vg) {
                Toast.makeText(getApplicationContext(),
                        "seleccion: "+
                                listaCanciones.get(recyclerCancion.getChildAdapterPosition(vg)).getMusica(), Toast.LENGTH_SHORT).show();
               // String z = listaCanciones.get(recyclerCancion.getChildAdapterPosition(vg)).getNombre();
                Intent intent = new Intent(getApplicationContext(), reproductor.class);
                intent.putExtra("nombre", listaCanciones.get(recyclerCancion.getChildAdapterPosition(vg)).getNombre());
                intent.putExtra("numero", listaCanciones.get(recyclerCancion.getChildAdapterPosition(vg)).getMusica());
                intent.putExtra("bloquea",1);
                getApplicationContext().startActivity(intent);
            }
        });

        recyclerCancion.setAdapter(adapter);
    }


    private void llenarCanciones(int b) {

                listaCanciones.add(new cancionVo("Pista01", R.drawable.unos,0,1));
                listaCanciones.add(new cancionVo("Pista02", R.drawable.dos,0,2));
                listaCanciones.add(new cancionVo("Pista03", R.drawable.tres,0,3));
                listaCanciones.add(new cancionVo("Pista04", R.drawable.cuatro,0,4));
                listaCanciones.add(new cancionVo("Pista05", R.drawable.cinco,0,5));
                listaCanciones.add(new cancionVo("Pista06", R.drawable.seis,0,6));
                listaCanciones.add(new cancionVo("Pista07", R.drawable.siete,0,7));
                listaCanciones.add(new cancionVo("Pista08", R.drawable.ocho,0,8));
                listaCanciones.add(new cancionVo("Pista09", R.drawable.nueve,0,9));

    }


}
