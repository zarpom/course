package com.gmail.vyacheslavxxxxx;

public class InsertionSort {
    public static void insertSort(int[] arr) {
        int temp, j;
        for(int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i + 1]) {
               temp = arr[i + 1];
               arr[i + 1] = arr[i];      
               j = i;
               while (j > 0 && temp < arr[j - 1]) {
                   arr[j] = arr[j - 1];               
                   j--;
               }
               arr[j] = temp;             
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
        InsertionSort insertionSort =  new InsertionSort(); 
        insertionSort.insertSort(array); 
        for (int i : array) {
            System.out.println(i);
        }
    }
}
