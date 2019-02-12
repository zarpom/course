package com.gmail.vyacheslavxxxxx;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class AverageNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Queue<Double> queue = new PriorityQueue<>(100, new Comparator<Double>() {
            @Override
            public int compare(Double i1, Double i2) {
                return -Double.compare(i1, i2);
            }
        });

        for (int i = 0; i < 10; i++) {
            queue.add(random.nextDouble());
        }

        Double s = 0d;
        double sum = 0;
        int queueSize = queue.size();

        while ((s = queue.poll()) != null) {
            System.out.println(s + " "); 
            sum += s;
        }

        System.out.println("average:" + sum / queueSize);
    }
}
