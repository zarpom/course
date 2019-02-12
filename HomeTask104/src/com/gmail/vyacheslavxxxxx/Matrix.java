package com.gmail.vyacheslavxxxxx;

public class Matrix {

    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) throws Exception {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;
        if (m1ColLength != m2RowLength)
            throw new Exception("column of first matrix and row of second matrix does not equal");
        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {
            for (int j = 0; j < mRColLength; j++) {
                for (int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    public static int[] size(double[][] matrix) {
        int[] size = new int[2];
        size[0] = matrix.length;
        size[1] = matrix[0].length;
        return size;

    }

    public static String toString(double[][] m) {
        String result = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result += String.format("%11.2f", m[i][j]);
            }
            result += "\n";
        }
        return result;
    }
}