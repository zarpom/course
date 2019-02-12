package com.gmail.vyacheslavxxxxx;

public class ArrayAutoCloseable<T> implements AutoCloseable {
    private T[] array;
    private int index = 0;

    public ArrayAutoCloseable(T[] array) {
        super();
        this.array = array;
    }

    public void add(T value) {
        array[index++] = value;
    }

    @Override
    public void close() throws Exception {
        System.out.println(java.util.Arrays.toString(array));
    }
}
