package com.example.exercitiusem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        ListView listViewGenti = findViewById(R.id.listViewGenti);
        Intent intent = getIntent();

        ArrayList<Geanta> listaPrimita = (ArrayList<Geanta>) intent.getSerializableExtra("listaGenti");
        if(listaPrimita!= null) {
            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listaPrimita);

            listViewGenti.setAdapter(adapter);

            listViewGenti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Geanta geantaSelectata = listaPrimita.get(position);

                    Toast.makeText(ActivityListView.this, "Ai selectat:\n" + geantaSelectata.toString(), Toast.LENGTH_SHORT).show();
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
}