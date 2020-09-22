package com.example.studentshelpapp.ui.notes;

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

public class notes extends Fragment {

    private NotesViewModel mViewModel;
    Button note_s,book_s;
    public static notes newInstance() {
        return new notes();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notes, container, false);
        note_s = (Button) view.findViewById(R.id.note_s);
        note_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNote();
            }
        });
        book_s = (Button) view.findViewById(R.id.book_s);
        book_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBook();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        // TODO: Use the ViewModel
    }
    public void openNote()
    {
        Intent intent = new Intent(getActivity(), note.class);
        startActivity(intent);
    }
    public void openBook()
    {
        Intent intent = new Intent(getActivity(), book.class);
        startActivity(intent);
    }
}