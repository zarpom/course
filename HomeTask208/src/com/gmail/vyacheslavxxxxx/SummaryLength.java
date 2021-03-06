package com.gmail.vyacheslavxxxxx;

import java.util.Map;

public class SummaryLength implements Runnable {

    private long prevLenght = 0;
    private FileCollector fc;
    private boolean finish = false;

    public SummaryLength(FileCollector fc) {
        this.fc = fc;
    }

    public void finish() {
        this.finish = true;
    }

    @Override
    public void run() {
        while (true) {
            long length = 0;
            for (Map.Entry<String, Long> entry : FileCollector.files.entrySet()) {
                length += entry.getValue();
            }
            if (length != prevLenght) {
                prevLenght = length;
                System.out.println("               Total length = " + prevLenght);
            }
            if (finish)
                break;
        }
    }
}
