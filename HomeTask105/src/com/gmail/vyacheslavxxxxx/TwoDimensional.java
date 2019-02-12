package com.gmail.vyacheslavxxxxx;

public class TwoDimensional extends AbstractArrayOfPoints {
    private double array[][];
    int count = 0;

    @Override
    public void setPoint(int i, double x, double y) {
        array[i][0] = x;
        array[i][1] = y;
    }
  

    @Override
    public double getX(int i) {
        return this.array[i][0];
    }

    public TwoDimensional(int size) {
        super();
        this.array = new double[size][2];
    }

    @Override
    public double getY(int i) {
        return this.array[i][1];
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public void addPoint(double x, double y) {
        if (this.count < this.array.length) {
            this.setPoint(this.count, x, y);
            ++this.count;
        }
    }

    @Override
    public void removeLast() {
        if (this.count > 1) {
            this.array[this.count - 1][0] = 0;
            this.array[this.count][0] = 0;
            --this.count;
        }

    }

}
