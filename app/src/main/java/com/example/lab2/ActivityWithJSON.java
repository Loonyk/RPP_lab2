package com.example.lab2;

import android.content.DialogInterface;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityWithJSON extends AppCompatActivity {

    ListView listView;
    ArrayList<JSONClass> jsonItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_json);

        jsonItem = getIntent().getParcelableArrayListExtra("Technologies");
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new ListAdapter(this, jsonItem));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentViewPager(position);
            }
        });

    }

    void FragmentViewPager(int viewpager){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentClass fragment = new FragmentClass();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("JSONClass", jsonItem);
        bundle.putInt("Start", viewpager);
        fragment.setArguments(bundle);
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // для закрытия по кнопке Назад
    private void openQuitApp(){
        AlertDialog.Builder quitApp = new AlertDialog.Builder(ActivityWithJSON.this);
        quitApp.setTitle("Вы уверены, что хотите выйти?");
        quitApp.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        quitApp.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        quitApp.show();
    }

    @Override
    //переопределение метода нажатия на кнопку Назад
    public void onBackPressed(){
        openQuitApp();
    }

}
