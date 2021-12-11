package com.example.assigment_6_12.ui.calc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.assigment_6_12.R;
import com.example.assigment_6_12.databinding.FragmentCalcBinding;

import java.util.regex.Pattern;

public class CalcFragment extends Fragment {

    private FragmentCalcBinding binding;
    private int mCount = 0;
    private TextView input;
    private TextView output;
    private StringBuilder stringBuilder;
    private String param1;
    private String param2;
    private String operator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_calc, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        stringBuilder=new StringBuilder();
        input=getView().findViewById(R.id.input);
        output=getView().findViewById(R.id.output);
        Button c = (Button) view.findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonC(v);
            }
        });

        Button del = (Button) view.findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                del(v);
            }
        });

        Button equal = (Button) view.findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                caculate(v);
            }
        });
        View.OnClickListener addnumber=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(view);
            }
        };
        View.OnClickListener addsymbol=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSymbol(view);
            }
        };
        Button num0=(Button) view.findViewById(R.id.num0);
        num0.setOnClickListener(addnumber);
        Button num1=(Button) view.findViewById(R.id.num1);
        num1.setOnClickListener(addnumber);
        Button num2=(Button) view.findViewById(R.id.num2);
        num2.setOnClickListener(addnumber);
        Button num3=(Button) view.findViewById(R.id.num3);
        num3.setOnClickListener(addnumber);
        Button num4=(Button) view.findViewById(R.id.num4);
        num4.setOnClickListener(addnumber);
        Button num5=(Button) view.findViewById(R.id.num5);
        num5.setOnClickListener(addnumber);
        Button num6=(Button) view.findViewById(R.id.num6);
        num6.setOnClickListener(addnumber);
        Button num7=(Button) view.findViewById(R.id.num7);
        num7.setOnClickListener(addnumber);
        Button num8=(Button) view.findViewById(R.id.num8);
        num8.setOnClickListener(addnumber);
        Button num9=(Button) view.findViewById(R.id.num9);
        num9.setOnClickListener(addnumber);

        Button dot=(Button) view.findViewById(R.id.dot);
        dot.setOnClickListener(addsymbol);

        Button plus=(Button) view.findViewById(R.id.plus);
        plus.setOnClickListener(addsymbol);

        Button minus=(Button) view.findViewById(R.id.minus);
        minus.setOnClickListener(addsymbol);

        Button multiply=(Button) view.findViewById(R.id.multiply);
        multiply.setOnClickListener(addsymbol);

        Button divide=(Button) view.findViewById(R.id.divide);
        divide.setOnClickListener(addsymbol);

        Button frac=(Button) view.findViewById(R.id.frac);
        frac.setOnClickListener(addsymbol);

        Button exp=(Button) view.findViewById(R.id.exp);
        exp.setOnClickListener(addsymbol);

        Button sqrt=(Button) view.findViewById(R.id.sqrt);
        sqrt.setOnClickListener(addsymbol);

        Button percent=(Button) view.findViewById(R.id.percent);
        percent.setOnClickListener(addsymbol);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mFrgAct = getActivity();
