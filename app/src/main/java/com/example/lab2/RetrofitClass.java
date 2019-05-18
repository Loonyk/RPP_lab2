package com.example.lab2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static RetrofitClass loader;
    private Retrofit retrofit;
    private static final String BASE_URL =
            "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/";

    public RetrofitClass() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitClass getInstance() {
        if (loader == null) {
            loader = new RetrofitClass();
        }
        return loader;
    }

    public InterfaceJSON getJSON() {
        return retrofit.create(InterfaceJSON.class);
    }
}
