package com.gmail.vyacheslavxxxxx;

public class Sqrt {
    public static Double stupidSqrt(Double d) {
        double t;
        double squareRoot = d / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (d / t)) / 2;
        } while ((t - squareRoot) != 0);
        return squareRoot;
    }

    public static void main(String[] args) {
        System.out.println(stupidSqrt(4.5));
    }
}
