package com.mobapp.sumaira.tipcal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ManageActivity extends Activity {
   // private ListView obj;
    DBHelper mydb;
    String itemItem;
    String eventItem;
    String weatherItem;
    String patternItem;
    String colorItem;
    String fabricItem;
    String hintItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        mydb = new DBHelper(this);


        Button mainApp= (Button) findViewById(R.id.mainApp);
        Button save = (Button) findViewById(R.id.save);

        final EditText color= (EditText) findViewById(R.id.color);
        final EditText hint = (EditText) findViewById(R.id.hint);

        colorItem= color.getText().toString();
        hintItem = hint.getText().toString();

        final Spinner itemSpinner= (Spinner) findViewById(R.id.itemSpinner);
        final String item[] = {"Shirt","Suit","Pant","Jacket"};
        ArrayAdapter<String> itemspinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_dropdown_item, item);
        itemspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        itemSpinner.setAdapter(itemspinnerArrayAdapter);

        final Spinner weatherSpinner= (Spinner) findViewById(R.id.weatherSpinner);
        final String weather[] = {"Hot","Mild","Cold"};
        ArrayAdapter<String> weatherspinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_dropdown_item, weather);
        weatherspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        weatherSpinner.setAdapter(weatherspinnerArrayAdapter);

        final Spinner eventSpinner= (Spinner) findViewById(R.id.eventSpinner);
        final String event[] = {"Formal","Casual"};
        ArrayAdapter<String> eventspinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_dropdown_item, event);
        eventspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
       eventSpinner.setAdapter(eventspinnerArrayAdapter);

        final Spinner patternSpinner= (Spinner) findViewById(R.id.patternSpinner);
        final String pattern[] = {"Solid","Stripe","Check"};
        ArrayAdapter<String> patternspinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_dropdown_item, pattern);
        patternspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        patternSpinner.setAdapter(patternspinnerArrayAdapter);

        final Spinner fabricSpinner= (Spinner) findViewById(R.id.fabricSpinner);
        final String fabric[] = {"Cotton","Silk","Other"};
        ArrayAdapter<String> fabricspinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_dropdown_item, fabric);
        fabricspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        fabricSpinner.setAdapter(fabricspinnerArrayAdapter);



        itemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {

               itemItem = itemSpinner.getItemAtPosition(position).toString();

                //hint.setText(selectedItem);
                // if(selectedItem.equals("Hot")) {}
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        weatherSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {

                weatherItem = weatherSpinner.getItemAtPosition(position).toString();
                //hint.setText(selectedItem);
                // if(selectedItem.equals("Hot")) {}
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        eventSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                eventItem = eventSpinner.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        fabricSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                fabricItem = fabricSpinner.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        patternSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                patternItem = patternSpinner.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
             mydb.insertDress(itemItem,eventItem,weatherItem,patternItem,colorItem,fabricItem,hintItem );

            }
        });


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
        getMenuInflater().inflate(R.menu.menu_manage, menu);
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
