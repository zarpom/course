package com.gmail.vyacheslavxxxxx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Corrector {
    public String[] intoWordsToLowerCase(String[] words) {
        for (int wordNumber = 0; wordNumber < words.length; wordNumber++) {
            char[] symbols = words[wordNumber].toCharArray();
            for (int symbolNumber = 1; symbolNumber < symbols.length; symbolNumber++) {
                if (Character.isUpperCase(symbols[symbolNumber])) {
                    symbols[symbolNumber] = Character.toLowerCase(symbols[symbolNumber]);
                }
            }
            words[wordNumber] = new String(symbols);
        }
        return words;
    }

    private String[] addDotToFirstUpperLetter(String[] words) {
        Pattern p = Pattern.compile("[А-ЯA-Z]{1}");

        for (int wordNumber = 1; wordNumber < words.length; wordNumber++) {
            Matcher m = p.matcher(words[wordNumber]);
            if (m.find()) {
                words[wordNumber - 1] = words[wordNumber - 1] + ".";
            }
        }
        return words;
    }

    public String wordsOnFirstLetter(String text, char c) {
        String[] words = text.split(" ");
        StringBuilder specuficWords = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0 && word.charAt(0) == c) {
                specuficWords.append(word).append("");
            }
        }
        return specuficWords.toString();

    }

    public String correct(String text) {
        text = text.replaceAll("\\s+", " ").trim();
        String[] words = text.split(" ");

        words = intoWordsToLowerCase(words);
        words = addDotToFirstUpperLetter(words);

        return String.join(" ", words);
    }
}
