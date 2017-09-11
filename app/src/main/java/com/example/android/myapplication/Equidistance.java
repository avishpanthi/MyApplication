package com.example.android.myapplication;

/**
 * Created by Sanz on 10/09/2017.
 */

public class Equidistance {
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    public double result;

    public Equidistance(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public double calculate(){
       double calc = Math.pow(2,(x2-x1))+Math.pow(2,(y2-y1));
        result = Math.sqrt(calc);
        return result;
    }

}
