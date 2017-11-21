package edu.pmdm.boomemoji;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout.LayoutParams;
import android.widget.GridView;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by rafa on 17/11/17.
 */

public class LauncherActivity extends Activity {
    private Config config;
    private GridView gv;
    private View vwMain,vwL8, vwL10,vwL12;
    private ArrayAdapter<AppCompatButton> adapter;
    private ArrayList itemsToSave;
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
                    gv = (GridView) findViewById(R.id.gv8);

                    break;
                case Config.NIVEL_AMATEUR:
                    vwL10.setVisibility(View.VISIBLE);
                    vwL10.bringToFront();
                    gv = (GridView) findViewById(R.id.gv10);

                    break;
                case Config.NIVEL_AVANZADO:
                    vwL12.setVisibility(View.VISIBLE);
                    vwL12.bringToFront();
                    gv = (GridView) findViewById(R.id.gv12);

                    break;
            }
            adapter = new ArrayAdapter<AppCompatButton>(this,R.layout.ui_item,juego.getTableroView());
//            itemsToSave = new ArrayList();
//            itemsToSave.add(0,adapter);
//            itemsToSave.add(1,gv);
            gv.setAdapter(adapter);

        }else{
            //TODO: mostrar error genérico, no se ha podido crear el tablero
        }
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putParcelableArrayList("savedInstances", itemsToSave);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        itemsToSave = (ArrayList)savedInstanceState.get("savedInstances");
//        adapter = (GridAdapter)itemsToSave.get(0);
//        gv = (GridView)itemsToSave.get(1);
//        gv.setAdapter(adapter);
//    }
}
