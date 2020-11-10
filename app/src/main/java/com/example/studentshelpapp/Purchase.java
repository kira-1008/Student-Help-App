package com.example.studentshelpapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.CancellableTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purchase extends AppCompatActivity implements Ad_Item_Adapter.OnAdListener{
    static public List<String> ItemNameList;
    static public List<String> ItemPriceList;
    static public ArrayList<String> UserNameList;
    static public ArrayList<String> Category;
    static public ArrayList<String> Contact;
    static public ArrayList<String> Description;
    static public ArrayList<List<String>> itemurl;
    static public ArrayList<String> Keylist;
    private RecyclerView AdsView;
    private Ad_Item_Adapter ad_item_adapter;
    Button homebtn;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ProgressDialog mprogress;


    public void home(View view)
    {mprogress.setMessage("Loading..");
        mprogress.show();
        Query query=myRef.limitToLast(50);
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ItemNameList.clear();
                ItemPriceList.clear();
                UserNameList.clear();
                Category.clear();
                Contact.clear();
                Description.clear();
                itemurl.clear();
                Keylist.clear();
                ad_item_adapter.notifyDataSetChanged();
                long counter=snapshot.getChildrenCount();
                if(counter==0)
                {
                    mprogress.dismiss();
                }
                //Log.i("counter",Long.toString(counter));
                long i=1;
               for(DataSnapshot data:snapshot.getChildren())
               {Keylist.add(data.getKey());
                   Map<String, Object> values = (HashMap<String, Object>) data.getValue();

                   UserNameList.add(values.get("Name").toString());
                   Contact.add(values.get("Contact").toString());
                   ItemNameList.add(values.get("Product").toString());
                   ItemPriceList.add(values.get("Price").toString());

                   if(values.containsKey("Description"))
                   {
                       Description.add(values.get("Description").toString());
                   }
                   else
                   {
                       Description.add("No description");
                   }
                   ArrayList<String> temp = new ArrayList<>();
                   if(values.containsKey("Images")) {


                       for (DataSnapshot image : data.child("Images").getChildren()) {
                           temp.add(image.getValue().toString());


                       }
                       //Log.i("images",temp.get(0));

                   }
                   else
                   {temp.add("No image");

                   }
                   itemurl.add(temp);
                   i++;
                   //Log.i("i",Long.toString(i));
                   if(i>counter)
                   {//Log.i("nmaes",ItemNameList.toString());

                       Collections.reverse(ItemNameList);
                       Collections.reverse(ItemPriceList);
                       Collections.reverse(itemurl);
                       Collections.reverse(UserNameList);
                       Collections.reverse(Category);
                       Collections.reverse(Contact);
                       Collections.reverse(Description);
                       Collections.reverse(Keylist);
                       ad_item_adapter.notifyDataSetChanged();
                       mprogress.dismiss();
                   }

               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void vehicle(View view)
    {mprogress.setMessage("Loading..");
        mprogress.show();
        Query query=myRef.orderByChild("Category").equalTo("Vehicle").limitToLast(50);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ItemNameList.clear();
                ItemPriceList.clear();
                UserNameList.clear();
                Category.clear();
                Contact.clear();
                Description.clear();
                itemurl.clear();
                Keylist.clear();
                ad_item_adapter.notifyDataSetChanged();
                long counter=snapshot.getChildrenCount();
                if(counter==0)
                {
                    mprogress.dismiss();
                }
                //Log.i("counter",Long.toString(counter));
                long i=1;
                for(DataSnapshot data:snapshot.getChildren())
                {
                    Map<String, Object> values = (HashMap<String, Object>) data.getValue();

                    UserNameList.add(values.get("Name").toString());

                    Contact.add(values.get("Contact").toString());
                    ItemNameList.add(values.get("Product").toString());
                    ItemPriceList.add(values.get("Price").toString());

                    if(values.containsKey("Description"))
                    {
                        Description.add(values.get("Description").toString());
                    }
                    else
                    {
                        Description.add("No description");
                    }
                    ArrayList<String> temp = new ArrayList<>();
                    if(values.containsKey("Images")) {


                        for (DataSnapshot image : data.child("Images").getChildren()) {
                            temp.add(image.getValue().toString());


                        }
                        //Log.i("images",temp.get(0));

                    }
                    else
                    {temp.add("No image");

                    }
                    itemurl.add(temp);
                    i++;
                    //Log.i("i",Long.toString(i));
                    if(i>counter)
                    {//Log.i("nmaes",ItemNameList.toString());

                        Collections.reverse(ItemNameList);
                        Collections.reverse(ItemPriceList);
                        Collections.reverse(itemurl);
                        Collections.reverse(UserNameList);
                        Collections.reverse(Category);
                        Collections.reverse(Contact);
                        Collections.reverse(Description);
                        Collections.reverse(Keylist);
                        ad_item_adapter.notifyDataSetChanged();
                        mprogress.dismiss();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void apron(View view)
    {mprogress.setMessage("Loading..");
        mprogress.show();
        Query query=myRef.orderByChild("Category").equalTo("Apron").limitToLast(50);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ItemNameList.clear();
                ItemPriceList.clear();
                UserNameList.clear();
                Category.clear();
                Contact.clear();
                Description.clear();
                itemurl.clear();
                Keylist.clear();
                ad_item_adapter.notifyDataSetChanged();
                long counter=snapshot.getChildrenCount();
                if(counter==0)
                {
                    mprogress.dismiss();
                }
                //Log.i("counter",Long.toString(counter));
                long i=1;
                for(DataSnapshot data:snapshot.getChildren())
                {
                    Map<String, Object> values = (HashMap<String, Object>) data.getValue();

                    UserNameList.add(values.get("Name").toString());

                    Contact.add(values.get("Contact").toString());
                    ItemNameList.add(values.get("Product").toString());
                    ItemPriceList.add(values.get("Price").toString());

                    if(values.containsKey("Description"))
                    {
                        Description.add(values.get("Description").toString());
                    }
                    else
                    {
                        Description.add("No description");
                    }
                    ArrayList<String> temp = new ArrayList<>();
                    if(values.containsKey("Images")) {


                        for (DataSnapshot image : data.child("Images").getChildren()) {
                            temp.add(image.getValue().toString());


                        }
                        //Log.i("images",temp.get(0));

                    }
                    else
                    {temp.add("No image");

                    }
                    itemurl.add(temp);
                    i++;
                    //Log.i("i",Long.toString(i));
                    if(i>counter)
                    {//Log.i("nmaes",ItemNameList.toString());
                        Collections.reverse(ItemNameList);
                        Collections.reverse(ItemPriceList);
                        Collections.reverse(itemurl);
                        Collections.reverse(UserNameList);
                        Collections.reverse(Category);
                        Collections.reverse(Contact);
                        Collections.reverse(Description);
                        Collections.reverse(Keylist);
                        ad_item_adapter.notifyDataSetChanged();
                        mprogress.dismiss();

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void books(View view)
    {mprogress.setMessage("Loading..");
        mprogress.show();
        Query query=myRef.orderByChild("Category").equalTo("Books/Notes").limitToLast(50);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ItemNameList.clear();
                ItemPriceList.clear();
                UserNameList.clear();
                Category.clear();
                Contact.clear();
                Description.clear();
                itemurl.clear();
                Keylist.clear();
                ad_item_adapter.notifyDataSetChanged();
                long counter=snapshot.getChildrenCount();
                if(counter==0)
                {
                    mprogress.dismiss();
                }
                //Log.i("counter",Long.toString(counter));
                long i=1;
                for(DataSnapshot data:snapshot.getChildren())
                {
                    Map<String, Object> values = (HashMap<String, Object>) data.getValue();

                    UserNameList.add(values.get("Name").toString());

                    Contact.add(values.get("Contact").toString());
                    ItemNameList.add(values.get("Product").toString());
                    ItemPriceList.add(values.get("Price").toString());

                    if(values.containsKey("Description"))
                    {
                        Description.add(values.get("Description").toString());
                    }
                    else
                    {
                        Description.add("No description");
                    }
                    ArrayList<String> temp = new ArrayList<>();
                    if(values.containsKey("Images")) {


                        for (DataSnapshot image : data.child("Images").getChildren()) {
                            temp.add(image.getValue().toString());


                        }
                        //Log.i("images",temp.get(0));

                    }
                    else
                    {temp.add("No image");

                    }
                    itemurl.add(temp);
                    i++;
                    //Log.i("i",Long.toString(i));
                    if(i>counter)
                    {//Log.i("nmaes",ItemNameList.toString());
                        Collections.reverse(ItemNameList);
                        Collections.reverse(ItemPriceList);
                        Collections.reverse(itemurl);
                        Collections.reverse(UserNameList);
                        Collections.reverse(Category);
                        Collections.reverse(Contact);
                        Collections.reverse(Keylist);
                        Collections.reverse(Description);
                        ad_item_adapter.notifyDataSetChanged();
                        mprogress.dismiss();

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void edkit(View view)
    {mprogress.setMessage("Loading..");
        mprogress.show();
        Query query=myRef.orderByChild("Category").equalTo("ED Kit").limitToLast(50);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ItemNameList.clear();
                ItemPriceList.clear();
                UserNameList.clear();
                Category.clear();
                Contact.clear();
                Description.clear();
                itemurl.clear();
                Keylist.clear();
                ad_item_adapter.notifyDataSetChanged();
                long counter=snapshot.getChildrenCount();
                if(counter==0)
                {
                    mprogress.dismiss();
                }
                //Log.i("counter",Long.toString(counter));
                long i=1;
                for(DataSnapshot data:snapshot.getChildren())
                {
                    Map<String, Object> values = (HashMap<String, Object>) data.getValue();

                    UserNameList.add(values.get("Name").toString());

                    Contact.add(values.get("Contact").toString());
                    ItemNameList.add(values.get("Product").toString());
                    ItemPriceList.add(values.get("Price").toString());

                    if(values.containsKey("Description"))
                    {
                        Description.add(values.get("Description").toString());
                    }
                    else
                    {
                        Description.add("No description");
                    }
                    ArrayList<String> temp = new ArrayList<>();
                    if(values.containsKey("Images")) {


                        for (DataSnapshot image : data.child("Images").getChildren()) {
                            temp.add(image.getValue().toString());


                        }
                        //Log.i("images",temp.get(0));

                    }
                    else
                    {temp.add("No image");

                    }
                    itemurl.add(temp);
                    i++;
                    //Log.i("i",Long.toString(i));
                    if(i>counter)
                    {//Log.i("nmaes",ItemNameList.toString());

                        Collections.reverse(ItemNameList);
                        Collections.reverse(ItemPriceList);
                        Collections.reverse(itemurl);
                        Collections.reverse(UserNameList);
                        Collections.reverse(Category);
                        Collections.reverse(Keylist);
                        Collections.reverse(Contact);
                        Collections.reverse(Description);
                        ad_item_adapter.notifyDataSetChanged();
                        mprogress.dismiss();

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void others(View view)
    {mprogress.setMessage("Loading..");
        mprogress.show();
        Query query=myRef.orderByChild("Category").equalTo("Other").limitToLast(50);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ItemNameList.clear();
                ItemPriceList.clear();
                UserNameList.clear();
                Category.clear();
                Contact.clear();
                Description.clear();
                itemurl.clear();
                Keylist.clear();
                ad_item_adapter.notifyDataSetChanged();
                long counter=snapshot.getChildrenCount();
                if(counter==0)
                {
                    mprogress.dismiss();
                }
                //Log.i("counter",Long.toString(counter));
                long i=1;
                for(DataSnapshot data:snapshot.getChildren())
                {
                    Map<String, Object> values = (HashMap<String, Object>) data.getValue();

                    UserNameList.add(values.get("Name").toString());

                    Contact.add(values.get("Contact").toString());
                    ItemNameList.add(values.get("Product").toString());
                    ItemPriceList.add(values.get("Price").toString());

                    if(values.containsKey("Description"))
                    {
                        Description.add(values.get("Description").toString());
                    }
                    else
                    {
                        Description.add("No description");
                    }
                    ArrayList<String> temp = new ArrayList<>();
                    if(values.containsKey("Images")) {


                        for (DataSnapshot image : data.child("Images").getChildren()) {
                            temp.add(image.getValue().toString());


                        }
                        //Log.i("images",temp.get(0));

                    }
                    else
                    {temp.add("No image");

                    }
                    itemurl.add(temp);
                    i++;
                    //Log.i("i",Long.toString(i));
                    if(i>counter)
                    {//Log.i("nmaes",ItemNameList.toString());
                        Collections.reverse(ItemNameList);
                        Collections.reverse(ItemPriceList);
                        Collections.reverse(itemurl);
                        Collections.reverse(UserNameList);
                        Collections.reverse(Category);
                        Collections.reverse(Contact);
                        Collections.reverse(Keylist);
                        Collections.reverse(Description);
                        ad_item_adapter.notifyDataSetChanged();
                        mprogress.dismiss();

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Shop");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference().child("Ads");
        mprogress=new ProgressDialog(this);




        ItemNameList=new ArrayList<>();
        ItemPriceList=new ArrayList<>();
        UserNameList=new ArrayList<>();
        Contact=new ArrayList<>();
        Description=new ArrayList<>();
        Category=new ArrayList<>();
        itemurl=new ArrayList<>();
        Keylist=new ArrayList<>();
        homebtn=findViewById(R.id.btn_home);
        AdsView=findViewById(R.id.ads_view);
        ad_item_adapter=new Ad_Item_Adapter(ItemPriceList,ItemNameList,itemurl,this);
        //Recycler View
        AdsView.setLayoutManager(new LinearLayoutManager(this));
        AdsView.setHasFixedSize(true);
        AdsView.setAdapter(ad_item_adapter);
        home(homebtn);




    }

    @Override
    public void onAdClick(int position) {
        Intent intent=new Intent(this,Details.class);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}