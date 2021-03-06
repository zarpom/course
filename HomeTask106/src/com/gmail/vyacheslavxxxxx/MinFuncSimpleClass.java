package com.gmail.vyacheslavxxxxx;

public class MinFuncSimpleClass {
    public double f(double x) {
        return x * x - 2;
    }

    public double serachMin(double a, double b) throws Exception {
        if (a > b) {
            throw new Exception("'a' must be '<' b");
        }
        double step = (b + a) / 100.0;
        double min = f(a);
        for (double i = a; i < b; i += step) {
            double newMin = f(i);
            min = newMin < min ? newMin : min;
        }
        return min;
    }
    
}
