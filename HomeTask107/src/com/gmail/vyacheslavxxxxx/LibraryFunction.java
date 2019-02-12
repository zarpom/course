package com.gmail.vyacheslavxxxxx;

public class LibraryFunction<T extends Number> {

    public static <T extends Number> int firstZero(T[] array) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i].doubleValue() == 0) {
                return i;
            }
        }
        throw new Exception("Doesn't have an \"0\"");
    }

    public static <T extends Number> int countNegativeNumber(T[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].doubleValue() < 0) {
                count++;
            }
        }
        return count;
    }

    public static <T extends Number> T lastNegativeNumber(T[] array) {
        T lastNegativeNumber = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].doubleValue() < 0) {
                lastNegativeNumber = array[i];
            }
        }
        return lastNegativeNumber;
    } 
}
