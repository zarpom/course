package com.gmail.vyacheslavxxxxx;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class IteratorReverse {
    public static void iterate(String text, int index) {
        CharacterIterator it = new StringCharacterIterator(text);
        for (char ch = it.setIndex(index); ch != CharacterIterator.DONE; ch = it.previous()) {
            System.out.println(ch);
        }
    }

    public static void main(String[] args) {
        iterate("Hibro", 2);
    }
}
