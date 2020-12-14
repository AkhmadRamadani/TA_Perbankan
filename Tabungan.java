import java.util.Scanner;

public class Tabungan {
    private String jenisTabungan;
    private int bunga;

    public String getJenisTabungan() {
        return jenisTabungan;
    }

    public int getBunga() {
        return bunga;
    }

    public void setBunga(int bunga) {
        this.bunga = bunga;
    }

    public void setJenisTabungan(String jenisTabungan) {
        this.jenisTabungan = jenisTabungan;
    }

    public void pilihBunga(int jenisTabungan) {
        if (jenisTabungan == 1) {
            setJenisTabungan("Konvensional");
            setBunga(3);
        } else if (jenisTabungan == 2) {

            setJenisTabungan("Giro");
            setBunga(2);
        } else if (jenisTabungan == 3) {

            setJenisTabungan("Deposito");
            setBunga(3);
        }
    }

    public void pilihJenisTabungan(Scanner scanner){
        // Scanner scanner = new Scanner(System.in);
        System.out.println("-------Jenis Tabungan Beserta Bunga-------\n");
        System.out.println("1. Konvensional\t : 3%");
        System.out.println("2. Giro\t\t : 2%");
        System.out.println("3. Deposito\t : 5%");
        System.out.print("\nPilih Jenis Tabungan (Input Angka): ");
        int pilihan = scanner.nextInt();

        pilihBunga(pilihan);
        // scanner.close();
    }
}
