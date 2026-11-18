package com.example.exercitiusem4;

import android.content.Intent;                 // ADĂUGAT
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;                       // ADĂUGAT
import android.view.View;                      // ADĂUGAT
import android.widget.AdapterView;             // ADĂUGAT
import android.widget.ListView;                // ADĂUGAT

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ImaginiListView extends AppCompatActivity {

    List<Bitmap> imagini = new ArrayList<>();   // MODIFICAT: inițializată (era null)
    List<ImaginiDomeniu> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagini_list_view);

        // MODIFICAT: link-uri DIRECTE către imagini (.jpg / .png / .webp), nu pagini web
        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://LINK_DIRECT_IMAGINE_1.jpg");
        linkuriImagini.add("https://LINK_DIRECT_IMAGINE_2.jpg");
        linkuriImagini.add("https://LINK_DIRECT_IMAGINE_3.jpg");
        linkuriImagini.add("https://LINK_DIRECT_IMAGINE_4.jpg");
        linkuriImagini.add("https://LINK_DIRECT_IMAGINE_5.jpg");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());   // MODIFICAT: era Looper.myLooper()

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(String link:linkuriImagini) {
                    HttpURLConnection con = null;
                    try{

                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        con.setConnectTimeout(8000);                          // ADĂUGAT
                        con.setReadTimeout(8000);                             // ADĂUGAT
                        con.setRequestProperty("User-Agent", "Mozilla/5.0");  // ADĂUGAT
                        InputStream is = con.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                        is.close();                                           // ADĂUGAT

                    }catch (Exception e)
                    {
                        // ȘTERS: e.getMessage();
                        Log.e("ImaginiListView", "Eroare la " + link, e);     // ADĂUGAT
                        imagini.add(null);                                    // ADĂUGAT (păstrează indexurile)
                    }
                    finally {                                                 // ADĂUGAT
                        if (con != null) con.disconnect();
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        lista= new ArrayList<>();
                        lista.add(new ImaginiDomeniu("Prima geanta", imagini.get(0), "https://www.glamourmagazine.co.uk/article/best-designer-handbags"));
                        lista.add(new ImaginiDomeniu("A doua geanta", imagini.get(1), "https://angelkissbag.com/de/collections/satchel-crossbody-bags?color_filter=pink&srsltid=AYCX9vJ2x1BpAeL2bc1xF-MONFD6vfxEmlmn6RZdWdkVvNLI1QqNMWtq"));
                        lista.add(new ImaginiDomeniu("A treia geanta", imagini.get(2), "https://www.zumiez.com/ed-hardy-nova-black-handbag.html?srsltid=AYCX9vLR7ckqlERkJUfTvBkdPwWeUqbAL-5WdFkIe2yrNhVxuYkSmHdD"));
                        lista.add(new ImaginiDomeniu("A patra geanta", imagini.get(3), "https://www.farfetch.com/ro/shopping/women/hermes-pre-owned-2020-35-birkin-handbag-item-36546152.aspx"));
                        lista.add(new ImaginiDomeniu("A cincea geanta", imagini.get(4), "https://www.farfetch.com/ro/shopping/women/miu-miu-pocket-leather-shoulder-bag-item-31175395.aspx"));

                        // ADĂUGAT de aici până la finalul metodei run()
                        ListView listView = findViewById(R.id.imagini);
                        ImagineAdapter adapter = new ImagineAdapter(lista, ImaginiListView.this, R.layout.imagini);
                        listView.setAdapter(adapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(ImaginiListView.this, WebViewActivity.class);
                                intent.putExtra("LINK", lista.get(position).getLink());
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });
    }
}