package com.gmail.vyacheslavxxxxx;

public class Main {

    public static void main(String[] args) {
        System.out.println("---------Multithreading---------");
        FileCollector fc = new FileCollector();
        SummaryLength sl = new SummaryLength(fc);
        Thread tfc = new Thread(fc);
        Thread tsl = new Thread(sl);

        tfc.start();
        tsl.start();

        try {
            tfc.join();
            sl.finish();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}