package com.gmail.vyacheslavxxxxx;

import java.util.Arrays;

public class SynhThread {
    private static int[] array = new int[4];
    private static int sum;
    private static int mult;
    private static Thread threadSum, threadMult;

    static class Sum implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }

            System.out.println("sum  = " + sum);
        }
    }

    static class Mult implements Runnable {

        @Override
        public void run() {
            mult = 1;
            try {
                for (int i = 0; i < array.length; i++) {
                    mult *= array[i];
                    Thread.sleep(100);
                }

                System.out.println("multiplication = " + mult);
                threadSum.join();
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }

            System.out.println("avg = " + (sum + mult) / 2d);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++)
            array[i] = i + 1;

        System.out.println("array = " + Arrays.toString(array));

        threadSum = new Thread(new Sum());
        threadMult = new Thread(new Mult());

        threadMult.start();
        threadSum.start();
    }
}
