package com.example.lab2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceJSON {
    @GET("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json")
    public Call<List<JSONClass>>getJSONClass();
}
