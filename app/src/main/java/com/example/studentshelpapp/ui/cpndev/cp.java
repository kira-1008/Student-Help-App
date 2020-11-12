package com.example.studentshelpapp.ui.cpndev;

import android.os.Bundle;

import com.example.studentshelpapp.ui.cpndev.main.SectionsPagerAdapter5;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.example.studentshelpapp.R;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.studentshelpapp.ui.freshers.ui.main.SectionsPagerAdapter;

public class cp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp);
        SectionsPagerAdapter5 sectionsPagerAdapter = new SectionsPagerAdapter5(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
}