package com.example.taskonelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PutDataActivity extends AppCompatActivity {
    Database databaseOfPeople;
    EditText editName, editSurname;
    Button SaveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_data);
        databaseOfPeople = new Database(this);

        editName = (EditText) findViewById(R.id.insertName);
        editSurname = (EditText) findViewById(R.id.insertSurname);
        SaveButton = (Button) findViewById(R.id.saveButton);

        AddData();
    }

    public void AddData(){

        SaveButton.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    boolean isInserted = databaseOfPeople.addData(editName.getText().toString(),
                                                   editSurname.getText().toString());


                    if(isInserted = true){
                        Toast.makeText(PutDataActivity.this,"Your data is inserted", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(PutDataActivity.this,"Your data is not inserted", Toast.LENGTH_LONG).show();
                    }
                    }
                }
        );

    }

}
