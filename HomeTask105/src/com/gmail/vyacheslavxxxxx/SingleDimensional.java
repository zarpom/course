package com.gmail.vyacheslavxxxxx;

public class SingleDimensional extends AbstractArrayOfPoints {
    double[] array;
    int count = 0;

    @Override
    public void setPoint(int i, double x, double y) {
        array[(i * 2)] = x;
        array[(i * 2) + 1] = y;
    }

    @Override
    public double getX(int i) {
        return array[(i * 2)];
    }

    public SingleDimensional() {
        super();
        this.array = new double[7 * 2];
    }

    public SingleDimensional(int size) {
        super();
        this.array = new double[size * 2];
    }

 

    @Override
    public double getY(int i) {
        return array[(i * 2) + 1];
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public void addPoint(double x, double y) {
        if (this.count < this.array.length) {
            this.setPoint(this.count, x, y);
            count++;
        }
    }

    @Override
    public void removeLast() {
        if (this.count > 1) {
            this.array[this.count - 2] = 0;
            this.array[this.count - 1] = 0;
            --this.count;
        }
    }

    public void sortByX() {
        {
            int min;
            double tempX, tempY;

            for (int index = 0; index < array.length - 1; index += 2) {
                min = index;
                for (int scan = index + 2; scan < array.length; scan += 2) {
                    if (array[scan] < array[min])
                        min = scan;
                }
                tempX = array[min];
                array[min] = array[index];
                array[index] = tempX;

                tempY = array[min + 1];
                array[min + 1] = array[index + 1];
                array[index + 1] = tempY;

            }
        }
    }
}
