public class Main {
    public static void main(String[] args) {
        // Main class + enda tehtud class
        // Classis constructor
        // Vahemalt 2 omadust
        // Vahemalt 2 funktsiooni

        // Mainis vahemalt 2 instantsi temast
        // Mainis vahemalt 2 funktsiooni valjakutset
        // Vahemalt 2 System.out.println()

        Kasutaja kasutaja = new Kasutaja("M", true, 20, 'x', 0.0);
        Kasutaja kasutaja2 = new Kasutaja("S", false, 33, 'd', 499.0);

        kasutaja.muudaAktiivne();
        System.out.println(kasutaja);
        double kasutaja2Raha = kasutaja2.lisaRaha(500.0);
        System.out.println(kasutaja2Raha);

        Tellimus tellimus1 = new Tellimus("M",199.0,"Coca");
        Tellimus tellimus2 = new Tellimus("S",211.0,"Fanta");

        double dollarites = tellimus1.tellimuseSummaDollarites();
        System.out.println(dollarites);

        tellimus2.tellijaNimeVahetus("Y");
        System.out.println(tellimus2.tellija);

    }
}