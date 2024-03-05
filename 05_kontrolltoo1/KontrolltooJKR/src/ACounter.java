import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ACounter {
    private int totalACount;
    private int totalWords;
    private int totalLetters;
    private double averageACount;
    private double ratioToTotalLetters;
    private final int[] aList;

    public ACounter() {
        totalACount = 0;
        totalWords = 0;
        totalLetters = 0;
        averageACount = 0.0;
        ratioToTotalLetters = 0.0;
        aList = new int[11];
    }

    public void countA(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                totalWords++;
                totalLetters += word.length();
                int aCount = countAInWord(word);
                totalACount += aCount;
                if (aCount <= 10) {
                    aList[aCount]++;
                }
            }
            if (totalWords != 0) {
                averageACount = (double) totalACount / totalWords;
                averageACount = Math.round(averageACount * 100.0) / 100.0;
                ratioToTotalLetters = (double) totalACount / totalLetters;
                ratioToTotalLetters = Math.round(ratioToTotalLetters * 100.0) / 100.0;
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }

    private int countAInWord(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'A') {
                count++;
            }
        }
        return count;
    }

    public void displayResults() {
        System.out.println("Total 'a' count: " + totalACount);
        System.out.println("Total words: " + totalWords);
        System.out.println("Average 'a' count per word: " + averageACount);
        System.out.println("Ratio of 'a's to total letters: " + ratioToTotalLetters);
        System.out.println("Word count with respect to the number of 'a's:");
        for (int i = 0; i <= 10; i++) {
            String charCount = (i == 10) ? "10" : " " + i;
            System.out.printf("%2s 'A' in the word | %d%n", charCount, aList[i]);
        }
    }

    public void writeResults(String outputFileName) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.println("Total 'a' count: " + totalACount);
            writer.println("Total words: " + totalWords);
            writer.println("Average 'a' count per word: " + averageACount);
            writer.println("Ratio of 'a's to total letters: " + ratioToTotalLetters);
            writer.println("Word count with respect to the number of 'a's:");
            for (int i = 0; i <= 10; i++) {
                String charCount = (i == 10) ? "10" : " " + i;
                writer.printf("%2s 'A' in the word | %d%n", charCount, aList[i]);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File writing error");
        }
    }
}