package com.example.studentshelpapp.ui.notes;

import android.os.Bundle;

import com.example.studentshelpapp.ui.notes.main.SectionsPagerAdapter3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.studentshelpapp.ui.freshers.ui.main.SectionsPagerAdapter;
import com.example.studentshelpapp.R;

public class note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        SectionsPagerAdapter3 sectionsPagerAdapter3 = new SectionsPagerAdapter3(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter3);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

    }
}