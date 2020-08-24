package com.example.studentshelpapp.ui.freshers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studentshelpapp.R;

public class outside extends Fragment {
    ListView listView;
    String[] Name={"Bindaas, HG",
            "Singh's delight",
            "Momos, Hyderabad gate",
            "Brunners",
            "Delicious Delights, Hyderabad Gate",
            "Cozy Corner, Assi",
            "Banaras Burger Corner, Lanka",
            "Bangs, Lanka",
            "Stark bistro, lanka",
            "Banaras Sweet house",
            "Capsicum",
            "Urban tadka",
            "South Point Cafe, Lanka",
            "Pehelwaan lassi",
            "Flavours Cafe, Lanka",
            "Sagar Ratna, Lanka",
            "Hindustan Family Restaurant, Ravidas Gate",
            "Tit bit Café at Home, Ravidas Gate",
            "Doodh Booth, Bhelupur",
            "Roma’s Cafe, Lanka",
            "Shivam Restaurant, Lanka",
            "Crood square",
            "Western street",
            "Teracotta, Assi",
            "Goli Vada Pav, Lanka",
            "Angeethee, Assi",
            "Haldi,",
            "Keventers",
            "The Village in Town Cafe, Assi Ghat",
            "The Open Hand Cafe, Assi",
            "Sparrow Cafe, Assi",
            "Itihaas, Assi",
            "kashi cafe, assi",
            "Banaras Haveli, Assi",
            "Rajat’s Roof Top 80, Assi",
            "Nimwang Chinese, Durgakund",
            "Siva Restaurant, Assi Ghat",
            "Raga cafe 2",
            "The Tripling Bistro, Assi",
            "Karki, Assi",
            "Ashish Cafe, Assi",
            "Chocolate Heaven, Ravindrapuri",
            "Pizzeria Vaatika Cafe, Assi",
            "Aum Cafe, Assi",
            "Mr. Dosa and Mrs. Chutney",
            "Palace on Ganges, Assi",
            "Carvaan, assi",
            "Downtown Pizza, Assi",
            "Trisha Food & Cafe Family Restaurant",
            "Ming Garden, Ravindrapuri",
            "Crystal Bowl, Ravindrapuri",
            "Potli",
            "Ming bakery",
            "Fidka",
            "Grill inn, bhelupur",
            "Tasty Buds, Bhelupur",
            "Zaika, Ravindra Puri",
            "London shakes",
            "The people tree",
            "Aman restaurant, ravindrapuri Chowk",
            "Bangal Sweets (en route to MUVstn)",
            "Domino’s, IP Vijaya",
            "Petoo, ravindrapuri",
            "The thick shake factory",
            "Bikaner vala, IP Vijaya",
            "Diamond Hotel, Bhelupur",
            "Jaipuriya, Bansfaatak",
            "JS Residency, Bhelupur",
            "Mishrambu Thandai, Gadolia Chowk",
            "Kerala Cafe, Bhelupur",
            "Open Baba House, Sonarpura",
            "Shiv Prasad Lassi Bhandar, Ram Nagar Fort",
            "Harishchandra Ghat Idli Thela (mornings)",
            "Dahi bhalla wala in left inside KVT Gate",
            "Siva Café and German bakery, Naarad Ghat",
            "Brown Bread Bakery, Sigra",
            "Monalisa Cafe",
            "Bowl Of Compassion, DebnathPura, Bengali Tola",
            "Bona Cafe, Bangali Tola",
            "Chit Chat Restaurant",
            "Aadha Aadha, Bengali Tola",
            "Aadha aadha cafe, Baba guest house",
            "Kashi Chaat Bhandar, Gadolia",
            "Megu Cafe, Kalika Gali (enroute to KVT)",
            "Deena Chat Bhandar, Godowlia",
            "Dosa cafe, Dashashwamedh Ghat",
            "Niyati Cafe, Dashashwamedh Ghat",
            "Dolphin, Man Mandir Ghat",
            "The Chocolate Room, IP Sigra",
            "Ganpati Guest House, Meer Ghat",
            "Raga cafe",
            "Blue Lassi",
            "Amritsari Hut, Mahmoorganj",
            "Rasvanti, Thatheri bazaar",
            "Ram bandar, (for breakfast), Same area for VNS best chaat (post 7pm)",
            "Hotel Saffron, Gadolia",
            "Rhythm Restaurant, Rathyatra",
            "McDonald’s, IP Sigra",
            "Cafebility",
            "Burger King, Ravindra Puri",
            "Moti Mahal, IP Sigra",
            "The Brew Room, Shivpurwa",
            "Lemon Grass, Lahurabir",
            "Pind balluchi",
            "VNS Live Studio, Sigra",
            "Hotel Hindustan International, Chetganj",
            "Genuine Broaster Chicken",
            "Holy Chopsticks, Nadesar",
            "Lazeez foods, Teliyabag",
            "Baati Chokha, Maldahiya",
            "Saktar Dhaba, Highway",
            "Hotel India Banaras, Cantonment Area",
            "Hotel Meraden Grand, Cantonment Area",
            "Brownie, Cantonment Area",
            "Radisson, Cantonment Area",
            "Sapphire Grand, Cantonment Area",
            "Mangi Ferra, Hotel Surya, Nadesar",
            "Hotel Surya, Cantonment Area",
            "Pizza Hut, JHV",
            "Barbeque Nations",
            "Ramada Plaza, Cantonment Area",
            "Tandoor villa, Cantonment Area" };
    String[] distance={"1","1","1","1.2","1.3","2.4","2.6","2.7","2.8","2.8","2.8","2.8","2.9","2.9",
            "3","3","3","3","3.1","3.3","3.3","3.5","3.6","3.7","4","4","4","4","4.1","4.2","4.2",
            "4.2","4.2","4.2","4.2","4.2","4.2","4.2","4.3","4.3","4.3","4.3","4.3","4.3","4.3","4.3",
            "4.3","4.4","4.4","4.5","4.5","4.5","4.5","4.5","4.6","4.7","4.7","4.7","4.7","4.8","4.8",
            "4.8","4.8","4.8","4.9","4.9","4.9","5","5","5.2","5.2","5.2","5.3","5.6","5.8","5.9",
            "5.9","6","6.1","6.1","6.3","6.3","6.4","6.7","6.7","6.8","6.8","6.8","6.9","6.9","7.1",
            "7.2","7.3","7.4","7.6","7.7","7.8","8","8","8","8","8.1","8.2","8.2","8.3","8.7","9.6",
            "9.7","9.8","9.8","10.1","10.2","10.2","10.5","10.8","10.9","11.1","11.1","11.3","11.3",
            "11.4","11.5"};
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.outside, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter();
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
            view = getLayoutInflater().inflate(R.layout.customlayout,null);
            TextView restname_s = (TextView)view.findViewById(R.id.restname_s);
            TextView dist_s = (TextView)view.findViewById(R.id.dist_s);
            restname_s.setText(Name[i]);
            dist_s.setText(distance[i]+" km");
            return view;
        }
    }
}
