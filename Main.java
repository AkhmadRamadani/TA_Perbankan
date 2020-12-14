import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static ArrayList<DataNasabah> userList = new ArrayList<DataNasabah>();
    static DataNasabah currentDataNasabah = new DataNasabah();
    static Scanner scanner = new Scanner(System.in);
    static Transfer transfer = new Transfer();
    static HistorySetor setor = new HistorySetor();

    private static DataNasabah loginFunction() {
        System.out.print("Masukkan nomor rekening: ");
        int loginNoRek = scanner.nextInt();

        System.out.print("Masukkan pin: ");
        int loginPin = scanner.nextInt();

        for (DataNasabah login : userList) {
            if (login.getPin() == loginPin && login.getNomorRekening() == loginNoRek) {
                DataNasabah dataLoginNasabah = new DataNasabah(login.getNama(), login.getAlamat(),
                        login.getJenisTabungan(), login.getNomorRekening(), login.getPin(), login.getSaldo(),
                        login.getdTransfers(), login.getHistorySetors(), login.getHistoryAmbils());

                currentDataNasabah = dataLoginNasabah;
                return currentDataNasabah;

            }
        }
        return null;
    }

    private static void registerNasabah() {
        Tabungan jenisTabungan = new Tabungan();

        System.out.println("--------Pendaftaran Rekening Baru--------\n");
        scanner.nextLine();

        System.out.print("Masukkan Nama Anda: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Alamat Anda: ");
        String alamat = scanner.nextLine();

        jenisTabungan.pilihJenisTabungan(scanner);

        System.out.print("Inputkan No Rekening baru: ");
        int nomorRekening = scanner.nextInt();
        System.out.print("Inputkan pin baru: ");
        int pin = scanner.nextInt();

        DataNasabah newDataNasabah = new DataNasabah(nama, alamat, jenisTabungan, pin, nomorRekening, 0, null, null,
                null);

        userList.add(newDataNasabah);
    }

    static void tampilUser() {
        for (DataNasabah dataNasabah : userList) {
            dataNasabah.getDataNasabah();
        }
    }

    static void pilihMenuAwal() {
        System.out.println("------Selamat Datang------\n");
        System.out.println("Pilih menu!!!");
        System.out.println("1. Login");
        System.out.println("2. Register");
    }

    static void pilihMenuLanjutan(String jenisTabungan) {
        System.out.println("-----Menu-----\n");
        if (jenisTabungan.equals("Konvensional")) {

            System.out.println("1. Transfer");
            System.out.println("2. Ambil Saldo");
            System.out.println("3. Setor");
            System.out.println("4. Cek saldo");
            System.out.println("5. Keluar");
        } else if (jenisTabungan.equals("Giro")) {

            System.out.println("1. Setor");
            System.out.println("2. Cek saldo");
            System.out.println("3. Keluar");
        } else if (jenisTabungan.equals("Deposito")) {
            System.out.println("1. Setor");
            System.out.println("2. Cek saldo");
            System.out.println("3. Keluar");
        }
    }

    static void menuSetelahLogin() {
        System.out.println("\nSelamat Datang: " + currentDataNasabah.getNama() + "\n");

        boolean keluar = false;
        do {
            pilihMenuLanjutan(currentDataNasabah.getJenisTabungan().getJenisTabungan());
            System.out.print("Pilih menu: ");
            int menuLanjutan = scanner.nextInt();

            switch (menuLanjutan) {
                case 1:
                    if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Konvensional")) {
                        int menuTransfer = transfer.menuTransfer(scanner);
                        switch (menuTransfer) {
                            case 1:
                                transferUang();
                                break;
                            case 2:
                                System.out.println("History");
                                break;

                            default:
                                break;
                        }
                        break;
                    } else if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Giro")
                            || currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Deposito")) {

                        int menuSetor = setor.menuSetor(scanner);
                        switch (menuSetor) {
                            case 1:
                                System.out.println("Setor");
                                break;
                            case 2:
                                System.out.println("History");
                                break;

                            default:
                                break;
                        }
                        break;
                    }

                    break;
                case 2:
                    if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Konvensional")) {
                        System.out.println("Ambil saldo");
                        break;
                    } else if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Giro")
                            || currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Deposito")) {
                        keluar = true;

                        break;
                    }

                    break;
                case 3:
                    if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Konvensional")) {
                        System.out.println("Setor saldo");
                        break;
                    } else if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Giro")
                            || currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Deposito")) {
                        System.out.println("Saldo");
                        System.out.println(currentDataNasabah.getSaldo());
                        break;
                    }

                    break;
                case 4:
                    if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Konvensional")) {
                        System.out.println("Saldo");
                        System.out.println(currentDataNasabah.getSaldo());
                        break;
                    } else if (currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Giro")
                            || currentDataNasabah.getJenisTabungan().getJenisTabungan().equals("Deposito")) {
                        keluar = true;

                        break;
                    }

                    break;
                default:
                    keluar = true;
                    break;
            }
        } while (!keluar);
    }

    static void transferUang() {
        Transfer newTransfer = new Transfer();
        scanner.nextLine();

        System.out.print("Masukkan no rek tujuan: ");
        newTransfer.setNoRekening(scanner.nextLine());

        System.out.print("Masukkan jml uang: ");
        int nominal = scanner.nextInt();
        newTransfer.setNominal(nominal);

        System.out.print("Masukkan catatan: ");
        newTransfer.setCatatan(scanner.nextLine());

        String tglSekarang = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        tglSekarang = dtf.format(now).toString();

        newTransfer.setTanggal(tglSekarang);

        ArrayList<Transfer> dTransfers = new ArrayList<Transfer>();
        dTransfers.add(newTransfer);
        currentDataNasabah.setdTransfers(dTransfers);
        double saldo = (currentDataNasabah.getSaldo() - nominal);
        currentDataNasabah.setSaldo(saldo);
    }

    public static void main(String[] args) {
        DataNasabah dataNasabah = new DataNasabah();
        Tabungan jenisTabungan = new Tabungan();
        // ArrayList<DataNasabah> userList = new ArrayList<>();
        ArrayList<Transfer> dTransfers = new ArrayList<Transfer>();
        ArrayList<HistorySetor> historySetors = new ArrayList<HistorySetor>();
        ArrayList<HistoryAmbil> historyAmbils = new ArrayList<HistoryAmbil>();
        // dataNasabah.setJenisTabungan(jenisTabungan);
        jenisTabungan.setJenisTabungan("Konvensional");
        jenisTabungan.setBunga(3);

        dataNasabah.setNama("Akhmad Ramadani");
        dataNasabah.setAlamat("Jl. Polowijen");
        dataNasabah.setJenisTabungan(jenisTabungan);
        dataNasabah.setSaldo(100000);
        dataNasabah.setdTransfers(dTransfers);
        dataNasabah.setHistoryAmbils(historyAmbils);
        dataNasabah.setHistorySetors(historySetors);
        dataNasabah.setPin(123456);
        dataNasabah.setNomorRekening(123456);

        userList.add(dataNasabah);

        int menu = 0;
        boolean exitApp = false;
        do {
            pilihMenuAwal();
            System.out.print("Pilih menu: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    int counter = 0;
                    boolean loginStop = false;
                    do {
                        loginStop = loginFunction() == null ? false : true;
                        counter += 1;
                        // System.out.println(counter);
                    } while (!loginStop && counter <= 2);
                    if (loginStop) {
                        menuSetelahLogin();
                    }
                    break;
                case 2:
                    registerNasabah();
                    break;
                case 3:
                    tampilUser();
                    break;
                default:
                    exitApp = true;
                    break;
            }
        } while (!exitApp);

        // System.out.println(currentDataNasabah.getNama());

        // jenisTabungan.pilihJenisTabungan();
    }
}
