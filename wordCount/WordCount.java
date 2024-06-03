import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        // Change this path to your file path
        String filePath = "C:/SQA/wordCount/text.txt";

        // TreeMap to store word counts (sorted by key, which is the word)
        Map<String, Integer> wordCounts = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line into words using space and punctuation as delimiters
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue; // Skip empty strings resulting from split
                    }

                    // Update the count for each word
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display the word counts in alphabetical order
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
