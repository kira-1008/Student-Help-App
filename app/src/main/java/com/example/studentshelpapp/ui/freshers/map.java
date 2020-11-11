package com.example.studentshelpapp.ui.freshers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import com.example.studentshelpapp.R;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        WebView browser = (WebView) findViewById(R.id.map);
        browser.loadUrl("https://www.bhu.ac.in/aboutbhu/map/images/bhumap3.png");
    }
}