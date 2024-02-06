//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // KODUS: 3 FUKNTSIOONI, MILLES ON KASUTATUD VAHEMALT 4 ERINEVAT TUUPI
        // void, String, int, char, long, double, float, boolean
        // TAGASTAB int     parameetriks boolean
        // TAGASTAB void    parameetriks boolean, int
        // TAGASTAB String  parameetriks String

        // TEHA IGAST FUNKTSIOONIST 2 ERINEVA SISENDIGA VALJAKUTSET

        double kogumaksumus1 = arvutaTaksoMaksumus(3);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = arvutaTaksoMaksumus(2);
        System.out.println(kogumaksumus2);

        String hinnang1 = temperatuuriHinnang(-1.2);
        System.out.println(hinnang1);
        String hinnang2 = temperatuuriHinnang(2.2);
        System.out.println(hinnang2);

        prindiForTsykkel("Pikk sõna");
        prindiForTsykkel("Lüh");
    }

    private static double arvutaTaksoMaksumus(int tunnid) {
        return 3 + 0.9*tunnid;
    }
    private static String temperatuuriHinnang(double temp) {
        if (temp < 0) {
            return "Vesi on jääs";
        } else {
            return "On vesi";
        }
    }

    private static void prindiForTsykkel(String tahtedeArv) {
        for (int i = 0; i < tahtedeArv.length(); i++) {
            System.out.println(i);
        }
    }

}