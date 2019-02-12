package com.gmail.vyacheslavxxxxx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Substring {
    public static String searchSubstrings(String text, String regex) {
        String[] words = text.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while(matcher.find())
            stringBuilder.append(matcher.group()).append(" ");
    
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(searchSubstrings("Причем тут причина причиненного преттечи", "[а-я]+")); 
    }
}
