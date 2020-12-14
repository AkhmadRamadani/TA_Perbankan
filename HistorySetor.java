import java.util.Scanner;

public class HistorySetor {
    private int nominal;
    private String tanggal;

    public int getNominal() {
        return nominal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int menuSetor(Scanner scanner) {
        int menu = 1;
        System.out.println("----- Pilih Menu -----\n");
        System.out.println("1. Setor");
        System.out.println("2. Lihat History Setor");
        System.out.println("Inputkan lainnya untuk keluar");

        System.out.print("Pilih menu: ");
        menu = scanner.nextInt();
        // scanner.close();
        return menu;
    }
}
