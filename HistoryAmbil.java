
public class HistoryAmbil {
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

    public void tampilAmbil(HistoryAmbil[] hAmbil) {
        System.out.println("No. \t Tanggal \t Nominal");
        int i = 0;
        for (HistoryAmbil hAmbil2 : hAmbil) {
            i = i + 1;
            System.out.println((i) + "\t" + hAmbil2.getTanggal() + " \t " + hAmbil2.getNominal());
        }
    }

}
