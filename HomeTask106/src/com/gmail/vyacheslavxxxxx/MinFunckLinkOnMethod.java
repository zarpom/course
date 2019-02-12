package com.gmail.vyacheslavxxxxx;

import java.util.function.DoubleUnaryOperator;

public class MinFunckLinkOnMethod {
    public static double serachMin(double a, double b, DoubleUnaryOperator func) throws Exception {
        if (a > b) {
            throw new Exception("'a' must be '<' b");
        }
        double step = (b + a) / 100.0;
        double min = func.applyAsDouble(a);
        for (double i = a; i < b; i += step) {
            double newMin = func.applyAsDouble(i);
            min = newMin < min ? newMin : min;
        }
        return min;
    }
    
    public static void main(String[] args) {

        try {
            System.out.println("Минимум функции:" +  serachMin(1, 2, Math::cos));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
