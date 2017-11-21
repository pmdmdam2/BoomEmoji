package edu.pmdm.boomemoji;

/**
 * Created by rafa on 19/11/17.
 */

public class Posicion {
    private int fila;
    private int columna;
    public Posicion(int fila,int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
