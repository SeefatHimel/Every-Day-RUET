package com.apps.himel.everydayruet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRoutine;
    RoutineDatabaseHelper routineDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        routineDatabaseHelper = new RoutineDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = routineDatabaseHelper.getWritableDatabase();


        btnRoutine = (Button) findViewById(R.id.btnMainRoutine);
        btnRoutine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnMainRoutine)
        {
           // Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
            routineDatabaseHelper.allDays();
            Intent intent = new Intent(getApplicationContext(),RoutineActivity.class);
            startActivity(intent);
        }

    }
}
