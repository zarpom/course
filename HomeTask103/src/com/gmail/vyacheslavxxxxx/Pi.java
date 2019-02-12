package com.gmail.vyacheslavxxxxx;

/*3.8 Вычисление π*
Реализовать и протестировать функцию, которая вычисляет π с точностью до заданного ε по следующей формуле.
Параметром функции должна быть точность (ε). Вычисление должно прекращаться,
 если очередное слагаемое меньше ε по абсолютной величине.
  Реализовать два варианта - с использованием цикла и с использованием рекурсии.*/
public class Pi {
    public double calculatePi(double e) {
        double addend = 1;
        double pi = 0;

        for (int i = 0, base = 2; Math.abs(addend) > e; i++, base += 2) {
            addend = (i % 2 == 0 ? 1 : -1) * 4.0 / (base * (base + 1) * (base + 2));
            pi += addend;
        }

        pi += 3;
        return pi;
    }

    public double calculatePi(double exp, int i, int base, double pi, double addend) {

        if (Math.abs(addend) > exp) {
            addend = (i % 2 == 0 ? 1 : -1) * 4.0 / (base * (base + 1) * (base + 2));
            return addend + calculatePi(exp, ++i, base + 2, pi, addend);
        } else {
            return pi + 3;
        }
    }

    public double calculatePiRec(double exp) {
        return calculatePi(exp, 0, 2, 0, 0.166666666);
    }
}