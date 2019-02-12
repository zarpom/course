package com.gmail.vyacheslavxxxxx;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerPow {

    BigInteger pow(BigInteger bigInteger, int exponent) {
        return bigInteger.pow(exponent);
    }

    String customPow(BigInteger bigInteger, int exponent) {
        BigInteger finalNumber = new BigInteger(bigInteger.toString());

        for (int i = 1; i < exponent; i++) {
            finalNumber = (finalNumber.multiply(bigInteger));
        }
        return finalNumber.toString();
    }

    public static void main(String[] args) {
        // 3.1 Использование класса BigInteger*
        Random random = new Random();
        BigInteger bigInteger = new BigInteger("" + 884);
        BigIntegerPow bigIntegerPow = new BigIntegerPow();

        System.out.println(bigIntegerPow.pow(bigInteger, 22));
        System.out.println(bigIntegerPow.customPow(bigInteger, 22));

    }
}
