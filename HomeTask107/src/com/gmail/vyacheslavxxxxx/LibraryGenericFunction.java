package com.gmail.vyacheslavxxxxx;

public class LibraryGenericFunction<T> {

    public static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    public static <T> void sortDesc(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static <T> int contains(T[] array, T value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Double[] arr = new Double[4];
        arr[0] = 3d;
        arr[1] = 2d;
        arr[2] = 4d;
        arr[3] = 1d;

        System.out.println(java.util.Arrays.toString(arr));
        LibraryGenericFunction.sortDesc(arr);
//      LibraryGenericFunction.swap(arr, 1, 0);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
