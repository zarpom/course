package com.gmail.vyacheslavxxxxx;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 3.2 Работа с календарем*
        Person person = new Person();
        Calendar calendar = new GregorianCalendar();
        calendar.set(1996, Calendar.MARCH, 5);
        person.setDateOfBirth(calendar);
        System.out.println("person age:" + person.age());
        // 3.1 Использование класса BigInteger*
        Random random = new Random();
        long randomNumber = random.nextLong();
        BigInteger bigInteger = new BigInteger("" + randomNumber);

        BigIntegerPow bigIntegerPow = new BigIntegerPow(); 
        System.out.println("Big integer data");
        System.out.println(bigInteger);
        System.out.println("Big integer with BigInteger.class");
        System.out.println(bigIntegerPow.pow(bigInteger, 10));

        System.out.println("Big integer with longer");
        System.out.println(bigIntegerPow.customPow(bigInteger, 10));
    }
}
