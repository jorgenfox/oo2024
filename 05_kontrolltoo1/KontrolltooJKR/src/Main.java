public class Main {
    public static void main(String[] args) {
        ACounter aCounter = new ACounter();
        aCounter.countA("atahed.txt");
        aCounter.displayResults();
        aCounter.writeResults("valjund.txt");
    }
}