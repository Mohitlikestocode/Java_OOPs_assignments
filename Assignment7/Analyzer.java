//Name - Sai Mohit Kotta
//Roll Number - 2410110287

import java.util.*;
import java.util.stream.Collectors;

public class Analyzer {
    private ArrayList<String> words;           // cleaned words from input
    private ArrayList<String> reservedWords;   // reserved words list
    private LinkedHashSet<String> uniqueWords; // preserves insertion order
    private HashMap<String, Integer> freqMap;  // word frequency map

    public Analyzer(String text, List<String> reserved) {
        this.reservedWords = new ArrayList<>(reserved);
        this.words = new ArrayList<>();

        // clean the text — remove punctuation, convert to lowercase
        String cleaned = text.toLowerCase().replaceAll("[.,;:'\"-]", "");
        String[] splitWords = cleaned.split("\\s+");
        Collections.addAll(words, splitWords);

        this.uniqueWords = new LinkedHashSet<>(words); // preserve order of appearance
        this.freqMap = new HashMap<>();

        for (String w : words) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }
    }

    // 1a: unique words in order of appearance
    public ArrayList<String> getUniqueWordsInOrder() {
        return new ArrayList<>(uniqueWords);
    }

    // 1b: unique words in alphabetical order
    public ArrayList<String> getUniqueWordsAlphabetical() {
        ArrayList<String> sorted = new ArrayList<>(uniqueWords);
        Collections.sort(sorted);
        return sorted;
    }

    // 1c: unique words by increasing length (tie -> lexicographic)
    public ArrayList<String> getUniqueWordsByLength() {
        ArrayList<String> sorted = new ArrayList<>(uniqueWords);
        sorted.sort((a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });
        return sorted;
    }

    // 1d: by frequency (low to high), tie -> input order
    public ArrayList<String> getUniqueWordsByFrequency() {
        ArrayList<String> sorted = new ArrayList<>(uniqueWords);
        sorted.sort((a, b) -> {
            int f1 = freqMap.get(a);
            int f2 = freqMap.get(b);
            return (f1 != f2) ? (f1 - f2) : 0;
        });
        return sorted;
    }

    // 2: count of words starting with each letter
    public LinkedHashMap<Character, Integer> getWordStartCount() {
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();
        for (String w : words) {
            if (w.length() > 0) {
                char c = w.charAt(0);
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
        }
        return countMap;
    }

    // 3a: reserved words that actually appear, in order of appearance
    public ArrayList<String> getUsedReservedWordsInOrder() {
        ArrayList<String> used = new ArrayList<>();
        for (String r : reservedWords) {
            if (freqMap.containsKey(r)) used.add(r);
        }
        return used;
    }

    // 3b: reserved words in decreasing frequency order
    public ArrayList<String> getUsedReservedWordsByFrequency() {
        ArrayList<String> used = getUsedReservedWordsInOrder();
        used.sort((a, b) -> freqMap.get(b) - freqMap.get(a));
        return used;
    }
}
