package com.gmail.vyacheslavxxxxx;

import java.util.regex.Pattern;

public class Translator {

	boolean isGoodBalanseCeurlyBracket(String text) {
		if (text == null || text == "") {
			return false;
		}

		char[] textToArray = text.toCharArray();
		int counter = 0;
		boolean result = false;

		for (int i = 0; i < textToArray.length; i++) {
			if (textToArray[i] == '}') {
				counter--;
			} else if (textToArray[i] == '{') {
				counter++;
			}
			if (counter < 0) {
				result = false;
				break;
			}
		}

		if (counter == 0) {
			result = true;
		} else {
			result = false;
		}
		return result;

	}

	public String replaceCeurlyBracket(String text) {
		if (isGoodBalanseCeurlyBracket(text)) {
			String replasedBegin = (Pattern.compile("\\{").matcher(text).replaceAll("begin"));
			text = Pattern.compile("\\}").matcher(replasedBegin).replaceAll("end");
		}
		return text;
	}

	public static void main(String args[]) {
		Translator translator = new Translator();
		String text = "{ }  { }";
		System.out.println(translator.isGoodBalanseCeurlyBracket(text));
		System.out.println(translator.replaceCeurlyBracket(text));
	}

}
