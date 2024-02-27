import java.util.List;

public class Kolmnurk {
    List<Integer> xCoords;
    List<Integer> yCoords;

    public Kolmnurk(List<Integer> xCoords, List<Integer> yCoords) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
    }

    public int lisaKoordinaadid(int newXCoord, int newYCoord) {
        xCoords.add(newXCoord);
        yCoords.add(newYCoord);

        int summa = 0;
        for (int x: xCoords) {
            summa += x;
        }
        return summa;
    }
}
