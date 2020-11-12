package com.example.studentshelpapp.ui.cpndev;

import android.os.Bundle;

import com.example.studentshelpapp.ui.cpndev.main.SectionsPagerAdapter5;
import com.example.studentshelpapp.ui.cpndev.main.SectionsPagerAdapter6;
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

public class dev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
        SectionsPagerAdapter6 sectionsPagerAdapter = new SectionsPagerAdapter6(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
}