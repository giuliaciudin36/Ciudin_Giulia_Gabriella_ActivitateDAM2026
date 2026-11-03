package com.example.exercitiusem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeschideFormular extends AppCompatActivity {

    private ArrayList<Geanta> listaGenti = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deschide_formular);
    }

    public void mergiLaFormular(View view) {
        Intent intent = new Intent(this, exercitiuSem4.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            Geanta geantaPrimita = data.getParcelableExtra("GEANTA_MEA");

            if (geantaPrimita != null) {
                listaGenti.add(geantaPrimita);

                Toast.makeText(this, "A ajuns la prima activitate:\n" +
                        geantaPrimita.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void veziListaGenti(View view) {
        Intent intent = new Intent(this, ActivityListView.class);
        intent.putParcelableArrayListExtra("listaGenti", listaGenti);
        startActivity(intent);
    }
}