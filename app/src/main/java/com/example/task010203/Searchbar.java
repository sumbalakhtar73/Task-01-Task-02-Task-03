package com.example.task010203;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class Searchbar extends AppCompatActivity {

    ListView listView;
    SearchView searchView;
    String[] thingname={"Apple","Ali","Android","Banana","Book","Bilal","Ali Ahmed","Cat",
            "Computer","Dog","David","Copper","Fatima","Faria","Fish","Abdul","Komal","Kiran"
    ,"Gift","Komal Shehzadi","Rafia","Rafique","Ramzan","Ayesha","Yoyo","Zebra","Zoo"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        listView=(ListView)findViewById(R.id.listsearchpractice);
        searchView=(SearchView)findViewById(R.id.practicesaerchview);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,thingname);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

    }

}
