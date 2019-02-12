package com.gmail.vyacheslavxxxxx;

public class Main {
    public static void main(String[] args) {
        // 3.10 Минимум функции*
        SpecificFunc se = new SpecificFunc();
        try {
            System.out.println(se.serachMin(1, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.11 Матрица*
        double[][] m = new double[][] { { 3, -1, 2 }, { 2, 0, 1 }, { 1, 2, 1 } };
        double[][] m2 = new double[][] { { 3, -1, 2 }, { 2, 0, 1 }, { 1, 2, 1 } };

        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();

        matrix.setData(m);
        matrix.setName("Lol");
        matrix2.setData(m2);
        matrix2.setName("Lol");

        System.out.println(matrix.equals(null));
        System.out.println(matrix.toString());
        try {
            System.out.println(matrix.clone());
        } catch (CloneNotSupportedException e) { 
            e.printStackTrace();
        }
        //3.9 Реализация массива точек через одномерный массив вещественных чисел*

        SingleDimensional singleDimensional = new SingleDimensional(4);
        singleDimensional.test();
        //3.8 Реализация массива точек через двумерный массив*
        TwoDimensional twoDimensional = new TwoDimensional(4);
        twoDimensional.test();

    }
}
