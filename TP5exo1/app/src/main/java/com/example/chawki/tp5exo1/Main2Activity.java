package com.example.chawki.tp5exo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    private final int CONTEXT_MENU_MODE1 = 1;
    private final int CONTEXT_MENU_RESET = 3;
    private final int CONTEXT_MENU_QUITTER = 4;


    private EditText mValeurTemperature;
    private RadioButton mCtoF, mFtoC;
    private Button mConvertiseur, mMode;
    private TextView mResultat;


    private void init() {
        mValeurTemperature = findViewById(R.id.valeur_temperature_editText);
        mCtoF = findViewById(R.id.ctof_radionButton);
        mFtoC = findViewById(R.id.ftoc_radionButton);
        mConvertiseur = findViewById(R.id.convertir_button);
        mMode = findViewById(R.id.mode_button);
        mResultat = findViewById(R.id.resultat_textView);
        mConvertiseur.setEnabled(false);
        mCtoF.setChecked(true);
        mFtoC.setChecked(false);

        mCtoF.setText("DA to Euro");
        mFtoC.setText("Euro to DA");
        mMode.setText("Mode : convertion de monnais ");
        mValeurTemperature.setHint("saisir valeur monnais");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mValeurTemperature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mConvertiseur.setEnabled(s.length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mConvertiseur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float temp = Float.valueOf(mValeurTemperature.getText().toString());
                float resultat;
                if (mCtoF.isChecked())
                    resultat = temp / 200;
                else
                    resultat = temp * 200;
                mResultat.setText(String.valueOf(resultat));
            }
        });


        mMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerForContextMenu(v);
                openContextMenu(v);
            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Context Menu");
        menu.add(Menu.NONE, CONTEXT_MENU_RESET, Menu.NONE, "Reset value");
        menu.add(Menu.NONE, CONTEXT_MENU_MODE1, Menu.NONE, "Mode : convertion temperature");
        menu.add(Menu.NONE, CONTEXT_MENU_QUITTER, Menu.NONE, "Quitter");
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case CONTEXT_MENU_RESET:
                mValeurTemperature.setText("");
                Toast.makeText(this, "reset value", Toast.LENGTH_SHORT).show();
                break;

            case CONTEXT_MENU_MODE1:
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            case CONTEXT_MENU_QUITTER:
                finish();
                break;
        }
        return super.onContextItemSelected(item);
    }


}
