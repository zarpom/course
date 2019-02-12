package com.gmail.vyacheslavxxxxx;

import java.util.AbstractList;

public class MyArrayList<T> extends AbstractList<T> {
    private T[] array;
    private int startRange;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public MyArrayList(int start, int end) {
        super();
        this.array = (T[]) new Object[end - start];
        this.startRange = start;
    }

    @Override
    public T get(int index) {
        return array[index - this.startRange];
    }

    @Override
    public T set(int index, T element) {
        return array[index - this.startRange] = element;
    }

    @Override
    public int size() {

        return array.length;
    }

    public int getStartRange() {
        return startRange;
    }

    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }

    public int getEndRange() {
        return array.length + startRange;
    }

    public static void main(String[] args) {
        MyArrayList<Double> myArrayList = new MyArrayList<>(-2, 1);
        myArrayList.set(-2, new Double(123));
        for (int i = myArrayList.getStartRange(); i < myArrayList.getEndRange(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
