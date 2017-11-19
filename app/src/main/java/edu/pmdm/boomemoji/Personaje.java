package edu.pmdm.boomemoji;

import android.content.Context;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by rafa on 17/11/17.
 */

public class Personaje extends android.support.v7.widget.AppCompatButton {
    private int indice,imagen;
    private Posicion posicion;
    private ArrayList<Personaje> adyacentes;

    public Personaje(Context context) {
        super(context);
    }

    public Personaje(Context context,int fila, int columna, int indice, int imagen){
        this(context);
        this.indice = indice;
        if(imagen != Config.IMAGEN_SIN_PERSONAJE)
            this.setTag(imagen);
        this.setBackgroundResource(Config.IMAGEN_SIN_PERSONAJE);
        this.imagen = imagen;
        this.posicion = new Posicion(fila,columna);
    }

    public int getImagen(){ return this.imagen; }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.indice = indice;
    }

    public int getColumna() {
        return posicion.getColumna();
    }

    public int getFila() {
        return posicion.getFila();
    }

    public void setAdyacentes(ArrayList<Personaje> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public ArrayList<Personaje> getAdyacentes() {
        return adyacentes;
    }
}
