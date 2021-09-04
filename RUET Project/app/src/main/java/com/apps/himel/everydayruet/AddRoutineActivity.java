package com.apps.himel.everydayruet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddRoutineActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner DaySelectSpinner;

    private static final String No_Class = "No Class";

    private String[] DayList;

    EditText edtTxt1, edtTxt2, edtTxt3, edtTxt4, edtTxt5, edtTxt6, edtTxt7, edtTxt8, edtTxt9;

    Button btnAddRoutine,btnLoadRoutine,btnClearRutine;

    RoutineDatabaseHelper routineDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);

        routineDatabaseHelper = new RoutineDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = routineDatabaseHelper.getWritableDatabase();

        DaySelectSpinner = (Spinner) findViewById(R.id.DaySelectSpinner);

        DayList= getResources().getStringArray(R.array.dayList);

        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this,R.layout.sample_layout,R.id.txtShow,DayList);
        DaySelectSpinner.setAdapter(adapter);

        btnAddRoutine = (Button) findViewById(R.id.btnAddRoutine);
        btnLoadRoutine = (Button) findViewById(R.id.btnLoadRoutine);
        btnClearRutine = (Button) findViewById(R.id.btnClearRoutine);

        edtTxt1 = (EditText) findViewById(R.id.edtTxt1);
        edtTxt2 = (EditText) findViewById(R.id.edtTxt2);
        edtTxt3 = (EditText) findViewById(R.id.edtTxt3);
        edtTxt4 = (EditText) findViewById(R.id.edtTxt4);
        edtTxt5 = (EditText) findViewById(R.id.edtTxt5);
        edtTxt6 = (EditText) findViewById(R.id.edtTxt6);
        edtTxt7 = (EditText) findViewById(R.id.edtTxt7);
        edtTxt8 = (EditText) findViewById(R.id.edtTxt8);
        edtTxt9 = (EditText) findViewById(R.id.edtTxt9);

        btnAddRoutine.setOnClickListener(this);
        btnLoadRoutine.setOnClickListener(this);
        btnClearRutine.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str1, str2, str3, str4, str5, str6, str7, str8, str9,day,dayCheck;
        day=DaySelectSpinner.getSelectedItem().toString();

        str1= edtTxt1.getText().toString();
        str2= edtTxt2.getText().toString();
        str3= edtTxt3.getText().toString();
        str4= edtTxt4.getText().toString();
        str5= edtTxt5.getText().toString();
        str6= edtTxt6.getText().toString();
        str7= edtTxt7.getText().toString();
        str8= edtTxt8.getText().toString();
        str9= edtTxt9.getText().toString();

        if(str1.length()<1)
            str1=No_Class;
        if(str2.length()<1)
            str2=No_Class;
        if(str3.length()<1)
            str3=No_Class;
        if(str4.length()<1)
            str4=No_Class;
        if(str5.length()<1)
            str5=No_Class;
        if(str6.length()<1)
            str6=No_Class;
        if(str7.length()<1)
            str7=No_Class;
        if(str8.length()<1)
            str8=No_Class;
        if(str9.length()<1)
            str9=No_Class;


        if(v.getId()==R.id.btnAddRoutine)
        {
            if(day.charAt(0)=='S')
            {
                Toast.makeText(getApplicationContext(),"Select Day",Toast.LENGTH_SHORT).show();
            }
            else {
                Boolean isUpdated = routineDatabaseHelper.updateData(day, str1, str2, str3, str4, str5, str6, str7, str8, str9);
                if (isUpdated == true) {
                    Toast.makeText(getApplicationContext(), "---Data Updated---", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "!!!!Data Not Updated!!!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(v.getId()==R.id.btnLoadRoutine)
        {
            if(day.charAt(0)=='S')
            {
                Toast.makeText(getApplicationContext(),"Select Day",Toast.LENGTH_SHORT).show();
            }
            else {
                Cursor cursor = routineDatabaseHelper.displayAllData();
                if (cursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"Nothing Found",Toast.LENGTH_LONG).show();
                    return;
                }

                while (cursor.moveToNext())
                {
                    dayCheck=cursor.getString(0);
                    Toast.makeText(getApplicationContext(),dayCheck+" = "+day,Toast.LENGTH_SHORT).show();

                    if(dayCheck.charAt(0)==day.charAt(0))
                    {
                        edtTxt1.setText(cursor.getString(1));
                        edtTxt2.setText(cursor.getString(2));
                        edtTxt3.setText(cursor.getString(3));
                        edtTxt4.setText(cursor.getString(4));
                        edtTxt5.setText(cursor.getString(5));
                        edtTxt6.setText(cursor.getString(6));
                        edtTxt7.setText(cursor.getString(7));
                        edtTxt8.setText(cursor.getString(8));
                        edtTxt9.setText(cursor.getString(9));
                        Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                    }

            }


            }
        }
        if(v.getId()==R.id.btnClearRoutine)
        {
            edtTxt1.setText("");
            edtTxt2.setText("");
            edtTxt3.setText("");
            edtTxt4.setText("");
            edtTxt5.setText("");
            edtTxt6.setText("");
            edtTxt7.setText("");
            edtTxt8.setText("");
            edtTxt9.setText("");
            Toast.makeText(getApplicationContext(),"Cleared",Toast.LENGTH_LONG).show();
        }

    }
}
