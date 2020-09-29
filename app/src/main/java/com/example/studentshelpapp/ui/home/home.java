package com.example.studentshelpapp.ui.home;

import androidx.lifecycle.ViewModelProviders;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentshelpapp.R;
import com.example.studentshelpapp.ui.buynsell.buynsell;
import com.example.studentshelpapp.ui.cpndev.cpndev;
import com.example.studentshelpapp.ui.freshers.foods;
import com.example.studentshelpapp.ui.freshers.freshers;
import com.example.studentshelpapp.ui.notes.notes;

import java.util.ArrayList;
import java.util.List;

public class home extends Fragment {

    private HomeViewModel mViewModel;
    ViewPager viewPager;
    Adapter adapter;
    List<model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Context thisContext;
    public static home newInstance() {
        return new home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        models = new ArrayList<>();
        models.add(new model(R.drawable.fresher, "Freshers", "Get yourself acquainted with the campus"));
        models.add(new model(R.drawable.notes, "Notes", "A wide collection of books_layout, pdfs and handwritten notes"));
        models.add(new model(R.drawable.buynsell, "Buy and Sell", "You can buy or sell lab coats, aprons, ED kits etc"));
        models.add(new model(R.drawable.cpndev, "CP and dev Resources", "Get all that you require to begin and master your skills in CP and dev"));

        thisContext = container.getContext();
        adapter = new Adapter(models, thisContext);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);
        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
        };
        colors=colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position< (adapter.getCount()-1) && position< (colors.length-1))
                {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position]
                            )
                    );

                }
                else
                {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}