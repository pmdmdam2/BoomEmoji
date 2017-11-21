package edu.pmdm.boomemoji;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by rafa on 17/11/17.
 */

public final class Juego {
    private Context context;
    private Config config;
    private ArrayList<Personaje> tablero;

    public Juego(Context context,Config config) {
        this.config = config;
        this.context = context;
        tablero = new ArrayList<Personaje>();
    }
    public boolean prepararTablero(){
        int indice;
        Random rnd = null;
        Set<Integer> uniqueNumbers = new HashSet<>();

        try {
            //para añadir una imagen que no corresponde al personaje del juego
            for(int i = 0; i<Math.pow(config.getNivelTablero(),2);i++)
                tablero.add(posicionarPersonaje(i,Config.IMAGEN_SIN_PERSONAJE));

            rnd = new Random();

            //generar posiciones aleatorias en el tablero para posicionar a los personajes
            while (uniqueNumbers.size() < config.getNivel())
                uniqueNumbers.add(rnd.nextInt((int)Math.pow(config.getNivelTablero(),2.0)));

            //para posicionar personajes
            for (int i = 0; i < config.getNivel(); i++) {
                indice = (int) uniqueNumbers.toArray()[i];

                ((Personaje)tablero.get(indice)).setTag(config.getImagen());
            }
            calcularAdyacentes();
        }catch (Exception e){
            e.printStackTrace();
            return false; 
        }
        return true;
    }
    private Personaje posicionarPersonaje(int indice, int imagen){
        Personaje personaje;
        int fila;
        if(indice<config.getNivelTablero()) {
            personaje = new Personaje(context,indice,0,indice,imagen);
        }
        else{
            fila = (int) ((indice / config.getNivelTablero()));
            personaje = new Personaje(context,fila,indice - (fila*config.getNivelTablero()),indice,imagen);
        }
        return personaje;
    }
    private void calcularAdyacentes(){
        ArrayList<Personaje> adyacentes;
        Personaje personajeAdayacente;

        for(Personaje personaje:tablero) {
            adyacentes = new ArrayList<Personaje>();
            if (personaje.getFila() > 0) {
                personajeAdayacente = getPersonajePosicion(personaje.getFila() - 1, personaje.getColumna());
                if (Integer.valueOf(personajeAdayacente.getTag().toString()) != Config.IMAGEN_SIN_PERSONAJE)
                    adyacentes.add(personajeAdayacente);

                if (personaje.getFila() < config.getNivelTablero() - 1) {
                    personajeAdayacente = getPersonajePosicion(personaje.getFila() + 1, personaje.getColumna());
                    if (Integer.valueOf(personajeAdayacente.getTag().toString()) != Config.IMAGEN_SIN_PERSONAJE)
                        adyacentes.add(personajeAdayacente);
                }
            } else {
                //primera fila
                personajeAdayacente = getPersonajePosicion(personaje.getFila() + 1, personaje.getColumna());
                if (Integer.valueOf(personajeAdayacente.getTag().toString()) != Config.IMAGEN_SIN_PERSONAJE)
                    adyacentes.add(personajeAdayacente);
            }

            if (personaje.getFila() > 0) {
                personajeAdayacente = getPersonajePosicion(personaje.getFila(), personaje.getColumna() - 1);
                if (Integer.valueOf(personajeAdayacente.getTag().toString()) != Config.IMAGEN_SIN_PERSONAJE)
                    adyacentes.add(personajeAdayacente);

                if (personaje.getFila() < config.getNivelTablero() - 1) {
                    personajeAdayacente = getPersonajePosicion(personaje.getFila(), personaje.getColumna() + 1);
                    if (Integer.valueOf(personajeAdayacente.getTag().toString()) != Config.IMAGEN_SIN_PERSONAJE)
                        adyacentes.add(personajeAdayacente);
                }
            } else {
                //primera columna
                personajeAdayacente = getPersonajePosicion(personaje.getFila(), personaje.getColumna() + 1);
                if (Integer.valueOf(personajeAdayacente.getTag().toString()) != Config.IMAGEN_SIN_PERSONAJE)
                    adyacentes.add(personajeAdayacente);
            }
            personaje.setAdyacentes(adyacentes);
        }
    }
    private Personaje getPersonajePosicion(int fila, int columna){
        return tablero.get(fila * config.getNivelTablero() + columna);
    }

    public ArrayList<Personaje> getTablero(){
        return tablero;
    }
    public ArrayList<AppCompatButton> getTableroView(){
        ArrayList<AppCompatButton> tablero = new ArrayList<AppCompatButton>();
        for (Personaje personaje:this.tablero) {
            tablero.add((AppCompatButton)personaje);
        }
        return tablero;
    }
}
