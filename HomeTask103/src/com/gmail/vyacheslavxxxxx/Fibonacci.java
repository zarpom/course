package com.gmail.vyacheslavxxxxx;

/*3.7 Определение чисел Фибоначчи*
Реализовать программу поиска чисел Фибоначчи:

F(1) = F(2) = 1; F(n) = F(n - 2) + F(n - 1)
Поиск n-го числа Фибоначчи осуществлять в отдельной функции. 
В функции main() осуществить ввод номера числа и вывод всех чисел Фибоначчи до
 введенного номера включительно. Реализовать два варианта - с использованием цикла и с использованием рекурсии.*/
public class Fibonacci {
    int fiboRec(int n) {
        int[] cache = new int[100];

        if (cache[n] == 0) {
            if (n == 1 || n == 2) {
                cache[n] = 1;
            } else {
                cache[n] = fibo(n - 1) + fibo(n - 2);
            }
        }

        return cache[n];
    }

    int fibo(int n) {
        int[] cache = new int[100];

        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n - 1];
    }

}
