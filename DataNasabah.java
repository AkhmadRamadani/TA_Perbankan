import java.util.Scanner;

public class DataNasabah {
    private String namaNasabah;
    private int noRekNasabah;
    private int pinNasabah;
    private JenisTabungan jenisTabungan;
    private double saldoNasabah;
    private HistoryTransfer historyTransfer[];
    private HistorySetor historySetor[];
    private HistoryAmbil historyAmbil[];

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public HistoryAmbil[] getHistoryAmbil() {
        return historyAmbil;
    }

    public void setHistoryAmbil(HistoryAmbil historyAmbil[]) {
        this.historyAmbil = historyAmbil;
    }

    public HistorySetor[] getHistorySetor() {
        return historySetor;
    }

    public void setHistorySetor(HistorySetor historySetor[]) {
        this.historySetor = historySetor;
    }

    public HistoryTransfer[] getHistoryTransfer() {
        return historyTransfer;
    }

    public void setHistoryTransfer(HistoryTransfer historyTransfer[]) {
        this.historyTransfer = historyTransfer;
    }

    public double getSaldoNasabah() {
        return saldoNasabah;
    }

    public void setSaldoNasabah(double saldoNasabah) {
        this.saldoNasabah = saldoNasabah;
    }

    public JenisTabungan getJenisTabungan() {
        return jenisTabungan;
    }

    public void setJenisTabungan(JenisTabungan jenisTabungan) {
        this.jenisTabungan = jenisTabungan;
    }

    public int getPinNasabah() {
        return pinNasabah;
    }

    public void setPinNasabah(int pinNasabah) {
        this.pinNasabah = pinNasabah;
    }

    public int getNoRekNasabah() {
        return noRekNasabah;
    }

    public void setNoRekNasabah(int noRekNasabah) {
        this.noRekNasabah = noRekNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public void setDataNasabah(String namaNasabah, int noRekNasabah, int pinNasabah, JenisTabungan jenisTabungan,
            double saldoNasabah, HistoryTransfer[] historyTransfer, HistorySetor[] historySetor,
            HistoryAmbil[] historyAmbil) {
        this.namaNasabah = namaNasabah;
        this.noRekNasabah = noRekNasabah;
        this.pinNasabah = pinNasabah;
        this.jenisTabungan = jenisTabungan;
        this.saldoNasabah = saldoNasabah;
        this.historyTransfer = historyTransfer;
        this.historySetor = historySetor;
        this.historyAmbil = historyAmbil;
    }

    public int pilihJenisTabungan(Scanner scanner) {
        System.out.println("----- Pilih Jenis Tabungan -----");
        int i = 1;
        for (JenisTabungan jenist : JenisTabungan.values()) {
            System.out.println(i + ": " + jenist);
            i = i + 1;
        }
        System.out.println("Input: ");
        int pilihan = scanner.nextInt();
        return pilihan;
    }

    public void showDataNasabah() {
        System.out.println("----- Data Nasabah -----");
        System.out.println("Nama \t\t: " + getNamaNasabah());
        System.out.println("No Rekening \t: " + getNoRekNasabah());
        System.out.println("Jenis Tabungan \t: " + getJenisTabungan());
        System.out.println("Saldo \t\t: " + getSaldoNasabah());
    }
}
