//Libisev keskmine
//
//*1. Koosta funktsioon kolme arvu aritmeetilise keskmise leidmiseks. Katseta.
//
//*2. Koosta funktsioon massiivi libiseva keskmise leidmiseks. Väljundiks on massiiv, mis on sisendist kahe elemendi võrra lühem ning mille iga elemendi väärtuseks on sisendmassiivi vastava elemendi ning selle järgmise ja ülejärgmise elemendi keskmine.
//
//*3. Koosta klass, mille eksemplarile saab vastava käsuga lisada arve. Teise käsuga saab küsida nende arvude libiseva keskmise massiivi vastavalt eelmise punkti juhendile. Koosta kood nõnda, et uue arvu lisamisel eksemplarile tehtaks uusi arvutusi võimalikult vähe (st. ei arvutataks kogu tulemust massiivi algusest uuesti)

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double keskmine = arvutaAritmeetilineKeskmine(4, 7, 8);
        System.out.println(keskmine);

        List<Double> arvud = new ArrayList<>();
        arvud.add(4.0);
        arvud.add(7.0);
        arvud.add(8.0);
        List<Double> libisevadKeskmised = arvutaLibisevKeskmine(arvud);
        System.out.println(libisevadKeskmised);

        Keskmine keskmine1 = new Keskmine(arvud);
        List<Double> libisevKeskmine2 = keskmine1.saaArvudKeskmised();
        System.out.println(libisevKeskmine2);
        keskmine1.lisaArv(10.0);
        List<Double> libisevKeskmine3 = keskmine1.saaArvudKeskmised();
        System.out.println(libisevKeskmine3);
    }

    private static double arvutaAritmeetilineKeskmine(double arv1, double arv2, double arv3) {
        double summa = (arv1 + arv2 + arv3);
        double aritmeetilineKeskmine = summa / 3;
        return aritmeetilineKeskmine;
    }

    // private static --> kui funktsioon kutsutakse mainis
    // public --> kui loon funktsiooni teises klassis
    private static double arvutaAritmeetilineKeskmine2(double arv1, double arv2, double arv3) {
        return (arv1 + arv2 + arv3) / 3;
    }

    private static List<Double> arvutaLibisevKeskmine(List<Double> arvud) {
        List<Double> arvudKeskmised = new ArrayList<>();
//        for (double a: arvud) {
//            a
//        }
        // fori 6,7,8
        for (int i = 0; i < arvud.size() - 2; i++) {
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2);
            double libisevKeskmine = summa / 3;
            arvudKeskmised.add(libisevKeskmine);
        }
        return arvudKeskmised;
    }
}