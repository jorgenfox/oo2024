public class Info {
    String nimetus;
    int ram;
    String graafikaKaart;

    public Info(String nimetus, int ram, String graafikaKaart) {
        this.nimetus = nimetus;
        this.ram = ram;
        this.graafikaKaart = graafikaKaart;
    }

    public void muudaNimetus(String uusNimetus) {
        nimetus = uusNimetus;
    }
}