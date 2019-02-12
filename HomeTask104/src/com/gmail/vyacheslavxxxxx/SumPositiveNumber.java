package com.gmail.vyacheslavxxxxx;

public class SumPositiveNumber {
    public double sumPositiveNumber(double[] array) {
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                sum = sum + array[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        double[] array = { -5, -4, -3, -2, -1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        SumPositiveNumber sumPositiveNumber = new SumPositiveNumber();
        System.out.println(sumPositiveNumber.sumPositiveNumber(array));
    }
}
