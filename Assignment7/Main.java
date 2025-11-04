import java.util.*;

//Name - Sai Mohit Kotta
//Roll Number - 2410110287


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Paste the reserved words in the first line, then the text to analyze (press Enter twice when done):");

        String reservedLine = sc.nextLine().toLowerCase().replaceAll("[.,;:'\"-]", "");
        List<String> reserved = Arrays.asList(reservedLine.split("\\s+"));

        StringBuilder textBuilder = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) break;
            textBuilder.append(line).append(" ");
        }
        sc.close();

        Analyzer analyzer = new Analyzer(textBuilder.toString(), reserved);

        System.out.println("1a: " + analyzer.getUniqueWordsInOrder());
        System.out.println("1b: " + analyzer.getUniqueWordsAlphabetical());
        System.out.println("1c: " + analyzer.getUniqueWordsByLength());
        System.out.println("1d: " + analyzer.getUniqueWordsByFrequency());

        System.out.println("\n2a:");
        LinkedHashMap<Character, Integer> startCounts = analyzer.getWordStartCount();
        for (Map.Entry<Character, Integer> entry : startCounts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\n3a: " + analyzer.getUsedReservedWordsInOrder());
        System.out.println("3b: " + analyzer.getUsedReservedWordsByFrequency());
    }
}
