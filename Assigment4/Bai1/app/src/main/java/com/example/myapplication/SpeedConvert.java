package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class SpeedConvert {
    HashMap<String,Double> value;
    public static final String Kms="Kilometre per second";
    public static final String Kmh="Kilometre per hour";
    public static final String Ms="Metre per second";
    public static final String Mms="Millimetre per second (mm/s)";
    public static final String Ums="Micrometre per second (µm/s)";
    public static final String Mls="Mile per second";
    public static final String Mlh="Mile per hour (mph)";
    public static final String Fs="Foot per second";


    public SpeedConvert(){
        value=new HashMap<>();
        value.put(Kms,1000.0);
        value.put(Kmh,0.28);
        value.put(Ms,1.0);
        value.put(Mms,Math.pow(10,3));
        value.put(Ums,Math.pow(10,6));
        value.put(Mls,Math.pow(10,-4)*6.21);
        value.put(Mlh,2.24);
        value.put(Fs,3.28);
    }
    public String convert(String inputtype,String outputtype,Double input){
        return String.valueOf(input*value.get(inputtype)/value.get(outputtype));
    }
    public static ArrayList<String> getUnitsName(){
        ArrayList<String> list=new ArrayList<>();
        list.add(Kms);
        list.add(Ms);
        list.add(Kmh);
        list.add(Mms);
        list.add(Ums);
        list.add(Mls);
        list.add(Mlh);
        list.add(Fs);
        return list;
    }
}
