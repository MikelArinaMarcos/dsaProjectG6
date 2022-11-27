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

    String URL = "http://10.0.2.2/dsaApp/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @POST("/juego/login")
    @FormUrlEncoded
    Call<Users> getPosts(@Field("password") String password,
                         @Field("mail") String mail);

    @POST("/juego/users/register")
    @FormUrlEncoded
    Call<Users> getRegister(@Field("name") String name,
                            @Field("username") String username,
                            @Field("mail") String mail,
                            @Field("lastName") String lastName,
                            @Field("password") String password);


}
