package com.example.servicios2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterDatos extends RecyclerView.Adapter<adapterDatos.ViewHolderDatos>
        implements View.OnClickListener{

    ArrayList<cancionVo> listaCanciones;

    private View.OnClickListener onclic;

    String nombre;
    int cancion;
    int param;
    int pos;

    public adapterDatos(ArrayList<cancionVo> listaCanciones) {

        this.listaCanciones = listaCanciones;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cancion,null, false);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        nombre = listaCanciones.get(position).getNombre();
        cancion = listaCanciones.get(position).getMusica();
        param = listaCanciones.get(position).getParam();
        pos = position;
        holder.etiNombre.setText(listaCanciones.get(position).getNombre());
        //  holder.etiInformacion.setText(listaCanciones.get(position).getInfo());
        holder.foto.setImageResource(listaCanciones.get(position).getFoto());

      /*  if(listaCanciones.get(position).getParam() == 1) {
            holder.btnplay.setEnabled(false);
        }


        //acciones de botones del recyclerView

        holder.setOnClickListener();
        //holder.btnplay.setOnClickListener(this);
        // holder.btnstop.setOnClickListener(this);*/



    }

    @Override
    public int getItemCount() {

        return listaCanciones.size();
    }


    public void setOnClikListener(View.OnClickListener listener){
        this.onclic=listener;
    }

    @Override
    public void onClick(View v) {

        if(onclic!=null){
            onclic.onClick(v);
        }


    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView etiNombre,etiInformacion;
        ImageView foto;

        //context
        Context context;

        //botones
     //   Button btnplay;
       // Button btnstop;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            etiNombre = (TextView) itemView.findViewById(R.id.idNombre);
            //  etiInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
           // btnplay=(Button) itemView.findViewById(R.id.btn_iniciar);
            //btnstop=(Button) itemView.findViewById(R.id.btn_stop);
        }


        @Override
        public void onClick(View vie) {
           /* switch (vie.getId()){
                case R.id.btn_iniciar:
                    // listaCanciones.set(1, listaCanciones.get(1)).setParam(1);
                    Intent intent = new Intent(context, reproductor.class);
                    param = 1;
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("param", param);
                    intent.putExtra("cancion", cancion);
                    context.startActivity(intent);
                    Toast.makeText(context,"se inicio", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.btn_stop:
                    if(param == 1) {
                        context.stopService(new Intent(context, MyService.class));
                    }
                    Toast.makeText(context,"se paro", Toast.LENGTH_SHORT).show();
                    break;*/
            }
        }
    }



