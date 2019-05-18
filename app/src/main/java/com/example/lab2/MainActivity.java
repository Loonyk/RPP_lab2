package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<JSONClass> jsonItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

//        Sleep sleep = new Sleep(this);
//        sleep.start();

        RetrofitClass.getInstance()
                .getJSON()
                .getJSONClass()
                .enqueue(new Callback<List<JSONClass>>() {
                    @Override
                    public void onResponse(Call<List<JSONClass>> call, Response<List<JSONClass>> response) {
                        if (response.isSuccessful()) {
                            jsonItem = response.body();
                            jsonItem.remove(0); //removing first JSON object that not match to Ancient Technology
                            openNewActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<JSONClass>> call, Throwable t) {
                        try {
                            Thread.sleep(3000); //thread sleeps for memory economy on .clone() (when internet connection lost)
                        } catch (InterruptedException e) { }
                        call.clone().enqueue(this); //retry request
                    }
                });





    }

    public void openNewActivity(){
        Intent intent = new Intent(".ActivityWithJSON");
        intent.putParcelableArrayListExtra("Technologies", (ArrayList)jsonItem);
        startActivity(intent);
        finish();
    }
}
