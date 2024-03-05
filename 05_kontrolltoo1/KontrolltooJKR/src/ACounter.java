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

    public void fileRead(String fileName) {
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
            System.err.println("Faili ei leitud: " + fileName);
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
        System.out.println("Kokku 'a' tähti: " + totalACount);
        System.out.println("Kokku sõnu " + totalWords);
        System.out.println("Keskmine 'a' arv sõnas: " + averageACount);
        System.out.println("'a' suhe kõikide tähtedega:: " + ratioToTotalLetters);
        System.out.println("Mitu 'a'-d sõnas esineb:");
        for (int i = 0; i <= 10; i++) {
            String charCount = (i == 10) ? "10" : " " + i;
            System.out.printf("%2s 'a'-d sõnas | %d%n", charCount, aList[i]);
        }
    }

    public void writeResults(String outputFileName) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.println("Kokku 'a' tähti: " + totalACount);
            writer.println("Kokku sõnu " + totalWords);
            writer.println("Keskmine 'a' arv sõnas: " + averageACount);
            writer.println("'a' suhe kõikide tähtedega:: " + ratioToTotalLetters);
            writer.println("Mitu 'a'-d sõnas esineb:");
            for (int i = 0; i <= 10; i++) {
                String charCount = (i == 10) ? "10" : " " + i;
                writer.printf("%2s 'a'-d sõnas | %d%n", charCount, aList[i]);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Faili kirjutamise error");
        }
    }
}