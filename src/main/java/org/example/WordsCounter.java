package org.example;

import java.util.*;

public class WordsCounter {
    public static void main(String[] args) {
        String text = "This is a test. This test is only a test.";
        countWordFrequency(text);
    }

    private static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Частота слов: " + wordCount);
    }
}

