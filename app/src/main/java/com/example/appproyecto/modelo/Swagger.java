package com.example.appproyecto.modelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Swagger {

    String URL = "http://localhost:8080/dsaApp/";

    @POST("/juego/login")
    @FormUrlEncoded
    Call<Users> getPosts(@Field("password") String password,
                         @Field("mail") String mail);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
