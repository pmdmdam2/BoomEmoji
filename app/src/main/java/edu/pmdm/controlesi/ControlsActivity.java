package edu.pmdm.controlesi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ControlsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Intent intent= null;
        switch (item.getItemId()){
            case R.id.imButton:
                intent = new Intent(this,ButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.imCheck:
                intent = new Intent(this,CheckBoxActivity.class);
                startActivity(intent);
                break;
            case R.id.imCheckText:
                intent = new Intent(this,ChecBoxTActivity.class);
                startActivity(intent);
                break;
            case R.id.imProgressBar:
                intent = new Intent(this,ProgressbarActivity.class);
                startActivity(intent);
                break;
            case R.id.imProgressBarH:
                intent = new Intent(this,ChecBoxTActivity.class);
                startActivity(intent);
                break;
            case R.id.imRadioButton:
                intent = new Intent(this,ChecBoxTActivity.class);
                startActivity(intent);
                break;
            case R.id.imRatingBar:
                break;
            case R.id.imSeekBar:
                break;
            case R.id.imSpinner:
                break;
            case R.id.imSwitch:
                break;
            case R.id.imTextView:
                break;
        }
        return true;
    }
}
