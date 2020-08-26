package com.example.studentshelpapp.ui.freshers;

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

import com.example.studentshelpapp.R;

public class freshers extends Fragment {

    private FreshersViewModel mViewModel;
    Button food_s,map_s,need_s,fest_s;
    public static freshers newInstance() {
        return new freshers();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshers, container, false);
        food_s = (Button) view.findViewById(R.id.food_s);
        food_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFood();
            }
        });
        map_s = (Button) view.findViewById(R.id.map_s);
        map_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        need_s = (Button) view.findViewById(R.id.need_s);
        need_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNeed();
            }
        });
        fest_s = (Button) view.findViewById(R.id.fest_s);
        fest_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFest();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FreshersViewModel.class);
        // TODO: Use the ViewModel
    }
    public void openFood()
    {
        Intent intent = new Intent(getActivity(), foods.class);
        startActivity(intent);
    }
    public void openMap()
    {

    }
    public void openNeed()
    {
        Intent intent = new Intent(getActivity(), needs.class);
        startActivity(intent);
    }
    public void openFest()
    {
        Intent intent = new Intent(getActivity(), fests.class);
        startActivity(intent);
    }
}