package com.mobapp.sumaira.tipcal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class SpeDisplay extends Activity {

   String takeEvent="Casual";
   String takeWeather="Cold";
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spe_display);
        Button mainApp= (Button) findViewById(R.id.mainApp);
        ListView speDresslist= (ListView)findViewById(R.id.speDresslist);

        //Bundle extras = getIntent().getExtras();


        db = new DBHelper(this);
        ArrayList array = db.getFewDresses(takeEvent,takeWeather);
       // ArrayList array = db.getAllDresses();
                    ArrayAdapter arrayAdapter =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
                    //adding it to the list view.
        speDresslist.setAdapter(arrayAdapter);





        mainApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spe_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
