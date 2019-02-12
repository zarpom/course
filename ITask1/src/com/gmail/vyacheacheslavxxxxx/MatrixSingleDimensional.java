package com.gmail.vyacheacheslavxxxxx;

public class MatrixSingleDimensional extends BaseMatrix {
    private int row;
    private int column;
    private double[] data;

    @Override
    BaseMatrix getInstanse(int row, int column) {
        return new MatrixSingleDimensional(row, column);
    }

    public MatrixSingleDimensional() {
        super();
    }

    public MatrixSingleDimensional(int row, int column) {
        super();
        this.row = row;
        this.column = column;
        this.data = new double[row * column];
    }

    @Override
    public void setEl(int x, int y, double value) {
        data[x * this.row + y] = value;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public void setRow(int paramInt) {
        this.row = paramInt;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public void setColumn(int paramInt) {
        this.column = paramInt;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    @Override
    public double getEl(int x, int y) {
        return data[x * getRow() + y];
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < this.data.length; i++) {
            result += String.format("%6.2f", data[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] data = new double[][] { { 22, 8, 33, 3 }, { 55, 88, 77, 77 }, { 66, 66, 66, 66 }, { 5, 55, 55, 5 } };
        Matrix matrix = new Matrix(4, 4);
        matrix.setData(data);

        double[] data2 = new double[] { 22, 8, 33, 3, 55, 88, 77, 77, 66, 66, 66, 66, 5, 55, 55, 5 };
        MatrixSingleDimensional matrix2 = new MatrixSingleDimensional(3, 3);
        matrix2.setData(data2);

        System.out.println(matrix.getEl(0, 1));
        System.out.println(matrix2.getEl(0, 1));

        System.out.println(matrix.determinant(matrix));
        System.out.println(matrix2.determinant(matrix2));

        System.out.println("Инвертированные матрицы");
        System.out.println(matrix.invert(matrix));
        System.out.println(matrix2.invert(matrix2));

        System.out.println("Перемножение инверсии и обычного");
        try {
            System.out.println(matrix.multiplyByMatrix(matrix.invert(matrix), matrix));
            System.out.println(matrix2.multiplyByMatrix(matrix2.invert(matrix2), matrix2));
        } catch (Exception e) { 
            e.printStackTrace();
        }

    }

}
