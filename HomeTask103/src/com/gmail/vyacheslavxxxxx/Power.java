package com.gmail.vyacheslavxxxxx;

public class Power {

    public double[] getRangeEightPower(int power) {

        double powRange[] = new double[power];
        powRange[0] = 1;

        for (int i = 1; i < power; i++) {
            powRange[i] = 8;
            for (int j = 1; j < i; j++) {
                powRange[i] *= 8;
            }
        }
        return powRange;
    }

    public double[] getRangeEightPowerBinary(int power) {
        double powRange[] = new double[power];
        powRange[0] = 1;
        int n = 0;
        for (int i = 1; i < power; i++) {
            powRange[i] = 8 << n;
            n += 3;
        }

        return powRange;
    }

}
