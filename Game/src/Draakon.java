import java.util.Random;

public class Draakon {
    int xCoord;
    int yCoord;
    char symbol;

    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius);
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'D';
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}
