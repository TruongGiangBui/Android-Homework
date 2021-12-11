package com.example.assigment_6_12.ui.mass;

import java.util.ArrayList;
import java.util.HashMap;

public class MassConvert {
    HashMap<String,Double> value;
    public static final String T="Ton";
    public static final String kN="KiloNewton (kN)";
    public static final String kg="Kilogram (kg)";
    public static final String g="Gram (g)";
    public static final String mg="Milligram (mg)";
    public static final String ug="Microgram (ug)";
    public static final String lb="Pound (lb)";
    public MassConvert(){
        value=new HashMap<>();
        value.put(T,1000.0);
        value.put(kN,101.97);
        value.put(kg,1.0);
        value.put(g,Math.pow(10,-3));
        value.put(mg,Math.pow(10,-6));
        value.put(ug,Math.pow(10,-9));
        value.put(lb,Math.pow(10,224.81));
    }
    public String convert(String inputtype,String outputtype,Double input){
        return String.valueOf(input*value.get(inputtype)/value.get(outputtype));
    }
    public static ArrayList<String> getUnitsName(){
        ArrayList<String> list=new ArrayList<>();
        list.add(T);
        list.add(kN);
        list.add(kg);
        list.add(g);
        list.add(mg);
        list.add(ug);
        list.add(lb);
        return list;
    }
}
