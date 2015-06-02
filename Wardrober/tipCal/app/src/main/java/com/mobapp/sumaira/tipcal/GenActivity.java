package com.mobapp.sumaira.tipcal;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class GenActivity extends ActionBarActivity {
 DBHelper mydb;
 private ListView obj;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen);
        Button mainApp= (Button) findViewById(R.id.mainApp);
        Button showDresses= (Button) findViewById(R.id.showDresses);
        Button submit= (Button) findViewById(R.id.submit);
        final TextView city = (TextView) findViewById(R.id.city_field);
        final TextView ctemp = (TextView) findViewById(R.id.current_temperature_field);
        final TextView update = (TextView) findViewById(R.id.updated_field);
        final String weatherPara= "Hot";
        showDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mydb = new DBHelper(getApplicationContext());
                ArrayList array = mydb.getWeatherDresses(weatherPara);
                ArrayAdapter arrayAdapter =  new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, array);

                //adding it to the list view.
                obj = (ListView)findViewById(R.id.dresslist);
                obj.setAdapter(arrayAdapter);

            }
        });

        mainApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


    }




    public void changeCity(String city){
        WeatherFragment wf = (WeatherFragment)getSupportFragmentManager().findFragmentById(R.id.city_field);
        wf.changeCity(city);
        new CityPreference(this).setCity(city);
    }


}