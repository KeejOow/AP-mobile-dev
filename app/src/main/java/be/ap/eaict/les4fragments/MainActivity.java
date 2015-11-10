package be.ap.eaict.les4fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListFragment.OnListItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Initialise with a reasonable value
        DetailFragment detailFrag = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if (detailFrag != null) {
            // We are on a big screen with the detail fragment there, so just update the fragment
            detailFrag.setNumber(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemSelected(int value) {
        DetailFragment detailFrag = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);

        if (detailFrag != null) {
            // We are on a big screen with the detail fragment there, so just update the fragment
            detailFrag.setNumber(value);
        } else {
            // We are on a small screen --> start new activity
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra("number", value);
            startActivity(i);
        }
    }
}
