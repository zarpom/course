package com.gmail.vyacheslavxxxxx;

public class SortItems {
    public int[] sortAsc(int arr[]) {
        for (int i = 0; i < 4 - 1; i++) {
            for (int j = 0; j < 4 - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] sortDesc(int arr[]) {
        int size = arr.length -1 ;
        for (int i = size - 3; i < size; i++) {
            for (int j = size - 3; j <  size; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
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
        SortItems sortItems = new SortItems();
        sortItems.sortAsc(array);
        sortItems.sortDesc(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
