/*
Java Assignment
Name: Tomas Mac Sweeney
Date: 2/4/23
i included a search tool that lets you search through groups of text files.
i put the search tool into a GUI Graphic user interface
it will give back the strongest matches ranking mechanism so the strongest match is returned first
 */

package JavaAssignment;

// this is the import method
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// this is the main class
public class TextSearcher {
    public static void searchFiles(String searchTerm, String[] files) {
        StringBuilder results = new StringBuilder();
        // for loop
        for (String filename : files) {
            File file = new File(filename);
            // if the files exists
            if (!file.exists()) {
                results.append("File not found: " + filename + "\n");
                // continue the loop
                continue;
            }
            // try method
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 0;
                // while loop
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    int count = 0;
                    String[] words = line.split("\\W+");
                    // for loop
                    for (String word : words) {
                        if (word.equalsIgnoreCase(searchTerm)) {
                            count++;
                        }
                    }
                    // this is used for matching the score of the word
                    if (count > 0) {
                        double score = (double) count / (double) words.length;
                        results.append(String.format("%s: %d: %s (%.0f%%)\n", filename, lineNumber, line, score * 100));
                    }
                }
                // this catches the exception
            } catch (IOException e) {
                results.append("Error reading file: " + filename + "\n");
                e.printStackTrace();
            }
        }
        // this will go to the GUI file and display the results
        TextSearcherGUI.showResults(results.toString());
    }
}

