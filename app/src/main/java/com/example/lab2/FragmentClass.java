package com.example.lab2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentClass extends Fragment {

    ArrayList<JSONClass> jsonItem;
    int pages;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jsonItem = getArguments().getParcelableArrayList("AncientTechnologies");
        pages = getArguments().getInt("StartPage");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = (ViewPager)getView().findViewById(R.id.pager);
        viewPager.setAdapter(new ViewPagerAdapter(getContext(), jsonItem));
        viewPager.setCurrentItem(pages);
    }




}
