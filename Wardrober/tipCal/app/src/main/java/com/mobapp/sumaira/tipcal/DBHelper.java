package com.mobapp.sumaira.tipcal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Wardrobe.db";
    public static final String DRESSITEM_TABLE_NAME = "DressItem";
    public static final String DRESSITEM_COLUMN_ID = "id";
    public static final String DRESSITEM_COLUMN_ITEM = "Item";
    public static final String DRESSITEM_COLUMN_EVENT = "Event";
    public static final String DRESSITEM_COLUMN_WEATHER = "Weather";
    public static final String DRESSITEM_COLUMN_PATTERN = "Pattern";
    public static final String DRESSITEM_COLUMN_COLOR = "Color";
    public static final String DRESSITEM_COLUMN_FABRIC = "Fabric";
    public static final String DRESSITEM_COLUMN_HINT = "Hint";

    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table DressItem " +
                        "(id integer primary key, Item text,Event text,Weather text, Pattern text,Color text, Fabric text,Hint text)"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS DressItem");
        onCreate(db);
    }

    public boolean insertDress  (String item, String event, String weather, String pattern,String color,String fabric, String hint)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Item", item);
        contentValues.put("Event", event);
        contentValues.put("Weather", weather);
        contentValues.put("Pattern", pattern);
        contentValues.put("Color", color);
        contentValues.put("Fabric", fabric);
        contentValues.put("Hint", hint);

        db.insert("DressItem", null, contentValues);
        return true;
    }
    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DressItem where id="+id+"", null );
        return res;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DRESSITEM_TABLE_NAME);
        return numRows;
    }
    public boolean updateDress (Integer id, String item, String event, String weather, String pattern,String color, String fabric, String hint)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Item", item);
        contentValues.put("Event", event);
        contentValues.put("Weather", weather);
        contentValues.put("Pattern", pattern);
        contentValues.put("Color", color);
        contentValues.put("Fabric", fabric);
        contentValues.put("Hint", hint);
        db.update("DressItem", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteDressItem (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("DressItem", "id = ? ", new String[] { Integer.toString(id) });
    }

    public ArrayList getAllDresses()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DressItem" , null );
        res.moveToFirst();


        while(res.isAfterLast() == false){

            array_list.add(res.getString(5) + " The  " + res.getString(6)+ " fabric " + res.getString(1)+ " with " + res.getString(5) + " " + res.getString(4)+ " Pattern. " + res.getString(7) );

            res.moveToNext();
        }
        return array_list;

    }

    public ArrayList getFewDresses(String event, String weather)
    {
        ArrayList<String> array_list = new ArrayList<String>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM DressItem WHERE Event = '"+ event +"' AND Weather = '" +weather+ "'" , null );
        res.moveToFirst();


       while(res.isAfterLast() == false){

            array_list.add("The  " + res.getString(6)+ " fabric " + res.getString(1)+ " with " + res.getString(5) + " " + res.getString(4) +" Pattern." );

          res.moveToNext();
        }
        return array_list;

    }

    public ArrayList getWeatherDresses(String weather)
    {
        ArrayList<String> array_list = new ArrayList<String>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM DressItem WHERE Weather = '"+ weather +"'", null );
        res.moveToFirst();


        while(res.isAfterLast() == false){

            array_list.add("For  "+ weather + " "+res.getString(6)+ " fabric " + res.getString(1)+ " with " + res.getString(5) + " " + res.getString(4) +" Pattern." );

            res.moveToNext();
        }
        return array_list;

    }
}
