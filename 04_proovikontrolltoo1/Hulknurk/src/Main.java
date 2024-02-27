import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> kokmnurk1xCoords = new ArrayList<>();
        kokmnurk1xCoords.add(6);
        kokmnurk1xCoords.add(8);
        kokmnurk1xCoords.add(10);

        List<Integer> kokmnurk1yCoords = new ArrayList<>();
        kokmnurk1yCoords.add(3);
        kokmnurk1yCoords.add(4);
        kokmnurk1yCoords.add(5);

        Kolmnurk kolmnurk = new Kolmnurk(kokmnurk1xCoords, kokmnurk1yCoords);

        System.out.println(kolmnurk.xCoords);
        System.out.println(kolmnurk.yCoords);

        int umbermoot = kolmnurk.lisaKoordinaadid(5,10);
        System.out.println(umbermoot);
    }
}