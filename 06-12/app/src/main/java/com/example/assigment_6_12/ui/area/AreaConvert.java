package com.example.assigment_6_12.ui.area;

import java.util.ArrayList;
import java.util.HashMap;

public class AreaConvert {
    HashMap<String,Double> value;
    public static final String Km2="Square kilometre (km²)";
    public static final String Ha="Hectare (ha)";
    public static final String A="Are (a)";
    public static final String M2="Square metre (m²)";
    public static final String Dm2="Square decimetre (dm²)";
    public static final String Cm2="Square centimetre (cm²)";
    public static final String Mm2="Square millimetre (mm²)";
    public AreaConvert(){
        value=new HashMap<>();
        value.put(Km2,Math.pow(10,6));
        value.put(Ha,Math.pow(10,4));
        value.put(A,100.0);
        value.put(M2,1.0);
        value.put(Dm2,Math.pow(10,-2));
        value.put(Cm2,Math.pow(10,-4));
        value.put(Mm2,Math.pow(10,-6));
    }
    public String convert(String inputtype,String outputtype,Double input){
        return String.valueOf(input*value.get(inputtype)/value.get(outputtype));
    }
    public static ArrayList<String> getUnitsName(){
        ArrayList<String> list=new ArrayList<>();
        list.add(Km2);
        list.add(Ha);
        list.add(A);
        list.add(M2);
        list.add(Dm2);
        list.add(Cm2);
        list.add(Mm2);
        return list;
    }
}
