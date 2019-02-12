package com.gmail.vyacheslavxxxxx;
 

public class Abbreviation {
    public String abbreviation(String text) {
        String words[] = text.split(" ");
        String abbreviation = "";
        for (String word : words) {
            abbreviation += Character.toUpperCase(word.charAt(0));
        }
        return abbreviation;
    }
 
}
