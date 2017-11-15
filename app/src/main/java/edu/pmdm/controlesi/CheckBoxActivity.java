package edu.pmdm.controlesi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by rafa on 13/11/17.
 */

public class CheckBoxActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_layout);
        ((CheckBox)findViewById(R.id.checkBox)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       if (((CheckBox)view).isChecked())
            Toast.makeText(this,"Has activado la opción",Toast.LENGTH_SHORT).show();
        else
           Toast.makeText(this,"Has desactivado la opción", Toast.LENGTH_SHORT).show();

    }
}
