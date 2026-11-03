package com.example.exercitiusem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class exercitiuSem4 extends AppCompatActivity {
    private EditText etBrand;
    private Switch swNoua;
    private CheckBox cbGarantie;
    private RadioButton rbMare;
    private RadioButton rbMica;
    private Spinner spMaterial;
    private RatingBar ratingBar;

    private Geanta geantaEdit = null;

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

        Intent it = getIntent();
        if (it.hasExtra("geanta")) {
            geantaEdit = it.getParcelableExtra("geanta");

            if (geantaEdit != null) {
                etBrand.setText(geantaEdit.getBrand());
                swNoua.setChecked(geantaEdit.isEsteNoua());
                cbGarantie.setChecked(geantaEdit.isAreGarantie());

                if (geantaEdit.getMarime().equals("Mare")) {
                    rbMare.setChecked(true);
                } else if (geantaEdit.getMarime().equals("Mică")) {
                    rbMica.setChecked(true);
                }

                ratingBar.setRating(geantaEdit.getRating());

                for (int i = 0; i < spMaterial.getCount(); i++) {
                    if (spMaterial.getItemAtPosition(i).toString().trim().equals(geantaEdit.getMaterial().trim())) {
                        spMaterial.setSelection(i);
                        break;
                    }
                }
            }
        }
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

        Intent intentReturnare = new Intent();

        if (geantaEdit != null) {
            geantaEdit.setBrand(brandIntrodus);
            geantaEdit.setEsteNoua(esteGeantaNoua);
            geantaEdit.setAreGarantie(areGarantieBifata);
            geantaEdit.setMarime(marimeAleasa);
            geantaEdit.setMaterial(materialAles);
            geantaEdit.setRating(numarStele);

            intentReturnare.putExtra("GEANTA_MEA", geantaEdit);
        } else {
            Geanta geantaNoua = new Geanta(brandIntrodus, esteGeantaNoua, areGarantieBifata, marimeAleasa, materialAles, numarStele);
            intentReturnare.putExtra("GEANTA_MEA", geantaNoua);
        }

        setResult(RESULT_OK, intentReturnare);
        finish();
    }
}