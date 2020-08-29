package com.example.studentshelpapp.ui.freshers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentshelpapp.R;

public class festdesc extends Fragment{
    ListView listView;
    String[] Name={"Spardha", "Kashiyatra","Technex","FMC Weekend","Aagman"};
    int Images[] = {R.drawable.spardha, R.drawable.ky, R.drawable.technex, R.drawable.fmc,R.drawable.aagman};
    String desc[] = {"Spardha is the annual Sports festival of IIT (BHU), Varanasi organised by the IIT gymkhana. With over 30 years in its span, Spardha has become the largest and one of the most awaited Sports fests of Northern India showcasing the athletic talent of the technical realm of India. Spardha, as the name suggests, is a stunning display of sporting fervour and with 18 events more...",
            "Kashiyatra is the annual socio cultural festival of Indian Institute of Technology (BHU) Varanasi which is organised in the mid of January. It is one of the most prominent college festivals in India. This event encompasses a beautiful blend of literature, music, art, dance, drama and much more.",
            "Welcome to one of the biggest techno-management fests of India, Technex organized by IIT (BHU), Varanasi. This fest hosts variety of events that lay emphasis on both your creative and analytical faculties of your mind more...",
            "The joy and liveliness of creating new things from scratch is the point of unification of all the clubs of the Film and Media Council. It is an opportunity for everyone to try their hands on especially tailored events that brings out creativity from within you. In FMC Weekend ’15, there were competitions encompassing the areas of photography, cinematography, more...",
            "With a single platform of Aagman, IIT BHU Varanasi welcomes the latest batch of students for the new academic year. To bring to the platform a variety of talents, there's everyting related to culture like dance, music, drama, art, quiz etc. It brings about fun and excitement among the students."};
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.festdesc, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        festdesc.CustomAdapter customAdapter = new CustomAdapter();
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
            view = getLayoutInflater().inflate(R.layout.customlayout3,null);
            TextView textView5 = (TextView)view.findViewById(R.id.textView5);
            textView5.setText(Name[i]);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(Images[i]);
            TextView textView4 = (TextView)view.findViewById(R.id.textView4);
            textView4.setText(desc[i]);
            return view;
        }
    }
}