//        mIntent = mFrgAct.getIntent(); //  Intent intent = new Intent(getActivity().getIntent());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void del(View view){
        if (stringBuilder.length()>0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            input.setText(stringBuilder.toString());
        }
    }
    public void buttonC(View view){
        stringBuilder.setLength(0);
        input.setText(stringBuilder.toString());
    }
    public void addNumber(View view) {
        switch (view.getId()){
            case R.id.num0:
                stringBuilder.append(0);
                break;
            case R.id.num1:
                stringBuilder.append(1);
                break;
            case R.id.num2:
                stringBuilder.append(2);
                break;
            case R.id.num3:
                stringBuilder.append(3);
                break;
            case R.id.num4:
                stringBuilder.append(4);
                break;
            case R.id.num5:
                stringBuilder.append(5);
                break;
            case R.id.num6:
                stringBuilder.append(6);
                break;
            case R.id.num7:
                stringBuilder.append(7);
                break;
            case R.id.num8:
                stringBuilder.append(8);
                break;
            case R.id.num9:
                stringBuilder.append(9);
                break;
        }
        input.setText(stringBuilder.toString());
    }
    public void addSymbol(View view){
        if(view.getId()!=R.id.dot) {
            param1=stringBuilder.toString();
        }
        switch (view.getId()){
            case R.id.dot: {
                stringBuilder.append(".");
                operator=".";
            }
            break;
            case R.id.multiply: {
                stringBuilder.append("x");
                operator="x";
            }
            break;
            case R.id.divide: {
                stringBuilder.append("÷");
                operator="÷";
            }
            break;
            case R.id.plus: {
                stringBuilder.append("+");
                operator="+";
            }
            break;
            case R.id.minus: {
                stringBuilder.append("-");
                operator="-";
            }
            break;
            case R.id.percent: {
                stringBuilder.append("%");
                operator="%";
            }
            break;
            case R.id.sqrt: {
                stringBuilder.append("√");
                operator="√";
            }
            break;
            case R.id.exp: {
                stringBuilder.append("^");
                operator="exp";
            }
            break;
            case R.id.frac: {
                {
                    stringBuilder.append("1/");
                    operator="1/";
                }
                break;
            }
        }
        input.setText(stringBuilder.toString());
    }
    public void caculate(View view){
        String text=stringBuilder.toString();
        if(Pattern.matches("[-]?[0-9]+[\\.]*[0-9]*[x÷+\\-^][-]?[0-9]+[\\.]*[0-9]*",text)){
            String result="0";
            if(text.contains("+")){
                text=text.replace("+","_");

                if(text.contains(".")){
                    result=String.valueOf(Math.floor((Double.valueOf(text.split("_")[0])+Double.valueOf(text.split("_")[1])) * 100000000) / 100000000);
                }else {
                    result=String.valueOf(Integer.valueOf(text.split("_")[0])+Integer.valueOf(text.split("_")[1]));
                }
            }else if(text.contains("-")){
                String p1,p2;
                if(text.contains("--")){
                    p2=text.split("--")[1];
                    p1=text.split("--")[0];
                    if(text.contains("."))
                        result=String.valueOf(Math.floor((Double.valueOf(p1)+Double.valueOf(p2)) * 100000000) / 100000000);
                    else
                        result=String.valueOf(Integer.valueOf(p1)+Integer.valueOf(p2));
                }else {
                    if(text.substring(0,1).equals("-")){
                        text=text.substring(1,text.length());
                        text=text.replace("-","_");
                        if(text.contains(".")){
                            result=String.valueOf(Math.floor((-Double.valueOf(text.split("_")[0])-Double.valueOf(text.split("_")[1])) * 100000000) / 100000000);
                        }else {
                            result=String.valueOf(-Integer.valueOf(text.split("_")[0])-Integer.valueOf(text.split("_")[1]));
                        }
                    }else {
                        text=text.replace("-","_");
                        if(text.contains(".")){
                            result=String.valueOf(Math.floor((Double.valueOf(text.split("_")[0])-Double.valueOf(text.split("_")[1])) * 100000000) / 100000000);
                        }else {
                            result=String.valueOf(Integer.valueOf(text.split("_")[0])-Integer.valueOf(text.split("_")[1]));
                        }
                    }
                }
            }
            else if(text.contains("x")){
                text=text.replace("x","_");
                if(text.contains(".")){
                    result=String.valueOf(Math.floor((Double.valueOf(text.split("_")[0])*Double.valueOf(text.split("_")[1])) * 100000000) / 100000000);
                }else {
                    result=String.valueOf(Integer.valueOf(text.split("_")[0])*Integer.valueOf(text.split("_")[1]));
                }
            }else if(text.contains("÷")){
                text=text.replace("÷","_");
                result=String.valueOf(Math.floor((Double.valueOf(text.split("_")[0])/Double.valueOf(text.split("_")[1])) * 100000000) / 100000000);
            }
            else if(text.contains("^")){
                text=text.replace("^","_");
                result=String.valueOf(Math.floor(Math.pow(Double.valueOf(text.split("_")[0]),Double.valueOf(text.split("_")[1]))));
            }
            output.setText(result);
        }
    }

}