public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    public Maailm(int korgus, int laius){
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }

    public void prindiKaart(Mangija mangija, Draakon draakon, Ork ork) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < 10; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mangija.xCoord && y == mangija.yCoord) {
                        symbol = mangija.symbol;
                    } else if (x == draakon.xCoord && y == draakon.yCoord) {
                        symbol = draakon.symbol;
                    } else if (x == ork.xCoord && y == ork.yCoord) {
                        symbol = ork.symbol;
                    } else {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

}
