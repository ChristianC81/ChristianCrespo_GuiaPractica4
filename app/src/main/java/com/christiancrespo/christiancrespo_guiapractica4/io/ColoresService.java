package com.christiancrespo.christiancrespo_guiapractica4.io;

import com.christiancrespo.christiancrespo_guiapractica4.model.Colores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ColoresService {
    String API_ROUTE = "/colores.json";
    @GET(API_ROUTE)
    Call<List<Colores>> getColores();
}
