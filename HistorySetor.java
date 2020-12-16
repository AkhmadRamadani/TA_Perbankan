
public class HistorySetor {
    private String tanggal;
    private double nominal;

    public String getTanggal() {
        return tanggal;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void tampilSetor(HistorySetor[] hSetor) {
        System.out.println("No. \t Tanggal \t Nominal");
        int i = 0;
        for (HistorySetor hSetor2 : hSetor) {
            i = i + 1;
            System.out.println((i) + "\t" + hSetor2.getTanggal() + " \t " + hSetor2.getNominal());
        }
    }
}
