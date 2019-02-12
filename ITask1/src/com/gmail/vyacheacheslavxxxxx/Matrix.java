package com.gmail.vyacheacheslavxxxxx;

import java.util.Arrays;

public class Matrix extends BaseMatrix {
    private int row;
    private int column;
    private double[][] data;

    public Matrix(int row, int column) {
        this.data = new double[row][column];
        this.row = row;
        this.column = column;
    }

    public BaseMatrix getInstanse(int row, int column) {
        return new Matrix(row, column);
    }

    public void setEl(int i, int j, double value) {
        data[i][j] = value;
    }

    public double getEl(int i, int j) {
        return data[i][j];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {

        this.data = Arrays.copyOf(data, data.length);
        ;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                result += String.format("%11.2f", data[i][j]);
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {

        double[][] data = new double[][] { { 3, -1, 2, 1 }, { 2, 0, 1, 1 }, { 1, 2, 1, 1 }, { 1, 22, 1, 1 } };
        double[][] data2 = new double[][] { { 2, -1, 1, 2 }, { 0, -2, 3, 3 }, { 3, 10, 1, 4 }, { 2, -1, 1, 2 } };

        Matrix matrix = new Matrix(4, 4);
        Matrix matrix2 = new Matrix(4, 4);

        matrix.setData(data);
        matrix2.setData(data2);

        Matrix invert = (Matrix) matrix.invert(matrix);
        Matrix mul = null;
        Matrix mulInvert = null;
        try {
            mul = (Matrix) matrix.multiplyByMatrix(matrix, matrix2);
            mulInvert = (Matrix) matrix.multiplyByMatrix(invert, matrix);
        } catch (Exception e) { 
            e.printStackTrace();
        }
       
        System.out.println("матрица 1");
        System.out.println(matrix);
        System.out.println("матрица 2");
        System.out.println(matrix2);
        System.out.println("Оприделитель 1=" + matrix.determinant(matrix));
        System.out.println("Оприделитель 2=" + matrix.determinant(matrix2));

        System.out.println("Умножение матриц");
        System.out.println(mul);
        System.out.println("Обратная 1");
        System.out.println(invert);
        System.out.println("Умножение матрицы 1 на обратную");
        System.out.println(mulInvert);

    }
}