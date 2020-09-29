package com.example.studentshelpapp.ui.buynsell;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.studentshelpapp.MainActivity;
import com.example.studentshelpapp.MyAds;
import com.example.studentshelpapp.Purchase;
import com.example.studentshelpapp.R;
import com.example.studentshelpapp.Sell;

public class buynsell extends Fragment {


    CardView myads,purchase,sell;
    private BuynsellViewModel mViewModel;

    public static buynsell newInstance() {
        return new buynsell();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.buynsell, container, false);
        myads=v.findViewById(R.id.myads);
        sell=v.findViewById(R.id.sell);
        purchase=v.findViewById(R.id.purchase);
        myads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MyAds.class);
                startActivity(intent);
            }
        });
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Sell.class);
                startActivity(intent);
            }
        });
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Purchase.class);
                startActivity(intent);
            }
        });
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BuynsellViewModel.class);
        // TODO: Use the ViewModel
    }

}