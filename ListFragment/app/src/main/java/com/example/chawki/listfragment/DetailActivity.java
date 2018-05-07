package com.example.chawki.listfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String VALUE = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_port);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String s = extras.getString(VALUE);
            TextView view = findViewById(R.id.detailsText);
            view.setText(s);
        }
    }
}
