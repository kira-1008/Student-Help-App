package com.example.studentshelpapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {
    Intent intent;
    TextView Name;
    TextView Contact;
    TextView Product;
    TextView Price;
    TextView Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        intent=getIntent();
        Name=findViewById(R.id.text_name);
        Contact=findViewById(R.id.text_contact);
        Product=findViewById(R.id.text_product);
        Price=findViewById(R.id.text_price);
        Description=findViewById(R.id.text_desc);
        int position=intent.getIntExtra("position",0);
        ImageSlider imageSlider=findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        for(int i=0;i<Purchase.itemurl.get(position).size();i++)
        {
            slideModels.add(new SlideModel(Purchase.itemurl.get(position).get(i),ScaleTypes.FIT));
        }
        imageSlider.setImageList(slideModels);
        Name.setText(Purchase.UserNameList.get(position));
        Contact.setText(Purchase.Contact.get(position));
        Product.setText(Purchase.ItemNameList.get(position));
        Price.setText(Purchase.ItemPriceList.get(position));
        Description.setText(Purchase.Description.get(position));


    }
}