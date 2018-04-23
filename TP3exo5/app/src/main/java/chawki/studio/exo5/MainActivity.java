package chawki.studio.exo5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    // cle pour les elements du contexe menu
    private final int CONTEXT_MENU_RESET = 1;
    private final int CONTEXT_MENU_QUITTER = 2;

    private Button mBtn1, mBtn10, mBtn100;
    private TextView mCompteurValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBtn1 = findViewById(R.id.btn1);
        mBtn10 = findViewById(R.id.btn10);
        mBtn100 = findViewById(R.id.btn100);
        mCompteurValue = findViewById(R.id.compteurValeur);

        mBtn1.setOnClickListener(this);
        mBtn10.setOnClickListener(this);
        mBtn100.setOnClickListener(this);


        mBtn1.setOnLongClickListener(this);
        mBtn10.setOnLongClickListener(this);
        mBtn100.setOnLongClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int val = Integer.valueOf(mCompteurValue.getText().toString());
        switch (view.getId()) {
            case R.id.btn1:
                val = val + 1;
                break;
            case R.id.btn10:
                val = val + 10;
                break;
            case R.id.btn100:
                val = val + 100;
                break;
        }
        mCompteurValue.setText(String.valueOf(val));
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {

            case R.id.btn1:
                registerForContextMenu(mBtn1);
                openContextMenu(mBtn1);
                break;
            case R.id.btn10:
                registerForContextMenu(mBtn10);
                openContextMenu(mBtn10);
                break;
            case R.id.btn100:
                registerForContextMenu(mBtn100);
                openContextMenu(mBtn100);
                break;
        }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Context Menu");
        menu.add(Menu.NONE, CONTEXT_MENU_RESET, Menu.NONE, "Reset value");
        menu.add(Menu.NONE, CONTEXT_MENU_QUITTER, Menu.NONE, "Quitter");
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case CONTEXT_MENU_RESET:
                mCompteurValue.setText("0");
                Toast.makeText(this, "reset value", Toast.LENGTH_SHORT).show();
                break;

            case CONTEXT_MENU_QUITTER:
                finish();
        }
        return super.onContextItemSelected(item);
    }
}
