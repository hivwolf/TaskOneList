package com.example.taskonelist;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button add_Button;
    ListView listOfPeople;
    Database databaseOfPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_Button = (Button) findViewById(R.id.addButton);
        listOfPeople = (ListView) findViewById(R.id.peopleList);
        databaseOfPeople = new Database(this);




        add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPutDataActivity();
            }
        });


        ArrayList<String> listData = new ArrayList<>();
        Cursor data = databaseOfPeople.getDataToList();

        while(data.moveToNext()){
            listData.add(data.getString(1&2) + " " + data.getString(1));
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
            listOfPeople.setAdapter(listAdapter);
        }



    }








    public void openPutDataActivity() {

        Intent intent = new Intent(this, PutDataActivity.class);
        startActivity(intent);

    }







}
