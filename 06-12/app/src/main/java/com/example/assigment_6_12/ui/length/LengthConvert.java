package com.example.assigment_6_12.ui.length;

import java.util.ArrayList;
import java.util.HashMap;

public class LengthConvert {
    public static final String km="Kilometre (km)";
    public static final String m="Metre (m)";
    public static final String dm="Decimetre (dm)";
    public static final String cm="Centimetre (cm)";
    public static final String mm="millimetre (mm)";
    public static final String um="Micrometre (um)";
    public static final String nm="Nanometre (nm)";
    HashMap<String,Double> value;
    public LengthConvert(){
        value=new HashMap<>();
        value.put(km,Math.pow(10.0,3.0));
        value.put(m,1.0);
        value.put(dm,Math.pow(10,-1));
        value.put(cm,Math.pow(10,-2));
        value.put(mm,Math.pow(10,-3));
        value.put(um,Math.pow(10,-6));
        value.put(nm,Math.pow(10,-9));
    }
    public String convert(String inputtype,String outputtype,Double input){
        return String.valueOf(input*value.get(inputtype)/value.get(outputtype));
    }
    public static ArrayList<String> getUnitsName(){
        ArrayList<String> list=new ArrayList<>();
        list.add(km);
        list.add(m);
        list.add(dm);
        list.add(cm);
        list.add(mm);
        list.add(mm);
        list.add(um);
        list.add(nm);
        return list;
    }
}
