package com.gmail.vyacheacheslavxxxxx;

import java.text.ParseException;
import java.util.Iterator;

public class Main  {
    public static void main(String[] args) throws ParseException {
        QueueImpl<Integer> q = new QueueImpl<>(3);
        q.printState();

        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.printState();
        Iterator<Integer> i = q.iterator();
        while (i.hasNext()) {
            System.out.println("iter=" + i.next());
        }

        q.remove();
        q.printState();
        Iterator<Integer> ii = q.iterator();

        System.out.println();

        while (ii.hasNext()) {
            System.out.println(ii.next());
        }

        QueueImpl<String>.StringQueueImpl stringQueueImpl = new QueueImpl<String>().new StringQueueImpl(12);
        stringQueueImpl.printState();
        stringQueueImpl.addWithReg("Key");
        stringQueueImpl.printState();
        stringQueueImpl.addWithReg("Ring");
        stringQueueImpl.printState();
        stringQueueImpl.addWithReg("Яма");
        stringQueueImpl.addWithReg("Європа");
        stringQueueImpl.addWithReg("Їжа");
        stringQueueImpl.addWithReg("Арка");
        stringQueueImpl.addWithReg("Чего?");
        stringQueueImpl.printState();
        stringQueueImpl.printInAlphOrder();

    }
}