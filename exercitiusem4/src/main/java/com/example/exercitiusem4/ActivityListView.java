package com.example.exercitiusem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    private GeantaAdapter adapter = null;
    private int idModificat = 0;
    private ArrayList<Geanta> listaPrimita = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listViewGenti = findViewById(R.id.listViewGenti);
        Intent intent = getIntent();

        listaPrimita = intent.getParcelableArrayListExtra("listaGenti");

        if (listaPrimita != null) {
            adapter = new GeantaAdapter(listaPrimita, getApplicationContext(), R.layout.layout_list_view);
            listViewGenti.setAdapter(adapter);

            listViewGenti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intentModifica = new Intent(getApplicationContext(), exercitiuSem4.class);
                    intentModifica.putExtra("geanta", listaPrimita.get(i));
                    idModificat = i;
                    startActivityForResult(intentModifica, 209);
                    Toast.makeText(getApplicationContext(), listaPrimita.get(i).toString(), Toast.LENGTH_SHORT).show();
                }
            });

            listViewGenti.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    listaPrimita.remove(position);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ActivityListView.this, "Geanta stearsa", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 209 && data != null) {
                Geanta geantaModificata = data.getParcelableExtra("GEANTA_MEA");
                if (geantaModificata != null) {
                    listaPrimita.set(idModificat, geantaModificata);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}