package edu.pmdm.controlesi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Toast;

/**
 * Created by rafa on 13/11/17.
 */

public class ChecBoxTActivity extends Activity implements View.OnKeyListener {
    private CheckedTextView checked;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checktext_layout);
        checked = (CheckedTextView)findViewById(R.id.checkedTextView);
        checked.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        Toast.makeText(this,keyEvent.getKeyCharacterMap().toString(),Toast.LENGTH_SHORT).show();
        return false;
    }
}
