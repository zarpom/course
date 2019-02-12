package com.gmail.vyacheslavxxxxx;

public class TestMethodReferences {

    static void print(IntOperation op, int a, int b) {
        System.out.println(op.f(a, b));
    }

    static void print(StringOperation op, String s) {
        System.out.println(op.g(s));
    }

    public static void main(String[] args) {
        DifferentMethods dm = new DifferentMethods();
        print(dm::add, 3, 4);
        print((a, b) -> a + b, 3, 4);
        print(new IntOperation() {

            @Override
            public int f(int a, int b) {
                return a + b;
            }
        }, 3, 4);
        print(DifferentMethods::mult, 3, 4);
        print(String::toUpperCase, "text");
    }

}

class DifferentMethods {
    public int add(int a, int b) {
        return a + b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

}

interface IntOperation {
    int f(int a, int b);
}

interface StringOperation {
    String g(String s);
}