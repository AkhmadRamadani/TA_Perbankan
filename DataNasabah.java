import java.util.*;

public class DataNasabah {
    private String nama;
    private String alamat;
    private Tabungan jenisTabungan;
    private int pin;
    private int nomorRekening;
    private double saldo;
    private ArrayList<Transfer> dTransfers;
    private ArrayList<HistorySetor> historySetors;
    private ArrayList<HistoryAmbil> historyAmbils;

    public String getNama() {
        return nama;
    }

    public int getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(int nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public ArrayList<HistoryAmbil> getHistoryAmbils() {
        return historyAmbils;
    }

    public void setHistoryAmbils(ArrayList<HistoryAmbil> historyAmbils) {
        this.historyAmbils = historyAmbils;
    }

    public ArrayList<HistorySetor> getHistorySetors() {
        return historySetors;
    }

    public void setHistorySetors(ArrayList<HistorySetor> historySetors) {
        this.historySetors = historySetors;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Tabungan getJenisTabungan() {
        return jenisTabungan;
    }

    public void setJenisTabungan(Tabungan jenisTabungan) {
        this.jenisTabungan = jenisTabungan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public ArrayList<Transfer> getdTransfers() {
        return dTransfers;
    }

    public void setdTransfers(ArrayList<Transfer> dTransfers) {
        this.dTransfers = dTransfers;
    }

    

    public DataNasabah(){

    }

    public DataNasabah(String nama, String alamat, Tabungan jenisTabungan, int pin, int nomorRekening, double saldo,
            ArrayList<Transfer> dTransfers, ArrayList<HistorySetor> historySetors,
            ArrayList<HistoryAmbil> historyAmbils) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisTabungan = jenisTabungan;
        this.pin = pin;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.dTransfers = dTransfers;
        this.historySetors = historySetors;
        this.historyAmbils = historyAmbils;
    }
    
    public void getDataNasabah(){
        System.out.println("Nama\t: "+getNama());
        System.out.println("Alamat\t: "+getAlamat());
        System.out.println("Bank\t: "+getJenisTabungan().getJenisTabungan());
        // System.out.println(""getJenisTabungan().getBunga());
    }
}
