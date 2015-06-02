
package somitsolutions.android.unitconverter;

import java.util.List;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

//this is for git testing

public class CurrencyConverter extends Activity implements OnClickListener, AdapterView.OnItemSelectedListener{
    /** Called when the activity is first created. */

    private Spinner SpinnerUnit;
    private EditText inputValue;

    private Spinner SpinnerFrom;
    private Spinner SpinnerTo;
    private Button ButtonConvert;
    private EditText ResultView;
    ArrayAdapter<String> unitarray;
    ArrayAdapter<String> unitarrayadapter;
    ArrayAdapter<String> unitarrayadapterfrom;
    private String unitfrom;
    private String unitto;
    private static CurrencyConverter instance;

    //this is to test the Git repository
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.currencyconverter);


        SpinnerUnit = (Spinner)findViewById(R.id.SpinnerUnit);
        SpinnerUnit.setOnItemSelectedListener(this);

        unitarray=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerUnit.setAdapter(unitarray);
        unitarray.add(getResources().getString(R.string.unit0));

        unitarray.setNotifyOnChange(true);

        SpinnerFrom = (Spinner)findViewById(R.id.SpinnerFrom);
        SpinnerFrom.setOnItemSelectedListener(this);
        SpinnerTo = (Spinner)findViewById(R.id.SpinnerTo);
        SpinnerTo.setOnItemSelectedListener(this);

        unitarrayadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitarrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SpinnerTo.setAdapter(unitarrayadapter);
        SpinnerFrom.setAdapter(unitarrayadapter);

        unitarrayadapter.setNotifyOnChange(true);
/*
        unitarrayadapterfrom = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitarrayadapterfrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SpinnerFrom.setAdapter(unitarrayadapterfrom);
        unitarrayadapterfrom.setNotifyOnChange(true);
*/

        ResultView = (EditText)findViewById(R.id.TextViewResult);
        ResultView.setClickable(false);

        ButtonConvert = (Button)findViewById(R.id.Button01);

        ButtonConvert.setOnClickListener(this);

        inputValue = (EditText)findViewById(R.id.EditTextValue);


        //initialization

        instance = this;
    }

    public static CurrencyConverter getInstance(){
        return instance;
    }

    public void onItemSelected(AdapterView<?> parent){
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    public void onItemSelected(AdapterView<?> parent, View v,
                               int position, long id){

        if(v.getParent() == SpinnerUnit){

            fillFromToSpinner(position);

            //SpinnerFrom.setSelection(0);
            //SpinnerTo.setSelection(0);

            //If only first spinner is selected and
            //the from and to spinners are not clicked at all


            unitfrom = (String)(SpinnerTo.getItemAtPosition(0).toString());

            //unitfrom = (String)(SpinnerFrom.getResources().getString(R.string.USD));
            unitto = (String)(SpinnerTo.getItemAtPosition(0).toString());

            //reset the result
            ResultView.setText("");


        }
        else if(v.getParent() == SpinnerFrom){
           unitfrom = (String)(SpinnerFrom.getResources().getString(R.string.USD));

        }

        else if(v.getParent() == SpinnerTo){
            unitto = (String)(SpinnerTo.getSelectedItem().toString());
        }
    }


    private void fillFromToSpinner(int position){

        fillSpinnerWithCurrencyUnit();
    }

    private void fillSpinnerWithCurrencyUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.USD));
        unitarrayadapter.add(getResources().getString(R.string.EUR));
        unitarrayadapter.add(getResources().getString(R.string.GBP));
        unitarrayadapter.add(getResources().getString(R.string.INR));
        unitarrayadapter.add(getResources().getString(R.string.AUD));
        unitarrayadapter.add(getResources().getString(R.string.CAD));
        unitarrayadapter.add(getResources().getString(R.string.SGD));
        unitarrayadapter.add(getResources().getString(R.string.CNY));
        unitarrayadapter.add(getResources().getString(R.string.THB));
        unitarrayadapter.notifyDataSetChanged();

