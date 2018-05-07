package com.example.chawki.tp5exo2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ListView mList;
    static MonAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = findViewById(R.id.maList);

        ArrayList<Personne> personneArrayList = new ArrayList<>();

        initList(personneArrayList);

        sAdapter = new MonAdapter(this, R.layout.detail_personne, personneArrayList);

        mList.setAdapter(sAdapter);


    }


    private void initList(ArrayList<Personne> list) {

        Personne personne1 = new Personne("chawki1", "fonction1");
        Personne personne2 = new Personne("chawki2", "fonction2");
        Personne personne3 = new Personne("chawki3", "fonction3");
        Personne personne4 = new Personne("chawki4", "fonction4");
        Personne personne5 = new Personne("chawki5", "fonction5");
        Personne personne6 = new Personne("chawki6", "fonction6");
        Personne personne7 = new Personne("chawki7", "fonction7");


        list.add(personne1);
        list.add(personne2);
        list.add(personne3);
        list.add(personne4);
        list.add(personne5);
        list.add(personne6);
        list.add(personne7);


    }
}
