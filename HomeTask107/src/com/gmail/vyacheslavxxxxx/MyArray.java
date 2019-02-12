package com.gmail.vyacheslavxxxxx;

public class MyArray<T> {

    @SuppressWarnings("unchecked")
    public static <T> T[] add(T[] source, Integer[] filler) {
	T[] temp = (T[]) new Object[source.length + filler.length];
	System.arraycopy(source, 0, temp, 0, source.length);

	for (int i = 0; i < filler.length; i++) {
	    temp[source.length + i] = (T) filler[i];
	}
	source = temp;
	
	return source;
    } 
}
