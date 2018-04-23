package chawki.studio.exo7;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText mValeur1, mValeur2, mValeur3;
    private Button mCalculer;
    private float mNumber1, mNumber2, mNumber3, mMoyenne;
    private TextView mNbAdmis, mNbAjourne;


    //cle pour envoyer la moyenne aux autres activity
    public static final String BUNDLE_EXTRA_MOYENNE = "BUNDLE_EXTRA_MOYENNE";

    //code request de chaque activity pour connaitre l activity qui a retourne un resultat
    private static final int REUSSITE_ACTIVITY_REQUEST_CODE = 40;
    private static final int RECALE_ACTIVITY_REQUEST_CODE = 41;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getDataValue()) {

                    mMoyenne = (mNumber1 + mNumber2 + mNumber3) / 3;

                    Intent intent;

                    if (mMoyenne >= 10) {
                        intent = new Intent(MainActivity.this, ReussiteActivity.class);
                        intent.putExtra(BUNDLE_EXTRA_MOYENNE, mMoyenne);
                        startActivityForResult(intent, REUSSITE_ACTIVITY_REQUEST_CODE);
                    } else {
                        intent = new Intent(MainActivity.this, RecaleActivity.class);
                        intent.putExtra(BUNDLE_EXTRA_MOYENNE, mMoyenne);
                        startActivityForResult(intent, RECALE_ACTIVITY_REQUEST_CODE);

                    }


                }

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int compteur;


        if (resultCode == RESULT_OK) {

            //test quelle qest l'activity qui a retourné un resultat
            switch (requestCode) {
                case REUSSITE_ACTIVITY_REQUEST_CODE:
                    compteur = Integer.valueOf(mNbAdmis.getText().toString());
                    compteur++;
                    mNbAdmis.setText(String.valueOf(compteur));
                    break;

                case RECALE_ACTIVITY_REQUEST_CODE:
                    compteur = Integer.valueOf(mNbAjourne.getText().toString());
                    compteur++;
                    mNbAjourne.setText(String.valueOf(compteur));
                    break;
            }
        }
    }

    private void init() {
        mValeur1 = findViewById(R.id.valeur1);
        mValeur2 = findViewById(R.id.valeur2);
        mValeur3 = findViewById(R.id.valeur3);
        mCalculer = findViewById(R.id.btnCalculer);
        mNbAdmis = findViewById(R.id.nbAdmis);
        mNbAjourne = findViewById(R.id.nbAjourne);
    }


    private boolean getDataValue() {

        if (!mValeur1.getText().toString().isEmpty() && !mValeur2.getText().toString().isEmpty() && !mValeur3.getText().toString().isEmpty()) {

            mNumber1 = Float.valueOf(mValeur1.getText().toString());
            mNumber2 = Float.valueOf(mValeur2.getText().toString());
            mNumber3 = Float.valueOf(mValeur3.getText().toString());
            return true;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Erreur !")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setMessage("Un champ de saisi est vide")
                    .create()
                    .show();
            return false;
        }

    }
}
