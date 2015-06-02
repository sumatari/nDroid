package com.mobapp.sumaira.tipcal;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SpeActivity extends ActionBarActivity {
    String takeEvent;
    String takeWeather;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spe);
        final TextView t1 = (TextView) findViewById(R.id.textView1);
        final TextView t2 = (TextView) findViewById(R.id.textView3);
        final RadioGroup g1 = (RadioGroup) findViewById(R.id.radioGroup1);
        final RadioGroup g2 = (RadioGroup) findViewById(R.id.radioGroup2);
        Button submit = (Button) findViewById(R.id.submit);
        Button mainApp= (Button) findViewById(R.id.mainApp);
        final ListView speDresslist=(ListView) findViewById(R.id.speDresslist);


        mainApp.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
           startActivity(new Intent(getApplicationContext(), MainActivity.class));
           }
           });

        submit.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick (View v){


                switch (g2.getCheckedRadioButtonId()) {
                    case R.id.casual:
                        takeEvent= "Casual";
                        break;

                    case R.id.formal:
                        takeEvent= "Formal";

                        break;
                    case R.id.whatever:
                        takeEvent= "Whatever";
                        break;
                    default:
                        takeEvent="";

                }

                    switch (g1.getCheckedRadioButtonId()) {
                        case R.id.hot:
                            takeWeather= "Hot";
                            break;

                        case R.id.mild:
                            takeWeather= "Mild";

                            break;
                        case R.id.cold:
                           takeWeather= "Cold";
                            break;
                        default:
                            takeWeather="";

                    }



                    db = new DBHelper(getApplicationContext());
                    ArrayList array = db.getFewDresses(takeEvent,takeWeather);

                    ArrayAdapter arrayAdapter =  new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,array);
                    //adding it to the list view.
                    speDresslist.setAdapter(arrayAdapter);
                    g1.setVisibility(View.INVISIBLE);
                    g2.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.INVISIBLE);
                    t2.setVisibility(View.INVISIBLE);
                    speDresslist.setVisibility(View.VISIBLE);



            }
            }

            );




        }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       //getMenuInflater().inflate(R.menu.menu_spe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
