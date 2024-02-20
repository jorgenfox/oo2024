import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        Maailm maailm = new Maailm(5,10);
        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        Ese m66k = new Ese("Mõõk",10,1, random, maailm);
        Ese haamer = new Ese("Haamer",5,3, random, maailm);
        Ese saabas = new Ese("Saabas",1,5, random, maailm);
        List<Ese> esemed = new ArrayList<>();
        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);

        Scanner scanner = new Scanner(System.in);

        maailm.prindiKaart(mangija, draakon, ork, esemed);

        String sisend = scanner.nextLine();
        mangija.liigu(sisend, maailm);

        while (!sisend.equals("end")) { // m.equals() --> ==    !m.equals() == !=
            maailm.prindiKaart(mangija, draakon, ork, esemed);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
        }

    } // <-- main (args[]) kinniminek
} // <-- Main() kinniminek