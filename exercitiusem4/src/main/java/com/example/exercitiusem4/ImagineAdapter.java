package com.example.exercitiusem4;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {

    private List<ImaginiDomeniu> genti = null;   // MODIFICAT: era List<Geanta>
    private Context ctx;
    private int resursaLayout;

    public ImagineAdapter(List<ImaginiDomeniu> genti, Context ctx, int resursaLayout) {   // MODIFICAT: era List<Geanta>
        this.genti = genti;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return genti.size();
    }

    @Override
    public Object getItem(int position) {
        return genti.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        ImageView imagine = v.findViewById(R.id.imagineIV);
        TextView textView = v.findViewById(R.id.text_imagine);

        ImaginiDomeniu img = (ImaginiDomeniu) getItem(position);
        textView.setText(img.getTextAfisat());

        if(img.getImagine()!= null)
        {
            imagine.setImageBitmap(img.getImagine());
        }
        else
        {
            imagine.setImageResource(android.R.drawable.ic_menu_gallery);
        }

        return v;
    }
}