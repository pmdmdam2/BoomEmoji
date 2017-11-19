package edu.pmdm.boomemoji;

/**
 * Created by rafa on 18/11/17.
 */

public class Config {
    public static final int NIVEL_PRINCIPIANTE = 10;
    public static final int NIVEL_AMATEUR= 30;
    public static final int NIVEL_AVANZADO = 60;
    public static final int TABLERO_NIVEL_PRINCIPIANTE = 8;
    public static final int TABLERO_NIVEL_AMATEUR = 10;
    public static final int TABLERO_NIVEL_AVANZADO = 12;
    public static final int IMAGEN_SIN_PERSONAJE = android.R.drawable.progress_horizontal;
    public static final int IMAGEN1_NORMAL = android.R.drawable.presence_audio_away;
    public static final int IMAGEN2_AMATEUR= android.R.drawable.presence_video_away;
    public static final int IMAGEN3_AVANZADO_= android.R.drawable.presence_away;
    public static final int IMAGEN1_NORMAL_PIERDE = android.R.drawable.presence_audio_busy;
    public static final int IMAGEN2_AMATEUR_PIERDE= android.R.drawable.presence_video_busy;
    public static final int IMAGEN3_AVANZADO_PIERDE = android.R.drawable.presence_busy;

    //propiedades
    private int nivel = NIVEL_PRINCIPIANTE;
    private int nivelTablero =TABLERO_NIVEL_PRINCIPIANTE;
    private int imagen = IMAGEN_SIN_PERSONAJE;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivelTablero=this.nivel==NIVEL_PRINCIPIANTE?TABLERO_NIVEL_PRINCIPIANTE:this.nivel==NIVEL_AMATEUR?TABLERO_NIVEL_AMATEUR:TABLERO_NIVEL_AVANZADO;
        this.nivel = nivel;
    }

    public int getNivelTablero() {
        return nivelTablero;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
