package com.gmail.vyacheslavxxxxx;

public class Formatter {
	public String format(String text, int lineSize) {
		String[] textArray = text.split(" ");
		StringBuilder sb = new StringBuilder();

		int newLineSize = 0;
		sb.append(textArray[0]).append(" ");
		for (int i = 1; i < textArray.length; i++) {
			
			newLineSize += textArray[i-1].length() + 1 + textArray[i].length() + 1;

			if (newLineSize <= lineSize) {
				sb.append(textArray[i]).append(" ");
			} else {
				sb.append(System.lineSeparator());
				sb.append(textArray[i]).append(" ");
				newLineSize = 0;
			}

		}
		return sb.toString();
	}
}
