package com.gmail.vyacheacheslavxxxxx;

import java.text.Collator;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueueImpl<T> extends AbstractQueue<T> {

    private T[] arr;
    private int headPos;
    private int tailPos;
    private int size;

    public QueueImpl(int length) {
        arr = (T[]) new Object[length];
    }

    public QueueImpl() {
        super();
    }

    @Override
    public boolean offer(T e) {
        if (headPos == tailPos && size > 0) {
            return false;
        }
        if (size < arr.length)
            size++;
        else if (headPos == tailPos) {
            headPos = nextPos(headPos);
        }
        arr[tailPos] = e;
        tailPos = nextPos(tailPos);
        return true;
    }

    private int nextPos(int pos) {
        return (pos + 1) % arr.length;
    }

    @Override
    public T peek() {
        if (size == 0)
            return null;
        return arr[headPos];
    }

    @Override
    public T poll() {
        if (size == 0)
            return null;

        size--;
        T res = arr[headPos];
        int oldHeadPos = headPos;
        headPos = nextPos(headPos);
        arr[oldHeadPos] = null;
        return res;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void printArr() {
        System.out.println(Arrays.asList(arr));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int count = 0;
            private int currentIndex = headPos;

            @Override
            public boolean hasNext() {
                return this.count < size;

            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("There aren't more elements");
                }
                if (count == 0) {
                    this.count++;
                    return arr[currentIndex];
                } else {
                    this.count++;
                    return arr[nextPos(currentIndex++)];
                }
            }
        };

    }

    public void printState() {
        System.out.println(
                "HEAD POS=" + headPos + "\nTAIL POS=" + tailPos + "\nSIZE=" + size + "\n" + Arrays.toString(arr));
    }

    class StringQueueImpl {

        private Collator ukColl = Collator.getInstance(new Locale("uk"));
        private QueueImpl<T> queue;

        public StringQueueImpl(int len) {
            this.queue = new QueueImpl<>(len);
        }

        public void printState() {
            queue.printState();
        }

        public boolean addWithReg(String text) {
            Pattern pattern = Pattern.compile("(^|\\s)\\p{Lu}.{1,}");
            Matcher m = pattern.matcher(text);
            if (m.matches()) {
                return queue.add((T) text);
            }
            return false;
        }

        public void printInAlphOrder() {
            ukColl.setStrength(Collator.PRIMARY);
            List<String> temp = Arrays.asList(Arrays.copyOf(this.queue.arr, this.queue.size(), String[].class));
            for (String str : temp) {
                if (str == null) {
                    temp.remove(str);
                }
            }
            Collections.sort(temp, (String o1, String o2) -> ukColl.compare(o1, o2));
            System.out.println(temp.toString());
        }

    }
}
