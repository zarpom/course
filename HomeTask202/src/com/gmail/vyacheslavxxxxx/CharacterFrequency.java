package com.gmail.vyacheslavxxxxx;

 
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterFrequency {
	public HashMap<Character, Integer> getFrequency(String text) {
		HashMap<Character, Integer> tableFrequency = new HashMap<Character, Integer>();
		Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]");
		for (int i = 0; i < text.length(); i++) {
			char character = text.charAt(i);
			Matcher matcher = pattern.matcher(character + "");
			while (matcher.find()) {
				Integer characterFrequency = tableFrequency.get(character);
				if (characterFrequency != null) {
					tableFrequency.put(character, characterFrequency + 1);
				} else {
					tableFrequency.put(character, 1);
				}
			}
		}
		return tableFrequency;
	}
}
