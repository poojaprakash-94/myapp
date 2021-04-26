package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ExampleActivity extends AppCompatActivity {
    Toolbar toolbar;

    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        //getSupportActionBar().hide();

        viewPager = findViewById(R.id.view_pager);
        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        // add the fragments
        viewPagerAdapter.add(new GroupsFragment(), "Groups");
        viewPagerAdapter.add(new GalleryFragment(), "Gallery");


        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settingss,menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

}