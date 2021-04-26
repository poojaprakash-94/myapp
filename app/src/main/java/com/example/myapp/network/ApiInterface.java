package com.example.myapp.network;

import com.example.myapp.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("login.php")
    Call<LoginResponse> login(@Query("email") String email,
                              @Query("password") String password);




}
