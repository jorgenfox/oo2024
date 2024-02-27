import java.util.List;

public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    public Maailm(int korgus, int laius) {
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }

    public void prindiKaart(List<Tegelane> tegelased, List<Ese> esemed) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                    for (Ese e : esemed) {
                        if (e.xCoord == x && e.yCoord == y) {
                            symbol = e.symbol;
                        }
                    }
                    for (Tegelane t : tegelased) {
                        if (t.xCoord == x && t.yCoord == y) {
                            symbol = t.symbol;
                        }
                    }
                    // fori
//                        for (int i = 0; i < esemed.size(); i++) {
//                            esemed.get(i);
//                        }

                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}