/*
        unitarrayadapterfrom.clear();
        unitarrayadapterfrom.add(getResources().getString(R.string.USD));
        unitarrayadapterfrom.notifyDataSetChanged();
*/
    }

    public void onClick(View v){
        if(v == ButtonConvert){
            if(!inputValue.getText().toString().equals("")){
                double in = Double.parseDouble(inputValue.getText().toString());
                double in2 = Double.parseDouble(inputValue.getText().toString());

                //******************USD
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("USD")) && (to.equals("EUR"))){

                    double ret = in * 0.93 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("USD")) && (to.equals("GBP"))){

                    double ret = in * 0.66 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("USD")) && (to.equals("INR"))){

                    double ret = in * 62.87 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("USD")) && (to.equals("AUD"))){

                    double ret = in * 1.28 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("USD")) && (to.equals("CAD"))){

                    double ret = in * 1.22 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("USD")) && (to.equals("SGD"))){

                    double ret = in * 1.35 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("EUR")) && (to.equals("CHY"))){

                    double ret = in * 6.19 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("EUR")) && (to.equals("THB"))){

                    double ret = in * 32.37 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************

                //******************EUR
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("EUR")) && (to.equals("USD"))){

                    double ret = in * 1.07 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("EUR")) && (to.equals("GBP"))){

                    double ret = in * 0.71 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("EUR")) && (to.equals("INR"))){

                    double ret = in * 67.43 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("EUR")) && (to.equals("AUD"))){

                    double ret = in * 1.38 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("EUR")) && (to.equals("CAD"))){

                    double ret = in * 1.31 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("EUR")) && (to.equals("SGD"))){

                    double ret = in * 1.44 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("EUR")) && (to.equals("CHY"))){

                    double ret = in * 6.64 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("EUR")) && (to.equals("THB"))){

                    double ret = in * 34.73 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************
                //******************GBP
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("GBP")) && (to.equals("USD"))){

                    double ret = in * 1.50 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("GBP")) && (to.equals("EUR"))){

                    double ret = in * 1.40 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("GBP")) && (to.equals("INR"))){

                    double ret = in * 94.68 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("GBP")) && (to.equals("AUD"))){

                    double ret = in * 1.93 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("GBP")) && (to.equals("CAD"))){

                    double ret = in * 1.84 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("GBP")) && (to.equals("SGD"))){

                    double ret = in * 2.02 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("GBP")) && (to.equals("CHY"))){

                    double ret = in * 9.31 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("GBP")) && (to.equals("THB"))){

                    double ret = in * 48.69 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************

                //******************INR
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("INR")) && (to.equals("USD"))){

                    double ret = in * 0.016 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("INR")) && (to.equals("EUR"))){

                    double ret = in * 0.015 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("INR")) && (to.equals("GBP"))){

                    double ret = in * 0.010 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("INR")) && (to.equals("AUD"))){

                    double ret = in * 0.020 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("INR")) && (to.equals("CAD"))){

                    double ret = in * 0.019 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("INR")) && (to.equals("SGD"))){

                    double ret = in * 0.021 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("INR")) && (to.equals("CHY"))){

                    double ret = in * 0.098 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("INR")) && (to.equals("THB"))){

                    double ret = in * 0.514 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************

                //******************AUD
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("AUD")) && (to.equals("USD"))){

                    double ret = in * 0.77 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("AUD")) && (to.equals("EUR"))){

                    double ret = in * 0.72 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("AUD")) && (to.equals("GBP"))){

                    double ret = in * 0.51 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("AUD")) && (to.equals("INR"))){

                    double ret = in * 48.92 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("AUD")) && (to.equals("CAD"))){

                    double ret = in * 0.95 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("AUD")) && (to.equals("SGD"))){

                    double ret = in * 1.04 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("AUD")) && (to.equals("CHY"))){

                    double ret = in * 4.81 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("AUD")) && (to.equals("THB"))){

                    double ret = in * 25.17 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************

                //******************CAD
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("CAD")) && (to.equals("USD"))){

                    double ret = in * 0.81 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("CAD")) && (to.equals("EUR"))){

                    double ret = in * 0.76 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("CAD")) && (to.equals("GBP"))){

                    double ret = in * 0.54 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("CAD")) && (to.equals("INR"))){

                    double ret = in * 51.43 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("CAD")) && (to.equals("AUD"))){

                    double ret = in * 1.05 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("CAD")) && (to.equals("SGD"))){

                    double ret = in * 1.10 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("CAD")) && (to.equals("CHY"))){

                    double ret = in * 5.06 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("CAD")) && (to.equals("THB"))){

                    double ret = in * 26.45 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************

                //******************SGD
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("SGD")) && (to.equals("USD"))){

                    double ret = in * 0.74 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("SGD")) && (to.equals("EUR"))){

                    double ret = in * 0.69 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("SGD")) && (to.equals("GBP"))){

                    double ret = in * 0.49 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("SGD")) && (to.equals("INR"))){

                    double ret = in * 46.74 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("SGD")) && (to.equals("AUD"))){

                    double ret = in * 0.95 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("SGD")) && (to.equals("CAD"))){

                    double ret = in * 0.90 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("SGD")) && (to.equals("CHY"))){

                    double ret = in * 4.59 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("SGD")) && (to.equals("THB"))){

                    double ret = in * 24.04 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************

                //******************CNY
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("CNY")) && (to.equals("USD"))){

                    double ret = in * 0.16 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("CNY")) && (to.equals("EUR"))){

                    double ret = in * 0.15 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("CNY")) && (to.equals("GBP"))){

                    double ret = in * 0.10 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("CNY")) && (to.equals("INR"))){

                    double ret = in * 10.16 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("CNY")) && (to.equals("AUD"))){

                    double ret = in * 0.20 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("CNY")) && (to.equals("CAD"))){

                    double ret = in * 0.19 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("CNY")) && (to.equals("SGD"))){

                    double ret = in * 0.21 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)))) {
                    //if((from.equals("CNY")) && (to.equals("THB"))){

                    double ret = in * 5.22 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************

                //******************THB
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.USD)))) {
                    //if((from.equals("THB")) && (to.equals("USD"))){

                    double ret = in * 0.030 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.EUR)))) {
                    //if((from.equals("THB")) && (to.equals("EUR"))){

                    double ret = in * 0.028 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.GBP)))) {
                    //if((from.equals("THB")) && (to.equals("GBP"))){

                    double ret = in * 0.020 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.INR)))) {
                    //if((from.equals("THB")) && (to.equals("INR"))){

                    double ret = in * 1.943 ;

                    ResultView.setText(Double.toString(ret));
                }

                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.AUD)))) {
                    //if((from.equals("THB")) && (to.equals("AUD"))){

                    double ret = in * 0.039 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CAD)))) {
                    //if((from.equals("THB")) && (to.equals("CAD"))){

                    double ret = in * 0.037 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.SGD)))) {
                    //if((from.equals("THB")) && (to.equals("SGD"))){

                    double ret = in * 0.041 ;

                    ResultView.setText(Double.toString(ret));
                }
                if ((unitfrom.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.THB)) && unitto.equals(CurrencyConverter.getInstance().getApplicationContext().getResources().getString(R.string.CNY)))) {
                    //if((from.equals("THB")) && (to.equals("CNY"))){

                    double ret = in * 0.191 ;

                    ResultView.setText(Double.toString(ret));
                }
                //************************************************
                //********************equals currency*************

                if (unitfrom.equals(unitto))
                {
                    ResultView.setText(Double.toString(in));
                }
            }
            else {
                ResultView.setText("");
            }
        }
    }
}