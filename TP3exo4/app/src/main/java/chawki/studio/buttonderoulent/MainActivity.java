package chawki.studio.buttonderoulent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.RadioButton;

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // cle pour le contexe menu
    private final int CONTEXT_MENU_NBPOMME = 1;
    private final int CONTEXT_MENU_NBPOIRE = 2;


    private RadioButton mPommeRadio, mPoireRadio;
    private TextView mValeurPomme, mValeurPoire;
    private Button mCalculer;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPommeRadio = findViewById(R.id.radioPomme);
        mPoireRadio = findViewById(R.id.radioPoire);
        mCalculer = findViewById(R.id.btnCompter);
        mValeurPoire = findViewById(R.id.valeurPoire);
        mValeurPomme = findViewById(R.id.valeurPomme);


        //action click simple
        mCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPommeRadio.isChecked()) {
                    int valeur = Integer.valueOf(mValeurPomme.getText().toString());
                    valeur++;
                    mValeurPomme.setText(String.valueOf(valeur));
                } else {
                    int valeur = Integer.valueOf(mValeurPoire.getText().toString());
                    valeur++;
                    mValeurPoire.setText(String.valueOf(valeur));
                }
            }
        });


        //action long click
        mCalculer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                registerForContextMenu(mCalculer);
                openContextMenu(mCalculer);
                return true;
            }
        });
    }


    //creation du menu contexe
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Context menu
        menu.setHeaderTitle("My Context Menu");
        menu.add(Menu.NONE, CONTEXT_MENU_NBPOMME, Menu.NONE, "le nombre de pomme");
        menu.add(Menu.NONE, CONTEXT_MENU_NBPOIRE, Menu.NONE, "le nombre de poire");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    //action item dans le contexe menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case CONTEXT_MENU_NBPOMME:
                Toast.makeText(this, "le nombre de pomme " + mValeurPomme.getText(), Toast.LENGTH_SHORT).show();
                break;
            case CONTEXT_MENU_NBPOIRE:
                Toast.makeText(this, "le nombre de poire " + mValeurPoire.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //action item dans la bare menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nb_Poire:
                Toast.makeText(this, mValeurPoire.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.nb_Pomme:
                Toast.makeText(this, mValeurPomme.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.nb_quiter:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
