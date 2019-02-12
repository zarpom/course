package com.gmail.vyacheslavxxxxx;

 

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AlphabetOrder {
	public Set<String> getWordsAlphabetOrder(String text) {
		String[] textArray = text.split(" ");
		TreeSet<String> textTree = new TreeSet(new Comparator<String>()

		{
			@Override
			public int compare(String s1, String s2) {
				return s2.toUpperCase().compareTo(s1.toUpperCase()) * -1;
			}

		});
		textTree.addAll(Arrays.asList(textArray));
		return textTree;
	}

	public static void main(String[] args) {
		String text = "Мне япония мне мира нет и брани не подьемлю восторг и страх в груди огонь и лед альбом";
		AlphabetOrder alphabetOrder = new AlphabetOrder();
		for (String word : alphabetOrder.getWordsAlphabetOrder(text)) {
			System.out.println(word);
		}
	}
}
