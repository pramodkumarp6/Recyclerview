package com.pramod.recyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("cars_list.json")
    Call<List<CarsModel>>getPhoto();

}
