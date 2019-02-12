package com.gmail.vyacheslavxxxxx;

public class Sieve {
    String sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                sb.append(i).append(" ");

        }
        return sb.toString();
    }
}
