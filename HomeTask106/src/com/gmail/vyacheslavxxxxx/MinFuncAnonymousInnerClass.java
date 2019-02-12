package com.gmail.vyacheslavxxxxx;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class MinFuncAnonymousInnerClass {
    public static void main(String[] args) throws Exception {
        MinFunc minFunc = new MinFunc() {
            @Override
            public double searchMin(double a, double b) throws Exception {
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

            @Override
            public double f(double a) {
                return a * a - 2;
            }

        };
        try {
            System.out.println(minFunc.searchMin(1, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(serachMin(0, 20, x -> x * x - 2)); 

        MinFuncAnonymousInnerClass anonymousInnerClass = new MinFuncAnonymousInnerClass(); 
    }

    public static double serachMin2(double a, double b) {
        double step = (b + a) / 100.0;
        double min = f(a);
        for (double i = a; i < b; i += step) {
            double newMin = f(i);
            min = newMin < min ? newMin : min;
        }
        return min;
    }

    public void print(DoubleBinaryOperator binaryOperator) {
        System.out.println(binaryOperator.applyAsDouble(0, 20));
    }

    public static double f(double x) {
        return x * x - 2;
    }



    public static double serachMin(double a, double b, MinFuncLambda func) throws Exception {
        if (a > b) {
            throw new Exception("'a' must be '<' b");
        }
        double step = (b + a) / 100.0;
        double min = func.f(a);
        for (double i = a; i < b; i += step) {
            double newMin = func.f(i);
            min = newMin < min ? newMin : min;
        }
        return min;
    }
}
