package somitsolutions.android.unitconverter;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import android.content.Intent;
import android.util.Log;


public class MainActivity extends Activity implements OnItemClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView lv = (ListView) findViewById(R.id.conversionsList);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0) {
            try {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CurrencyConverter.class);
                startActivity(intent);
                finish();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }


        } else if (position == 1) {

            try {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, UnitConverter.class);
                startActivity(intent);
                finish();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
