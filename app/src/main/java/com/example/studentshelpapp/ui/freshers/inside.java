package com.example.studentshelpapp.ui.freshers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studentshelpapp.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class inside extends Fragment {
    ListView listView;
    String[] Name={"Amul: LC","Samosa chat: LC,DG","Fruit juice,shake: LC,Chota HG",
            "Cafe Coffee Day","Limbdi canteen" ,"ramanujan canteen" };
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.inside, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        inside.CustomAdapter customAdapter = new inside.CustomAdapter();
        listView.setAdapter(customAdapter);
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
            view = getLayoutInflater().inflate(R.layout.customlayout2,null);
            TextView restname_s = (TextView)view.findViewById(R.id.restname_s);
            restname_s.setText(Name[i]);
            return view;
        }
    }
}
