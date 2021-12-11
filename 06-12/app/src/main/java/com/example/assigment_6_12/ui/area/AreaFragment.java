package com.example.assigment_6_12.ui.area;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.assigment_6_12.R;
import com.example.assigment_6_12.databinding.FragmentCalcBinding;

public class AreaFragment extends Fragment {
    private FragmentCalcBinding binding;
    private TextView result;
    String inputtype;
    String outputtype;
    private EditText input;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_area, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        result=getView().findViewById(R.id.result);
        input=getView().findViewById(R.id.input);
        input.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                convert();
            }


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        this.view=view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Spinner type1 = getView().findViewById(R.id.type1);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, AreaConvert.getUnitsName());
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
        Spinner type2 = getView().findViewById(R.id.type2);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,AreaConvert.getUnitsName());
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
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void convert(){
        try{
            double inp=Double.parseDouble(input.getText().toString());
//            String res= Convert.convert(type,inputtype,outputtype,inp);
            AreaConvert areaConvert=new AreaConvert();
            String res=areaConvert.convert(inputtype,outputtype,inp);
            result.setText(String.valueOf(res).replace("E","*10^"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
