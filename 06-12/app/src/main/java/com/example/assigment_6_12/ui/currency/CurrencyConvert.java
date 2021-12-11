package com.example.assigment_6_12.ui.currency;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrencyConvert {
    public static final String JPY ="JPY - Japanese Yen";
    public static final String BGP="BGP - British Pound";
    public static final String EUR="EUR - Euro";
    public static final String USD="USD - US Dollar";
    public static final String VND="VND - Vietnam Dong";
    HashMap<String,String> names;
    HashMap<String,Double> value;
    public CurrencyConvert(){
        names=new HashMap<>();
        value=new HashMap<>();
        value.put(JPY,198.38 );
        value.put(BGP,30560.41);
        value.put(EUR,25643.05);
        value.put(USD,22653.04);
        value.put(VND,1.0);
    }
    public String convert(String inputtype,String outputtype,Double input){
        return String.valueOf(Math.round(100*input*value.get(inputtype)/value.get(outputtype))/100.0);
    }
    public static ArrayList<String> getUnitsName(){
        ArrayList<String> list=new ArrayList<>();
        list.add(JPY);
        list.add(BGP);
        list.add(EUR);
        list.add(USD);
        list.add(VND);
        return list;
    }
}
