import java.util.Random;

public class Ork {
    int xCoord;
    int yCoord;
    char symbol;

    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius);
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'O';
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}
