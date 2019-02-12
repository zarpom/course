package com.gmail.vyacheslavxxxxx;

import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<E> {

    @Override
    public String toString() {
        return "DoublyLinkedListImpl [head=" + head + ", tail=" + tail + ", size=" + size + "]";
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedListImpl() {
        size = 0;
    }

    private class Node {
        
        @Override
        public String toString() {
            return "Node [element=" + element + ", next=" + next + ", prev=" + prev + "]";
        }

        E element;
        Node next;
        Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
    }

    public void addLast(E element) {

        Node tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
    }

    public void iterateForward() {

        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
        }
    }

    public void iterateBackward() {

        Node tmp = tail;
        while (tmp != null) {
            tmp = tmp.prev;
        }
    }

    public E removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp.element;
    }

    public E removeLast() {
        if (size == 0)
            throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tmp.element;
    }

    public static void main(String a[]) {

        DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl<Integer>();
        dll.addFirst(10);
        dll.addFirst(34);
        dll.addLast(56);
        dll.addLast(364);
        
        dll.iterateForward();
        dll.removeFirst();
        dll.removeLast();
        dll.iterateBackward();
    }
}