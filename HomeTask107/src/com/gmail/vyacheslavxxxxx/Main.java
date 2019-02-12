package com.gmail.vyacheslavxxxxx;

import com.gmail.vyacheslavxxxxx.SqrtFourPow.EquationError;

public class Main {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        // 3.11 Реализация интерфейса Comparator*
        Triangle[] a = { new Triangle(2, 7, 5), new Triangle(5, 3, 3), new Triangle(3, 4, 2) };
        java.util.Arrays.sort(a, new CompareTriangleByArea());

        System.out.println(java.util.Arrays.toString(a));
        // 3.9 Использование ограниченных подстановочных типов*
        Double[] arr = new Double[4];
        arr[0] = 2.5;
        arr[1] = -1.0;
        arr[2] = 0.0;
        arr[3] = -0.2;

        Integer[] arr2 = new Integer[3];
        arr2[0] = 5;
        arr2[1] = 3;
        arr2[2] = 3;

        System.out.println(java.util.Arrays.toString(MyArray.add(arr, arr2)));
        // 3.8 Библиотека функций для работы с массивом чисел*
        System.out.println(LibraryFunction.countNegativeNumber(arr));
        System.out.println(LibraryFunction.lastNegativeNumber(arr));

        try {
            System.out.println(LibraryFunction.firstZero(arr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 3.7 Библиотека обобщенных функций*
        LibraryGenericFunction.swap(arr, 1, 0);
        LibraryGenericFunction.sortDesc(arr);
        System.out.println(java.util.Arrays.toString(arr));

        System.out.println(LibraryGenericFunction.contains(arr2, 3));
        // 3.5 Реализация интерфейса AutoCloseable*
        try (ArrayAutoCloseable arrayAutoCloseable = new ArrayAutoCloseable(new Double[2])) {
            arrayAutoCloseable.add(2.2);
            arrayAutoCloseable.add(3.2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 3.4 Функция вычисления корня четвертой степени*
        try {
            System.out.println(SqrtFourPow.sqrt(-4));
        } catch (EquationError e) {
            e.printStackTrace();
        }
        // 3.3 Перечисление для описания месяцев года*s
        System.out.println(Month.FEBRUARY.toStringRussian());
        System.out.println(Month.FEBRUARY.next().name());
        System.out.println(Month.FEBRUARY.previous().name());
        System.out.println(Month.FEBRUARY);

    }

}
