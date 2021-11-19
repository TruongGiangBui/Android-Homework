package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.TextView;
public class CaculateActivity  extends AppCompatActivity {
    private TextView result;
    String inputtype;
    String outputtype;
    private TextInputEditText input;
    private Intent intent;
    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_caculate);
        result=findViewById(R.id.result);
        input=findViewById(R.id.input);
        intent=getIntent();
        type = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        input.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                convert();
            }


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        Spinner type1 = findViewById(R.id.type1);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Convert.getUnits(type));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type1.setAdapter(arrayAdapter1);
        type1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputtype = parent.getItemAtPosition(position).toString();
                convert();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        Spinner type2 = findViewById(R.id.type2);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Convert.getUnits(type));
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type2.setAdapter(arrayAdapter2);
        type2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                outputtype = parent.getItemAtPosition(position).toString();
                convert();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }
    public void convert(){
        try{
            double inp=Double.parseDouble(input.getText().toString());
            String res=Convert.convert(type,inputtype,outputtype,inp);
            result.setText(String.valueOf(res).replace("E","*10^"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
