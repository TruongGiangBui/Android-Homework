package com.example.myapplication;

import java.util.ArrayList;

public class Convert {
    public static final String CURRENCY="CURRENCY";
    public static final String LENGTH="LENGTH";
    public static final String VOLUME="VOLUME";
    public static final String MASS="MASS";
    public static final String AREA="AREA";
    public static final String SPEED="SPEED";

    public static String convert(String option,String inputtype,String outputtype,double input){
        switch (option){
            case CURRENCY:{
                CurrencyConvert currencyConvert=new CurrencyConvert();
                return currencyConvert.convert(inputtype,outputtype,input);
            }
            case LENGTH:{
                LengthConvert lengthConvert=new LengthConvert();
                return lengthConvert.convert(inputtype,outputtype,input);
            }
            case MASS:{
                MassConvert massConvert=new MassConvert();
                return massConvert.convert(inputtype,outputtype,input);
            }
            case SPEED:{
                SpeedConvert speedConvert=new SpeedConvert();
                return speedConvert.convert(inputtype,outputtype,input);
            }
            case AREA:{
                AreaConvert areaConvert=new AreaConvert();
                return areaConvert.convert(inputtype,outputtype,input);
            }
            default:return "";
        }
    }
    public static ArrayList<String> getUnits(String type){
        switch (type){
            case CURRENCY:
                return CurrencyConvert.getUnitsName();
            case LENGTH:
                return LengthConvert.getUnitsName();
            case MASS:
                return MassConvert.getUnitsName();
            case SPEED:
                return SpeedConvert.getUnitsName();
            case AREA:
                return AreaConvert.getUnitsName();
            default:
                return new ArrayList<>();
        }
    }

}
