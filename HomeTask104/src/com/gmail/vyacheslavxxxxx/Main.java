package com.gmail.vyacheslavxxxxx;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 3.22 Транслятор*
        System.out.println("Транслятор");
        Translator translator = new Translator();
        String text = "{ }  { }";
        System.out.println("Text:\n" + text);
        System.out.println("Баланс скобок в порядке=" + translator.isGoodBalanseCeurlyBracket(text));
        if (translator.isGoodBalanseCeurlyBracket(text)) {
            System.out.println(translator.replaceCeurlyBracket(text));
        }
        // 3.21 Форматирование текста*
        System.out.println("Форматирование текста:");
        Formatter formatter = new Formatter();
        System.out.println(formatter.format(
                "Мне мира нет и брани не подьемлю восторг и страх в груди огонь и лед заоблачный веду в мечтах полет и падаю низверженный на землю Мне мира нет и брани не подьемлю восторг и страх в груди огонь и лед заоблачный веду в мечтах полет и падаю низверженный на землю Мне мира нет и брани не подьемлю восторг и страх в груди огонь и лед заоблачный веду в мечтах полет и падаю низверженный на землю Мне мира нет и брани не подьемлю восторг и страх в груди огонь и лед заоблачный веду в мечтах полет и падаю низверженный на землю Мне мира нет и брани не подьемлю восторг и страх в груди огонь и лед заоблачный веду в мечтах полет и падаю низверженный на землю",
                50));
        // 3.20 Корректор*
        System.out.println("Корректор");
        String correctorText = "   Мне SUYt JJJ мира Нeт и брани не подьемлю,"
                + " восторг и страх в груди огонь и лед заоблачный"
                + " веду в мечтах полет и падаю низверженный на землю ыв ъвыв";
        Corrector corrector = new Corrector();
        System.out.println(corrector.correct(correctorText));
        System.out.println(corrector.wordsOnFirstLetter(correctorText, 'ъ'));
        // 3.19 Аббревиатура*
        System.out.println("Аббревиатура");
        Abbreviation abbreviation = new Abbreviation();
        Scanner sc = new java.util.Scanner(System.in);
        if (sc.hasNextLine()) {
            System.out.println(abbreviation.abbreviation(sc.nextLine()));
        }
        // 3.17 Удаление слов*
        System.out.println("Удаление слова");
        System.out.println("Введите текст");
        String textForDelete = "";
        if (sc.hasNext()) {
            textForDelete = sc.nextLine();
        }
        System.out.println("Введите набор символов через пробел для удаления слов");
        String symbols = "";
        if (sc.hasNext()) {
            symbols = sc.nextLine();
        }
        WordsDeleter wordDeleter = new WordsDeleter();
        System.out.println(wordDeleter.deleteWords(textForDelete, symbols.split(" ")));
        // 3.10 Эратосфеново решето*
        Sieve g = new Sieve();
        System.out.println("Эратосфеново решето");
        System.out.println(g.sieveOfEratosthenes(300));
        // 3.13 Вычисление чисел Фибоначчи* до 91
        System.out.println("Фибоначчи числа 55 включительно");
        Fibonacci fibonacci = new Fibonacci();
//        long[] fiboNumbers = fibonacci.fibo(21);
//        for (int i = 0; i < fiboNumbers.length; i++) {
//            System.out.println(i + 1 + ")" + fiboNumbers[i]);
//        }
        // 3.14 Перемножение матриц*
        System.out.println("Перемножение матриц");
        
        double[][] multiplicand = new double[][] { { 3, -1, 2 }, { 2, 0, 1 }, { 1, 2, 1 } };
        double[][] multiplier = new double[][] { { 2, -1, 1 }, { 0, -2, 3 }, { 3, 0, 1 } };
 
        System.out.println("Ширина=" + Matrix.size(multiplicand)[0] + " Высотa=" + Matrix.size(multiplicand)[1]);

        try {
            System.out.println("#1\n" + Matrix.toString(Matrix.multiplyByMatrix(multiplicand, multiplier)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
