package com.apps.himel.everydayruet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ShowRoutineActivity extends AppCompatActivity {

    Spinner daySelectSpinner ;

    RoutineDatabaseHelper routineDatabaseHelper;

    TextView txtView1, txtView2, txtView3, txtView4, txtView5, txtView6, txtView7, txtView8, txtView9;

    String[] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_routine);

        routineDatabaseHelper = new RoutineDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = routineDatabaseHelper.getWritableDatabase();

        daySelectSpinner = (Spinner) findViewById(R.id.DaySelectSpinner2);
        days= getResources().getStringArray(R.array.dayList2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.sample_layout,R.id.txtShow,days);
        daySelectSpinner.setAdapter(adapter);

        txtView1 = (TextView) findViewById(R.id.txtView1);
        txtView2 = (TextView) findViewById(R.id.txtView2);
        txtView3 = (TextView) findViewById(R.id.txtView3);
        txtView4 = (TextView) findViewById(R.id.txtView4);
        txtView5 = (TextView) findViewById(R.id.txtView5);
        txtView6 = (TextView) findViewById(R.id.txtView6);
        txtView7 = (TextView) findViewById(R.id.txtView7);
        txtView8 = (TextView) findViewById(R.id.txtView8);
        txtView9 = (TextView) findViewById(R.id.txtView9);


        daySelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String day = days[position];
                Toast.makeText(getApplicationContext(), day + " Routine is loaded", Toast.LENGTH_SHORT).show();


                Cursor cursor = routineDatabaseHelper.displayAllData();
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "Nothing Found", Toast.LENGTH_LONG).show();
                    return;
                }
                String dayCheck;

                while (cursor.moveToNext()) {
                    dayCheck = cursor.getString(0);
                   // Toast.makeText(getApplicationContext(), dayCheck + " = " + day, Toast.LENGTH_LONG).show();

                    if (dayCheck.charAt(0) == day.charAt(0)) {
                        txtView1.setText(cursor.getString(1));
                        txtView2.setText(cursor.getString(2));
                        txtView3.setText(cursor.getString(3));
                        txtView4.setText(cursor.getString(4));
                        txtView5.setText(cursor.getString(5));
                        txtView6.setText(cursor.getString(6));
                        txtView7.setText(cursor.getString(7));
                        txtView8.setText(cursor.getString(8));
                        txtView9.setText(cursor.getString(9));
                        //Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                    }

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}
