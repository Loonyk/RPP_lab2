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

        RetrofitClass.getInstance()
                .getJSON()
                .getJSONClass()
                .enqueue(new Callback<List<JSONClass>>() {
                    @Override
                    public void onResponse(Call<List<JSONClass>> call, Response<List<JSONClass>> response) {
                        if (response.isSuccessful()) {
                            jsonItem = response.body();
                            jsonItem.remove(0); //удаления первого объекта json
                            openNewActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<JSONClass>> call, Throwable t) {
                        try {
                            Thread.sleep(3000); //если нет интернета, поток засыпает
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
