package com.gmail.vyacheslavxxxxx;

public class Matrix {
    private String name;
    private double[][] data;

    @Override
    public String toString() {
        String result = getName() + " \n";
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                result += String.format("%11.2f", data[i][j]);
            }
            result += "\n";
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Matrix matrix = new Matrix();
        matrix.setData(this.data);
        matrix.setName(this.getName());

        return matrix;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Matrix object = (Matrix) obj;

        if (!object.getName().equals(this.getName())) {
            return false;
        }
        if (this.getData().length != object.getData().length) {
            return false;
        }
        for (int i = 0; i < object.getData().length; i++) {
            for (int j = 0; j < object.getData().length; j++) {
                if (object.getData()[i][j] != this.getData()[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args)  {
      
    }
}
