package com.gmail.vyacheslavxxxxx;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pi pi = new Pi();

        System.out.printf("Pi циклом        = %f %n", pi.calculatePi(0.01));
        System.out.printf("Pi рекурсией     = %f %n", pi.calculatePiRec(0.01));

        Fibonacci fib = new Fibonacci();

        @SuppressWarnings("resource")
        Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Введите предельное число для последовательности Фибоначчи:");

        if (sc.hasNextInt()) {
            int inputNumber = sc.nextInt();
            for (int i = 1; i <= inputNumber; i++) {
                System.out.printf("%d-e число циклом     = %d %n", i, fib.fibo(i));
                System.out.printf("%d-e число рекурсивно = %d %n", i, fib.fiboRec(i));
            }
        }

        Binary binary = new Binary();
        System.out.println("Двоичное представление числа 100, обратное");
        for (byte b : binary.intToBinaryReverse(100)) {
            System.out.print(b);
        }
        System.out.println();
        System.out.println("Двоичное представление числа 100 (без нулей в начале)");
        for (byte b : binary.intToBinaryWithoutZero(100)) {
            System.out.print(b);
        }
        System.out.println();

        Power power = new Power();
        System.out.print("Введите, пожалуйста, предельную степень для числа 8 (число от 1 до 10):");
        if (sc.hasNextInt()) {
            int inputNumber = sc.nextInt();

            for (double d : power.getRangeEightPower(inputNumber)) {
                System.out.println(d);
            }
            System.out.println("Степени числа 8 (побитовые операции):");
            for (double d : power.getRangeEightPowerBinary(inputNumber)) {
                System.out.println(d);
            }

        }

    }
}
