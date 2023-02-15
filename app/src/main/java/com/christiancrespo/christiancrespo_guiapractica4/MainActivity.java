package com.christiancrespo.christiancrespo_guiapractica4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.christiancrespo.christiancrespo_guiapractica4.model.Colores;
import com.christiancrespo.christiancrespo_guiapractica4.io.ColoresService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter arrayAdapter;
    ArrayList<String> datos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.listViewDatos);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        list.setAdapter(arrayAdapter);
        obtenerColores();
    }
    private void obtenerColores(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://christiancrespo8.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ColoresService coloresService= retrofit.create(ColoresService.class);
        Call<List<Colores>> call= coloresService.getColores();
        call.enqueue(new Callback<List<Colores>>() {
            @Override
            public void onResponse(Call<List<Colores>> call, Response<List<Colores>> response) {
                for (Colores colores: response.body()){
                    datos.add(colores.getNombreColor());

                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Colores>> call, Throwable t) {

            }
        });
    }
}