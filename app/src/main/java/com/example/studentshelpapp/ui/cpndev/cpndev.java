package com.example.studentshelpapp.ui.cpndev;

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

public class cpndev extends Fragment {

    private CpndevViewModel mViewModel;
    Button cp_s,dev_s;
    public static cpndev newInstance() {
        return new cpndev();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cpndev, container, false);
        cp_s = (Button) view.findViewById(R.id.cp_s);
        cp_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencp();
            }
        });
        dev_s = (Button) view.findViewById(R.id.dev_s);
        dev_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendev();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CpndevViewModel.class);
        // TODO: Use the ViewModel
    }
    public void opencp()
    {
        Intent intent = new Intent(getActivity(), cp.class);
        startActivity(intent);
    }
    public void opendev()
    {
        Intent intent = new Intent(getActivity(), dev.class);
        startActivity(intent);
    }

}