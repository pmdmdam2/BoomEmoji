package edu.pmdm.boomemoji;

import android.content.Context;
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
    private ArrayList<Personaje> adyacentes;

    public Juego(Context context,Config config) {
        this.config = config;
        this.context = context;
        tablero = new ArrayList<Personaje>();
    }
    public boolean prepararTablero(){
        int indice,fila,columna;
        Random rnd = null;
        Set<Integer> uniqueNumbers = new HashSet<>();

        try {
            //para añadir una imagen que no corresponde al personaje del juego
            for(int i = 0; i<(config.getNivelTablero()^2);i++)
                tablero.add(posicionarPersonaje(i,android.R.drawable.progress_horizontal));

            //generar posiciones aleatorias en el tablero para posicionar a los personajes
            while (uniqueNumbers.size() < config.getNivel()) {
                uniqueNumbers.add(rnd.nextInt(config.getNivelTablero()^2));
            }

            //para posicionar personajes
            for (int i = 0; i < config.getNivel(); i++) {
                indice = (int) uniqueNumbers.toArray()[i];

                tablero.add(indice,posicionarPersonaje(indice,config.getImagen()));
            }

        }catch (Exception e){
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
            personaje = new Personaje(context,indice,fila,indice - (fila*config.getNivelTablero()),imagen);
        }
        calcularAdyacentes(personaje.getFila(),personaje.getColumna());
        return personaje;
    }
    private void calcularAdyacentes(int fila, int columna){
        ArrayList<Personaje> adyacentes = new ArrayList<Personaje>();
        Personaje personajeConAdyacentes;

        for (Personaje personaje : tablero) {

                if ((personaje.getColumna() == columna && Math.abs(personaje.getFila() - fila) <= 1) ||
                        (personaje.getFila() == fila && (Math.abs(personaje.getColumna() - fila) <= 1) ||
                                (Math.abs(personaje.getFila() - fila) == 1 && (Math.abs(personaje.getColumna() - fila) <= 1)))
                        && personaje.getImagen()!=Config.IMAGEN_SIN_PERSONAJE)
                    adyacentes.add(personaje);

        }
        if(fila<config.getNivelTablero() && columna<config.getNivelTablero())
            calcularAdyacentes(++columna,++fila);

        personajeConAdyacentes = getPersonajePosicion(fila, columna);
        personajeConAdyacentes.setAdyacentes(adyacentes);
    }
    private Personaje getPersonajePosicion(int fila, int columna){
        return tablero.get(fila * config.getNivelTablero() + columna);
    }

    public ArrayList<Personaje> getTablero(){
        return tablero;
    }
}
