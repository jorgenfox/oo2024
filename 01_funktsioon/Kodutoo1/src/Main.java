public class Main {
    public static void main(String[] args) {
        // KODUS: 3 FUKNTSIOONI, MILLES ON KASUTATUD VAHEMALT 4 ERINEVAT TUUPI
        // void, String, int, char, long, double, float, boolean
        // TAGASTAB int     parameetriks boolean
        // TAGASTAB void    parameetriks boolean, int
        // TAGASTAB String  parameetriks String

        // TEHA IGAST FUNKTSIOONIST 2 ERINEVA SISENDIGA VALJAKUTSET

        /*double kogumaksumus1 = arvutaTaksoMaksumus(3);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = arvutaTaksoMaksumus(2);
        System.out.println(kogumaksumus2);

        String hinnang1 = temperatuuriHinnang(-1.2);
        System.out.println(hinnang1);
        String hinnang2 = temperatuuriHinnang(2.2);
        System.out.println(hinnang2);

        prindiForTsykkel("Pikk sõna");
        prindiForTsykkel("Lüh");*/

        String check1 = jahVoiEi(true);
        System.out.println(check1);
        String check2 = jahVoiEi(false);
        System.out.println(check2);

        int sum = printSum(1,3);
        System.out.println(sum);
        int sum2 = printSum(100,43);
        System.out.println(sum2);

        printMessageLoop(2, false);
        printMessageLoop(213, true);
    }

    /*private static double arvutaTaksoMaksumus(int tunnid) {
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
    }*/

    private static String jahVoiEi(boolean check){
        if (check) {
            return "oige";
        } else {
            return "vale";
        }

    }

    public static int printSum(int num1, int num2) {
        return num1 + num2;
    }

    public static void printMessageLoop(int number, boolean yesno) {
        if (yesno)
            for (int i = 0; i < number; i++) {
                System.out.println(i);
            } else {
            System.out.println("Sisend oli puudulik");
        }
    }
}