package com.jahid.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindSeuenceWord {
	private static Map<String, Integer> seqWords = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = null;
		StringBuffer line = null;
		String fileName = "F:\\sreenu\\corejava\\findsequenceword\\src\\com\\jahid\\common\\abc.txt";
		scanner = new Scanner(new File(fileName));
		line = new StringBuffer();

		while (scanner.hasNextLine()) {
			String tline = scanner.nextLine();
			line.append(" ");
			line.append(tline);
		}
		SplitWords(line.toString().toLowerCase());

		System.out.println(seqWords);
		scanner.close();
	}

	private static void SplitWords(String line) {
		String word = null;
		String[] words = line.split(" ");
		List<Character> chars = null;

		for (int i = 0; i < words.length; i++) {
			word = words[i];
			chars = countSeuenceWord(word);
			addToMap(chars);
		}
	}

	private static List<Character> countSeuenceWord(String word) {
		List<Character> characters = null;
		boolean flag = false;
		char[] ch = null;
		ch = word.toCharArray();
		characters = new ArrayList<>();
		int fst = 0;
		int sec = 0;
		for (int i = 1; i < ch.length; i++) {

			fst = ch[i - 1];
			sec = ch[i];
			flag = compare(fst, sec);
			if (flag) {
				if (!characters.isEmpty()) {
					if (characters.get(characters.size() - 1) == fst)
						characters.add((char) sec);

				} // if
				else {
					characters.add((char) fst);
					characters.add((char) sec);
				}
			}

		}
		return characters;
	}
	private static boolean compare(int fst, int sec) {
		if (sec - fst == 1) {
			return true;
		}
		return false;
	}
	private static void addToMap(List<Character> ch) {
		String word = null;
		if (!ch.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			for (Character c : ch) {
				builder.append(c);
			}
			word = builder.toString();
			if (seqWords.containsKey(word))
				seqWords.put(word, seqWords.get(word) + 1);
			else
				seqWords.put(word, 1);
		}
	}

}
