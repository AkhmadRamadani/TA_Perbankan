import java.util.Scanner;

public class Transfer {
    private String noRekening;
    private int nominal;
    private String catatan;
    private String tanggal;

    public String getNoRekening() {
        return noRekening;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getCatatan() {
        return catatan;
    }
    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }


    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public Transfer(String noRekening, int nominal, String catatan, String tanggal) {
        this.noRekening = noRekening;
        this.nominal = nominal;
        this.catatan = catatan;
        this.tanggal = tanggal;
    }
    
    public int menuTransfer(Scanner scanner){
        int menu = 1;
        System.out.println("----- Pilih Menu -----\n");
        System.out.println("1. Transfer");
        System.out.println("2. Lihat History Transfer");
        System.out.println("Inputkan lainnya untuk keluar");

        System.out.print("Pilih menu: ");
        menu = scanner.nextInt();
        // scanner.close();
        return menu;
    }

    public Transfer() {
    }
}
