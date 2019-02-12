package com.gmail.vyacheslavxxxxx;

public class SqrtFourPow {

    @SuppressWarnings("serial")
    public static class EquationError extends Exception {
        public EquationError(double n) {
            super("Bad data=" + n);
        }
    }

    public static double sqrt(double n) throws EquationError {
        if (n < 0) {
            throw new EquationError(n);
        }
        return Math.pow(n, 1.0 / 4);
    }
}