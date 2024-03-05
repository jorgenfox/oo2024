import java.util.ArrayList;
import java.util.List;

public class Keskmine {
    List<Double> arvud = new ArrayList<>(); // eksemplar
    List<Double> arvudKeskmised = new ArrayList<>();

    // Keskmine keskmine = new Keskmine(4,7,8);
    public Keskmine(List<Double> arvudAlguses) {
        arvud = arvudAlguses; // [4,7,8]
        arvutaLibisevKeskmine(); // [6.33333]
    }

    // vastav käsk   eksemplarile saab vastava käsuga lisada arve
    public void lisaArv(Double arv) {
        Double viimane = arvud.get(arvud.size() - 1);
        Double eelViimane = arvud.get(arvud.size() - 2);
        Double keskmine = (viimane + eelViimane + arv) / 3;
        arvudKeskmised.add(keskmine);

        arvud.add(arv);
    }

    //Teise käsuga saab küsida nende arvude libiseva keskmise massiivi
    public List<Double> saaArvudKeskmised() {
        return arvudKeskmised;
    }

    private List<Double> arvutaLibisevKeskmine() {

        for (int i = 0; i < arvud.size() - 2; i++) {
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2);
            double libisevKeskmine = summa / 3;
            arvudKeskmised.add(libisevKeskmine);
        }
        return arvudKeskmised;
    }
}