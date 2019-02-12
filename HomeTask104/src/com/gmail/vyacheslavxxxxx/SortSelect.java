package com.gmail.vyacheslavxxxxx;

public class SortSelect {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 4;
        array[1] = 3;
        array[2] = 2;
        array[3] = 1;
        array[4] = 0;
        array[5] = 1;
        array[6] = 2;
        array[7] = 3;
        array[8] = 4;
        array[9] = 5;
        SortSelect sortSelect = new SortSelect();
        sortSelect.selectionSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
