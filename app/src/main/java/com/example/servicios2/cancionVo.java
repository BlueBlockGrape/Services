package com.example.servicios2;

public class cancionVo {

    private String nombre;
    //private String info;
    private int foto;
    private int param;
    private int musica;

    public cancionVo(){

    }

    public cancionVo(String nombre, int foto, int param, int musica) {
        this.nombre = nombre;
        this.foto = foto;
        this.param = param;
        this.musica = musica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    public int getMusica() {
        return musica;
    }

    public void setMusica(int musica) {
        this.musica = musica;
    }


}
