import java.util.Random;

public class Soiduk {
    int kiirus;
    String nimetus;
    int xCoord;
    int yCoord;
    int symbol;

    public Soiduk(int kiirus, String nimetus, Random random, Maailm maailm) {
        this.kiirus = kiirus;
        this.nimetus = nimetus;
        // this.xCoord = saaKoordinaat()
        this.symbol = 'S';
    }
}