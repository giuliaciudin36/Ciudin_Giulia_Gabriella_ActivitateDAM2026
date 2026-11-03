package com.example.exercitiusem4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class GeantaAdapter extends BaseAdapter {

    private List<Geanta> genti = null;
    private Context ctx;
    private int resursaLayout;

    public GeantaAdapter(List<Geanta> genti, Context ctx, int resursaLayout) {
        this.genti = genti;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return genti.size();
    }

    @Override
    public Object getItem(int i) {
        return genti.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView brand = v.findViewById(R.id.brand);
        TextView material = v.findViewById(R.id.material);
        TextView marime = v.findViewById(R.id.marime);
        Switch esteNoua = v.findViewById(R.id.este_noua);
        CheckBox garantie = v.findViewById(R.id.garantie);
        RatingBar ratingBar = v.findViewById(R.id.rating);

        Geanta geanta = (Geanta) getItem(i);


        brand.setText(geanta.getBrand());
        material.setText("Material: " + geanta.getMaterial());
        marime.setText("Mărime: " + geanta.getMarime());
        esteNoua.setChecked(geanta.isEsteNoua());
        garantie.setChecked(geanta.isAreGarantie());
        ratingBar.setRating(geanta.getRating());

        return v;
    }
}