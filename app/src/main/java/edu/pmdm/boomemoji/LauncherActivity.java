package edu.pmdm.boomemoji;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.zip.Inflater;

/**
 * Created by rafa on 17/11/17.
 */

public class LauncherActivity extends Activity {
    private Config config;
    private GridLayout gl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
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
                config.setImagen(android.R.drawable.presence_audio_away);
                break;
            case R.id.mnuNivel2:
                config.setImagen(android.R.drawable.presence_video_away);
                break;
            case R.id.mnuNivel3:
                config.setImagen(android.R.drawable.presence_away);
                break;
            case R.id.mnuEmojis:
                break;
            case R.id.mnuInstrucciones:
                break;
            case R.id.mnuNuevo:
                Juego juego = new Juego(this,config);
                if(juego.prepararTablero()) {
                    int nivel = config.getNivel();

                    switch (nivel) {
                        case Config.NIVEL_PRINCIPIANTE:
                            setContentView(R.layout.ui_launcher_8);
                            gl = (GridLayout) findViewById(R.id.gl8);
                            break;
                        case Config.NIVEL_AMATEUR:
                            setContentView(R.layout.ui_launcher_10);
                            gl = (GridLayout) findViewById(R.id.gl10);
                            break;
                        case Config.TABLERO_NIVEL_AVANZADO:
                            setContentView(R.layout.ui_launcher_12);
                            gl = (GridLayout) findViewById(R.id.gl12);
                            break;
                    }

                    for (Personaje personaje : juego.getTablero())
                        gl.addView((View) personaje);
                }else{
                    //Mostrar error genérico, no se ha podido crear el tablero
                }

                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}
