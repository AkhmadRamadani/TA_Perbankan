// import java.util.Scanner;

public class HistoryTransfer {
    private int noRekTujuan;
    private double nominal;
    private String tanggal;
    private String catatan;

    public int getNoRekTujuan() {
        return noRekTujuan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public void setNoRekTujuan(int noRekTujuan) {
        this.noRekTujuan = noRekTujuan;
    }

    public void tampilHistory(HistoryTransfer[] hTransfer) {
        System.out.println("No. \t Tanggal \t Tujuan \t Nominal \t Catatan");
        int i = 0;
        for (HistoryTransfer newHTransfer : hTransfer) {
            i = i+1;
            System.out.println((i)+"\t"+newHTransfer.getTanggal() + " \t " + newHTransfer.getNoRekTujuan() + " \t "
                    + newHTransfer.getNominal() + " \t " + newHTransfer.getCatatan());
        }
    }

}
