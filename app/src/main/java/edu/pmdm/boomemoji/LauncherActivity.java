package edu.pmdm.boomemoji;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import java.util.zip.Inflater;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by rafa on 17/11/17.
 */

public class LauncherActivity extends Activity {
    private Config config;
    private GridLayout gl;
    private View vwMain,vwL8, vwL10,vwL12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutParams default_layout_params = new LayoutParams();
        default_layout_params.width = MATCH_PARENT;
        default_layout_params.height = MATCH_PARENT;

        //vista predeterminada de la APP
        vwMain = getLayoutInflater().inflate(R.layout.ui_main,null);
        vwMain.setVisibility(View.VISIBLE);
        addContentView(vwMain,default_layout_params);

        //se añaden las vistas adicionales para cada nivel de juego
        vwL8 = getLayoutInflater().inflate(R.layout.ui_launcher_8,null);
        vwL8.setVisibility(View.INVISIBLE);

        addContentView(vwL8,default_layout_params);

        vwL10 = getLayoutInflater().inflate(R.layout.ui_launcher_10,null);
        vwL10.setVisibility(View.INVISIBLE);
        addContentView(vwL10,default_layout_params);

        vwL12 = getLayoutInflater().inflate(R.layout.ui_launcher_12,null);
        vwL12.setVisibility(View.INVISIBLE);
        addContentView(vwL12,default_layout_params);

        config = new Config();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuNivel1:
                config.setNivel(Config.NIVEL_PRINCIPIANTE);
                //TODO: detener juego, avisar al jugador
                nuevoJuego();
                break;
            case R.id.mnuNivel2:
                config.setNivel(Config.NIVEL_AMATEUR);
                //TODO: detener juego, avisar al jugador
                nuevoJuego();
                break;
            case R.id.mnuNivel3:
                config.setNivel(Config.NIVEL_AVANZADO);
                //TODO: detener juego, avisar al jugador
                nuevoJuego();
                break;
            case R.id.mnuImagen1:
                config.setImagen(android.R.drawable.presence_audio_away);
                break;
            case R.id.mnuImagen2:
                config.setImagen(android.R.drawable.presence_video_away);
                break;
            case R.id.mnuImagen3:
                config.setImagen(android.R.drawable.presence_away);
                break;
            case R.id.mnuInstrucciones:
                //TODO: mostrar cuadro de diálogo con la información del juego
                break;
            case R.id.mnuNuevo:
                nuevoJuego();

                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
    private void nuevoJuego(){
        Juego juego = new Juego(this,config);
        vwMain.setVisibility(View.INVISIBLE);
        vwL8.setVisibility(View.INVISIBLE);
        vwL10.setVisibility(View.INVISIBLE);
        vwL12.setVisibility(View.INVISIBLE);
        if(juego.prepararTablero()) {
            int nivel = config.getNivel();
            switch (nivel) {
                case Config.NIVEL_PRINCIPIANTE:
                    vwL8.setVisibility(View.VISIBLE);
                    vwL8.bringToFront();
                    gl = (GridLayout) findViewById(R.id.gl8);
//                    gl.setColumnCount(Config.TABLERO_NIVEL_PRINCIPIANTE);
//                    gl.setRowCount(Config.TABLERO_NIVEL_PRINCIPIANTE);
                    break;
                case Config.NIVEL_AMATEUR:
                    vwL10.setVisibility(View.VISIBLE);
                    vwL10.bringToFront();
                    gl = (GridLayout) findViewById(R.id.gl10);
                    gl.setColumnCount(Config.TABLERO_NIVEL_AMATEUR);
                    gl.setRowCount(Config.TABLERO_NIVEL_AMATEUR);
                    break;
                case Config.TABLERO_NIVEL_AVANZADO:
                    vwL12.setVisibility(View.VISIBLE);
                    vwL12.bringToFront();
                    gl = (GridLayout) findViewById(R.id.gl12);
                    gl.setColumnCount(Config.TABLERO_NIVEL_AVANZADO);
                    gl.setRowCount(Config.TABLERO_NIVEL_AVANZADO);
                    break;
            }

            for (Personaje personaje : juego.getTablero()) {
                GridLayout.LayoutParams param =new GridLayout.LayoutParams();

                param.setGravity(Gravity.TOP);
                param.width = WRAP_CONTENT;
                param.height = WRAP_CONTENT;
//                param.columnSpec = GridLayout.spec(personaje.getColumna());
//                param.rowSpec = GridLayout.spec(personaje.getFila());

                personaje.setLayoutParams(param);

                gl.addView(personaje);
            }

        }else{
            //TODO: mostrar error genérico, no se ha podido crear el tablero
        }
    }
}
