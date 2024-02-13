package text_file_handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class m {

    public static String readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File successfully written.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static int[] textAnalysis(String content) {
        if (content != null) {
            int words = content.split("\\s+").length;
            int lines = content.split("\n").length;
            int characters = content.length();
            return new int[]{words, lines, characters};
        }
        return null;
    }

    public static String modifyContent(String content, String oldWord, String newWord) {
        if (content != null) {
        
            return content.replaceAll(oldWord, newWord);
        }
        return null;
    }

    public static void main(String[] args) {
    	// this is file path
        String filePath = "c:\\Users\\HP\\OneDrive\\Desktop\\Manish.txt";  

        // Read content from file
        String originalContent = readFile(filePath);

        if (originalContent != null) {
            // Perform basic text analysis
            int[] analysisResult = textAnalysis(originalContent);
            System.out.println("Word count: " + analysisResult[0] +
                    "\nLine count: " + analysisResult[1] +
                    "\nCharacter count: " + analysisResult[2]);

            // Modify content
            String oldWord = "WebDevelopment";
            String newWord = "BackendDevelopment";
            String modifiedContent = modifyContent(originalContent, oldWord, newWord);
            
            //Display modify Content on Console
            System.out.println("Modified Content:\n" + modifiedContent);

            // Write modified content back to the file
            writeFile(filePath, modifiedContent);
        }
    }
}

