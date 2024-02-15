public class Kursus {
    String kasutajanimi;
    String kursusenimi;
    int semester;
    boolean newsletter;
    int kursusePikkus;

    public Kursus(String kasutajanimi, String kursusenimi, int semester, boolean newsletter, int kursusePikkus) {
        this.kasutajanimi = kasutajanimi;
        this.kursusenimi = kursusenimi;
        this.semester = semester;
        this.newsletter = newsletter;
        this.kursusePikkus = kursusePikkus;
    }

    public void muudaSemester(int uusSemester) {
        semester = uusSemester;
    }

    public void muudaNews() {
        newsletter = !newsletter;
    }

    public int mituPaevaVeel(int tehtudPaevi) {
        kursusePikkus = kursusePikkus - tehtudPaevi;
        return kursusePikkus;
    }
}
