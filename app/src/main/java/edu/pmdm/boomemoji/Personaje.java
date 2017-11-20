package edu.pmdm.boomemoji;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by rafa on 17/11/17.
 */

public class Personaje extends android.support.v7.widget.AppCompatButton {
    private int indice,imagen;
    private Posicion posicion;
    private ArrayList<Personaje> adyacentes = new ArrayList<Personaje>();

    public Personaje(Context context) {
        super(context);
    }

    public Personaje(Context context,int fila, int columna, int indice, int imagen){
        this(context);
        this.indice = indice;
        this.setTag(Config.IMAGEN_SIN_PERSONAJE);
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

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
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

    public int getIndice(){ return this.indice; }
}
