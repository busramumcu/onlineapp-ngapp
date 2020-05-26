package com.example.onlineshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onlineshoppingapp.Model.ItemAdapter;

public class DashboardActivity extends AppCompatActivity {

    ListView myListView;
    String[] items =  { "One", "Two", "Three" , "Four" };
    String [] prices = {"0.90 USD","0.91 USD","0.92 USD","0.93 USD"};
    String [] descriptions = {"Description1","Description2", "Description3", "Description4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);

        ItemAdapter itemAdapter = new ItemAdapter(this,items,prices, descriptions);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent showDetailActivity = new Intent(getApplicationContext(), DashboardDetailActivity.class);
                showDetailActivity.putExtra("com.example.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(),"Search Button",Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_okey) {
            Toast.makeText(getApplicationContext(),"Choice Button",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
