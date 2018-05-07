package com.example.chawki.tp5exo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MonAdapter extends ArrayAdapter<Personne> {


    private Context context;
    private int idLayout;
    private List<Personne> maListe;


    public MonAdapter(@NonNull Context context, int resource, @NonNull List<Personne> objects) {
        super(context, resource, objects);
        this.context = context;
        this.idLayout = resource;
        this.maListe = objects;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert vi != null;
            v = vi.inflate(idLayout, parent, false);
        }

        Personne p = maListe.get(position);

        TextView nom = v.findViewById(R.id.tvNom);
        nom.setText(p.getNom());

        TextView fonction = v.findViewById(R.id.tvFonction);
        fonction.setText(p.getFonction());

        ImageButton haut = v.findViewById(R.id.btnHaut);
        haut.setTag(position);

        ImageButton bas = v.findViewById(R.id.btnBas);
        bas.setTag(position);


        haut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = (Integer) v.getTag();
                if (a > 0) {
                    Personne personne = maListe.get(a);
                    maListe.remove(a);
                    maListe.add(a - 1, personne);
                    MainActivity.sAdapter.notifyDataSetChanged();
                    MainActivity.mList.setAdapter(MainActivity.sAdapter);
                    Toast.makeText(context, " Vous avez deplacer en haut l'élément " + v.getTag(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        bas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = (Integer) v.getTag();
                if (a+1 < maListe.size()) {
                    Personne personne = maListe.get(a);
                    maListe.remove(a);
                    maListe.add(a + 1, personne);
                    MainActivity.sAdapter.notifyDataSetChanged();
                    MainActivity.mList.setAdapter(MainActivity.sAdapter);
                    Toast.makeText(context, " Vous avez deplacer en bas l'élément " + v.getTag(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;
    }


}
