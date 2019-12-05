package es.jdamiancabello.toolbarpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sustituye la toolbar por la toolbar del diseño
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mainmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = new String();

        switch (item.getItemId()){
            case R.id.menu_add:
                msg = "add option";
                break;
            case R.id.menu_edit:
                msg = "edit option";
                break;
            case R.id.menu_settings:
                showSettings();
                msg = "settings option";
                break;
            case R.id.menu_aboutus:
                msg = "about us option";
                break;
        }
        Toast.makeText(this,"Selected " + msg,Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    /**
     * Este método carga la ventana de preferencias generales
     */
    private void showSettings(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content, new SettingsFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
