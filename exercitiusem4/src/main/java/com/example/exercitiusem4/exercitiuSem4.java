package com.example.exercitiusem4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class exercitiuSem4 extends AppCompatActivity {
    private EditText etBrand;
    private Switch swNoua;
    private CheckBox cbGarantie;
    private RadioButton rbMare;
    private RadioButton rbMica;
    private Spinner spMaterial;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cerinta5cuai_exercitiu_sem4);

        etBrand = findViewById(R.id.brand);
        swNoua = findViewById(R.id.este_noua);
        cbGarantie = findViewById(R.id.garantie);
        rbMare = findViewById(R.id.marimeMare);
        rbMica = findViewById(R.id.marimeMica);
        spMaterial = findViewById(R.id.material);
        ratingBar = findViewById(R.id.rating);
    }

    public void creeazaGeanta(View view) {
        String brandIntrodus = etBrand.getText().toString();
        boolean esteGeantaNoua = swNoua.isChecked();
        boolean areGarantieBifata = cbGarantie.isChecked();

        String marimeAleasa = "Nespecificat";
        if (rbMare.isChecked()) {
            marimeAleasa = "Mare";
        } else if (rbMica.isChecked()) {
            marimeAleasa = "Mică";
        }

        String materialAles = spMaterial.getSelectedItem().toString();
        float numarStele = ratingBar.getRating();

        Geanta geantaNoua = new Geanta(brandIntrodus, esteGeantaNoua, areGarantieBifata, marimeAleasa, materialAles, numarStele);

        Intent intentReturnare = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("GEANTA_MEA", geantaNoua);

        intentReturnare.putExtras(bundle);

        setResult(RESULT_OK, intentReturnare);

        finish();
    }
}

