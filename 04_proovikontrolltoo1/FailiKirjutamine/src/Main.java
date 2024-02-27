import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("valjund.txt"));
        pw.print("Elas");
        pw.print(" ");
        pw.print("metsas");
        pw.print(" ");
        pw.print("mutionu");
        pw.println();
        pw.println("keset kuuski noori vanu");
        pw.println("eluruum tal sügaval");
        pw.close();
    }
}