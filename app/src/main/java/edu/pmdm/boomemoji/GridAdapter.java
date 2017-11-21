package edu.pmdm.boomemoji;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by rafa on 20/11/17.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Personaje> tablero;
    public GridAdapter(Context context, ArrayList<Personaje> tablero){
        this.context = context;
        this.tablero = tablero;
    }
    @Override
    public int getCount() {
        return tablero.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AppCompatImageButton button=null;
        View gview = new View(this.context);
        if(view==null){
            gview = ((Activity)this.context).getLayoutInflater().inflate(R.layout.ui_item,null);
            button = (AppCompatImageButton)gview.findViewById(R.id.acButton);
            button.setBackgroundResource(tablero.get(i).getImagen());
            button.setTag(tablero.get(i).getTag());
        }else{
            return view;
        }
        return view;
    }
}
