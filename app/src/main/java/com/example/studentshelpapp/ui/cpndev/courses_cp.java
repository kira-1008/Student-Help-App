package com.example.studentshelpapp.ui.cpndev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studentshelpapp.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class courses_cp extends Fragment {
    ListView listView;
    String[] desc={"https://www.coursera.org/learn/algorithmic-toolbox/home/welcome",
    "https://www.udemy.com/course/datastructurescncpp/",
    "https://www.edx.org/course/cs50s-introduction-to-computer-science"};
    String[] Name={"Algorithms : CourseEra","Data Structures : Udemy",
            "Introduction to Computer Science : EDX"};
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.courses_cp, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        courses_cp.CustomAdapter customAdapter = new courses_cp.CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(desc[position]));
                startActivity(intent);
            }
        });
        return view;
    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Name.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout6,null);
            TextView restname_s = (TextView)view.findViewById(R.id.subject);
            restname_s.setText(Name[i]);
            TextView link = (TextView)view.findViewById(R.id.link);
            link.setText(desc[i]);
            return view;
        }
    }
}
