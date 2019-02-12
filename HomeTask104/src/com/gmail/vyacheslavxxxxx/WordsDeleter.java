package com.gmail.vyacheslavxxxxx;

public class WordsDeleter {
    public String deleteWords(String text, String[] c) {
        String[] words = text.split(" ");
        StringBuilder specuficWords = new StringBuilder();
        skip: for (String word : words) {
            for (int i = 0; i < c.length; i++) {
                if (word.toUpperCase().contains(c[i].toUpperCase())) {
                    continue skip;
                }
            }

            specuficWords.append(word).append(" ");
        }
        return specuficWords.toString();
    }
 
}
