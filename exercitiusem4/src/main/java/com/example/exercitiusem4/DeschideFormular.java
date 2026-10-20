package com.example.exercitiusem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeschideFormular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deschide_formular);
    }
    public void mergiLaFormular(View view) {
        Intent intent = new Intent(this, exercitiuSem4.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            Bundle bundlePrimit = data.getExtras();

            if (bundlePrimit != null) {
                Geanta geantaPrimita = (Geanta) bundlePrimit.getSerializable("GEANTA_MEA");

                Toast.makeText(this, "A ajuns la prima activitate:\n" +
                        geantaPrimita.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}