package com.apps.himel.everydayruet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoutineActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAddRoutineActivity,btnShowRutineActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
        btnAddRoutineActivity= findViewById(R.id.btnAddRoutineActivity);
        btnShowRutineActivity= findViewById(R.id.btnShowRoutineActivity);

        btnAddRoutineActivity.setOnClickListener(this);
        btnShowRutineActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnAddRoutineActivity)
        {
            Intent intent = new Intent(getApplicationContext(),AddRoutineActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.btnShowRoutineActivity)
        {
            Intent intent = new Intent(getApplicationContext(),ShowRoutineActivity.class);
            startActivity(intent);
        }
    }
}
