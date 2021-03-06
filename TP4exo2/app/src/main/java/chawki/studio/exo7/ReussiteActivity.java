package chawki.studio.exo7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReussiteActivity extends AppCompatActivity {


    private TextView mMoyenne;
    private Button mBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussite);

        mMoyenne = findViewById(R.id.moyenneReussite);
        mBack = findViewById(R.id.back_btn_reussite);


        Intent intent = getIntent();
        if (intent != null)
            mMoyenne.setText(String.valueOf(intent.getFloatExtra(MainActivity.BUNDLE_EXTRA_MOYENNE, 0)));


        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
