public class Tellimus {
    String tellija;
    double tellimuseKogusumma;
    String tellitavEse;

    public Tellimus(String _tellija, double _tellimuseKogusumma, String _tellitavEse) {
        tellija = _tellija;
        tellimuseKogusumma = _tellimuseKogusumma;
        tellitavEse = _tellitavEse;
    }

    public double tellimuseSummaDollarites() {
        return tellimuseKogusumma * 1.07;
    }

    public void tellijaNimeVahetus(String tellijaUusNimi) {
        tellija = tellijaUusNimi;
    }
}
