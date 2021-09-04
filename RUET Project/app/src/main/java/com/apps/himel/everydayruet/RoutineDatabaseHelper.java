package com.apps.himel.everydayruet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class RoutineDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Routine_V1.db";
    private static final String TABLE_NAME = "Routine_details";
    private static final String DAY = "Day";
    private static final String ROW1 = "Row1";
    private static final String ROW2 = "Row2";
    private static final String ROW3 = "Row3";
    private static final String ROW4 = "Row4";
    private static final String ROW5 = "Row5";
    private static final String ROW6 = "Row6";
    private static final String ROW7 = "Row7";
    private static final String ROW8 = "Row8";
    private static final String ROW9 = "Row9";

    private static final String SELECT_ALL = "SELECT * FROM "+ TABLE_NAME;

    private static final int VERSION_NUMBER = 2;

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String CreateTable = "CREATE TABLE "+TABLE_NAME+"("+DAY+" VARCHAR(255) PRIMARY KEY, " +ROW1+ " VARCHAR(255) ," +ROW2+ " VARCHAR(255) ," +ROW3+ " VARCHAR(255) ," +ROW4+ " VARCHAR(255) ," +ROW5+ " VARCHAR(255) ," +ROW6+ " VARCHAR(255) ," +ROW7+ " VARCHAR(255) ," +ROW8+ " VARCHAR(255) ," +ROW9+ " VARCHAR(255)); ";


    private Context context;


    public RoutineDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(context, "Table Created",Toast.LENGTH_LONG).show();
            db.execSQL(CreateTable);
        }
        catch (Exception e){
            Toast.makeText(context, "Exception : "+e,Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context, "Table RE Created",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e,Toast.LENGTH_LONG).show();
        }
    }
    
    public void allDays()
    {
       long RowNum;
       RowNum= insertDays("A Day");
      // if(RowNum==-1)
      //  Toast.makeText(context, "Data Not Inserted!!!",Toast.LENGTH_LONG).show();
      // else
        Toast.makeText(context, "Data Inserted in Row : "+RowNum,Toast.LENGTH_SHORT).show();

       RowNum= insertDays("B Day");
      //  if(RowNum==-1)
      //      Toast.makeText(context, "Data Not Inserted!!!",Toast.LENGTH_LONG).show();
        //else
            Toast.makeText(context, "Data Inserted in Row : "+RowNum,Toast.LENGTH_SHORT).show();

        RowNum= insertDays("C Day");
        //if(RowNum==-1)
           // Toast.makeText(context, "Data Not Inserted!!!",Toast.LENGTH_LONG).show();
        //else
            Toast.makeText(context, "Data Inserted in Row : "+RowNum,Toast.LENGTH_SHORT).show();

        RowNum= insertDays("D Day");
      //  if(RowNum==-1)
       //     Toast.makeText(context, "Data Not Inserted!!!",Toast.LENGTH_LONG).show();
       // else
            Toast.makeText(context, "Data Inserted in Row : "+RowNum,Toast.LENGTH_SHORT).show();

        RowNum= insertDays("E Day");
       // if(RowNum==-1)
        //    Toast.makeText(context, "Data Not Inserted!!!",Toast.LENGTH_LONG).show();
        //else
            Toast.makeText(context, "Data Inserted in Row : "+RowNum,Toast.LENGTH_SHORT).show();

       // Toast.makeText(context, "Data Inserted Successfully ",Toast.LENGTH_LONG).show();
        
    }
    
    public long insertDays(String day_name)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DAY,day_name);
        contentValues.put(ROW1,"No Class");
        contentValues.put(ROW2,"No Class");
        contentValues.put(ROW3,"No Class");
        contentValues.put(ROW4,"No Class");
        contentValues.put(ROW5,"No Class");
        contentValues.put(ROW6,"No Class");
        contentValues.put(ROW7,"No Class");
        contentValues.put(ROW8,"No Class");
        contentValues.put(ROW9,"No Class");
        long rowNumber = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return  rowNumber;
        
    }

    public  boolean updateData(String day,String row1,String row2,String row3,String row4,String row5,String row6,String row7,String row8,String row9)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if(day.charAt(0)=='A')
        {
            day="A Day";
        }
        else  if(day.charAt(0)=='B')
        {
            day="B Day";
        }else  if(day.charAt(0)=='C')
        {
            day="C Day";
        }else  if(day.charAt(0)=='D')
        {
            day="D Day";
        }else  if(day.charAt(0)=='E')
        {
            day="E Day";
        }

        contentValues.put(DAY,day);
        contentValues.put(ROW1,row1);
        contentValues.put(ROW2,row2);
        contentValues.put(ROW3,row3);
        contentValues.put(ROW4,row4);
        contentValues.put(ROW5,row5);
        contentValues.put(ROW6,row6);
        contentValues.put(ROW7,row7);
        contentValues.put(ROW8,row8);
        contentValues.put(ROW9,row9);
        sqLiteDatabase.update(TABLE_NAME,contentValues,DAY+" = ?",new String[]{day});
        return  true;
    }
    public Cursor displayAllData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;

    }
}
