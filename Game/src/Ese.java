import java.util.Random;

public class Ese {
    String nimetus;
    double tugevus;
    int kasutuskorrad;
    boolean aktiivne;
    int xCoord;
    int yCoord;
    char symbol;

    public Ese(String nimetus, double tugevus, int kasutuskorrad, Random random, Maailm maailm) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
        this.kasutuskorrad = kasutuskorrad;
        this.aktiivne = true;
        xCoord = saaKoordinaat(random, maailm.kaardiLaius);
        yCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'i';
    }

    public void hit() {
        System.out.println("Loid vastast");
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
