package com.example.autoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MakeApplication extends AppCompatActivity {

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_application);

        EditText application_name = findViewById(R.id.TextApplicationName);
        EditText car_make = findViewById(R.id.TextCarMake);
        EditText car_number = findViewById(R.id.TextCarNumber);
        EditText work_description = findViewById(R.id.TextWorkDescription);
        Button makeApp_btn = findViewById(R.id.MakeApplicationButton);

        makeApp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AppName = application_name.getText().toString();
                String CarMake = car_make.getText().toString();
                String CarNumber = car_number.getText().toString();
                String WorkDescription = work_description.getText().toString();

                database.child("Applications").child(AppName + " Application").child("Car make").setValue(CarMake);
                database.child("Applications").child(AppName + " Application").child("Car number").setValue(CarNumber);
                database.child("Applications").child(AppName + " Application").child("Work description").setValue(WorkDescription);
            }
        });
    }
}