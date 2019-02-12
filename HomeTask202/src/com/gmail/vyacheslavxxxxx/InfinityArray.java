package com.gmail.vyacheslavxxxxx;

import java.util.Iterator;

public class InfinityArray implements Iterable<Double> {
    private double[] source;
    int count;

    public double[] getSource() {
        return source;
    }

    public double getItem(int index) {
        if (index > this.source.length - 1) {
            this.source = new double[index + 1];

        }
        return this.source[index];
    }

    public void add(int index, double value) {
        if (index > this.source.length - 1) {
            double[] temp = new double[index + 1];
            System.arraycopy(source, 0, temp, 0, this.source.length);
            this.source = temp;
        }
        source[index] = value;
        this.count++;
    }

    public int count() {
        return this.count;

    }

    public InfinityArray() {
        super();
        source = new double[1];
    }

    public void setSource(double[] source) {
        this.source = source;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < this.source.length; i++) {
            result += String.format("%6.2f", source[i]);
        }
        return result;
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return (current < source.length);
            }

            @Override
            public Double next() {
                return source[current++];
            }
        };
    }

    public static void main(String[] args) {
        InfinityArray infinityArray = new InfinityArray();
        infinityArray.add(10, 1);
        infinityArray.add(12, 2);
        infinityArray.getItem(1000);
        System.out.println(infinityArray.getItem(10));
        System.out.println(infinityArray);
        System.out.println(infinityArray.count());

    }
}
