package com.gmail.vyacheslavxxxxx;

public class Fibonacci {
    static long[] cache = new long[92];

    static long fibo(int n) {
        cache[0] = 0;
        cache[1] = 1;
        if (cache[n] == 0) {
            for (int i = 2; i <= n + 1; i++) {
                cache[i] = cache[i - 1] + cache[i - 2];
                if (i == n) {
                    long[] trimToSizeCache = new long[n + 1];
                    System.arraycopy(cache, 0, trimToSizeCache, 0, n + 1);
                    return trimToSizeCache[n];
                }
            }
        }
        return cache[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibo(0));
        System.out.println(fibonacci.fibo(5));
    }
}