import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static DataNasabah dataNasabah[] = new DataNasabah[2];
    static HistoryAmbil initialHistoryAmbil[] = new HistoryAmbil[2];
    static HistoryTransfer initialHistoryTransfer[] = new HistoryTransfer[2];
    static HistorySetor initialHistorySetor[] = new HistorySetor[2];

    static DataNasabah currentDataNasabah = new DataNasabah();
    static HistoryTransfer historyTransfer = new HistoryTransfer();
    static HistoryAmbil historyAmbil = new HistoryAmbil();
    static HistorySetor historySetor = new HistorySetor();

    static Scanner scanner = new Scanner(System.in);

    static void initializeArray() {
        for (int i = 0; i < dataNasabah.length; i++) {
            dataNasabah[i] = new DataNasabah();
        }
        for (int i = 0; i < initialHistoryAmbil.length; i++) {
            initialHistoryAmbil[i] = new HistoryAmbil();
        }
        for (int i = 0; i < initialHistorySetor.length; i++) {
            initialHistorySetor[i] = new HistorySetor();
        }
        for (int i = 0; i < initialHistoryTransfer.length; i++) {
            initialHistoryTransfer[i] = new HistoryTransfer();
        }
    }

    static void initialSetup() {
        dataNasabah[0].setNamaNasabah("Akhmad Ramadani");
        dataNasabah[0].setNoRekNasabah(123456);
        dataNasabah[0].setPinNasabah(123456);
        dataNasabah[0].setJenisTabungan(JenisTabungan.KONVENSIONAL);
        dataNasabah[0].setSaldoNasabah(1000000);

        initialHistoryAmbil[0].setTanggal("10/06/2020");
        initialHistoryAmbil[0].setNominal(50000);

        initialHistoryTransfer[0].setTanggal("10/06/2020");
        initialHistoryTransfer[0].setNominal(50000);
        initialHistoryTransfer[0].setCatatan("Buat beli bakwan");
        initialHistoryTransfer[0].setNoRekTujuan(123321);

        initialHistorySetor[0].setTanggal("20/06/2020");
        initialHistorySetor[0].setNominal(100000);

        dataNasabah[0].setHistoryAmbil(initialHistoryAmbil);
        dataNasabah[0].setHistorySetor(initialHistorySetor);
        dataNasabah[0].setHistoryTransfer(initialHistoryTransfer);
    }

    private static DataNasabah loginFunction() {
        System.out.print("Masukkan nomor rekening: ");
        int loginNoRek = scanner.nextInt();

        System.out.print("Masukkan pin: ");
        int loginPin = scanner.nextInt();

        for (DataNasabah login : dataNasabah) {
            if (login.getPinNasabah() == loginPin && login.getNoRekNasabah() == loginNoRek) {
                DataNasabah dataLoginNasabah = new DataNasabah();
                dataLoginNasabah.setDataNasabah(login.getNamaNasabah(), login.getNoRekNasabah(), login.getPinNasabah(),
                        login.getJenisTabungan(), login.getSaldoNasabah(), login.getHistoryTransfer(),
                        login.getHistorySetor(), login.getHistoryAmbil());

                currentDataNasabah = dataLoginNasabah;
                return currentDataNasabah;

            }
        }
        return null;
    }

    static void registerFunction() {
        System.out.println("--------Pendaftaran Rekening Baru--------\n");
        scanner.nextLine();

        System.out.print("Masukkan Nama Anda: ");
        String nama = scanner.nextLine();
        boolean inputanBenar = false;
        JenisTabungan jTabungan = null;

        do {
            int pilihan = dataNasabah[1].pilihJenisTabungan(scanner);
            if (pilihan == 1) {
                jTabungan = JenisTabungan.KONVENSIONAL;
                inputanBenar = true;
            } else if (pilihan == 2) {
                jTabungan = JenisTabungan.GIRO;
                inputanBenar = true;
            } else if (pilihan == 3) {
                jTabungan = JenisTabungan.DEPOSITO;
                inputanBenar = true;
            } else {
                System.out.println("Inputan salah!!!");
            }
        } while (!inputanBenar);

        System.out.print("Inputkan No Rekening baru: ");
        int nomorRekening = scanner.nextInt();
        System.out.print("Inputkan pin baru: ");
        int pin = scanner.nextInt();

        dataNasabah[1].setDataNasabah(nama, nomorRekening, pin, jTabungan, 0, null, null, null);
    }

    static int initialMenu() {
        System.out.println("----- Pilih Menu -----");
        System.out.println("1. Login");
        System.out.println("2. Register\n");
        System.out.println("Input lainnya untuk keluar");

        System.out.print("Input: ");
        int pilihan = scanner.nextInt();
        return pilihan;
    }

    static void menuAfterLogin() {
        if (currentDataNasabah.getJenisTabungan() == JenisTabungan.KONVENSIONAL) {
            menuKonvensional();
        } else {
            nonKonvensional();
        }
        // return 1;
    }

    static void menuKonvensional() {
        boolean exitMenu = false;
        do {
            System.out.println("----- Pilih menu -----");
            System.out.println("1. Transfer");
            System.out.println("2. Setor Saldo");
            System.out.println("3. Ambil Saldo");
            System.out.println("4. Cek Saldo");
            System.out.println("5. Lihat Data Akun");
            System.out.println("Input lainnya untuk keluar");

            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    menuTransfer();
                    break;
                case 2:
                    menuSetor();
                    break;
                case 3:
                    menuAmbil();
                    break;
                case 4:
                    System.out.println("Saldo saat ini: " + currentDataNasabah.getSaldoNasabah());
                    break;
                case 5:
                    currentDataNasabah.showDataNasabah();
                    break;
                default:
                    exitMenu = true;
                    break;
            }
        } while (!exitMenu);
    }

    static void nonKonvensional() {
        boolean exitMenu = false;
        do {
            System.out.println("----- Pilih menu -----");
            System.out.println("1. Setor Saldo");
            System.out.println("2. Cek Saldo");
            System.out.println("3. Lihat Data Akun");
            System.out.println("Input lainnya untuk keluar");
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    menuSetor();
                    break;
                case 2:
                    System.out.println("Saldo saat ini: " + currentDataNasabah.getSaldoNasabah());
                    break;
                case 3:
                    currentDataNasabah.showDataNasabah();
                    break;
                default:
                    exitMenu = true;
                    break;
            }
        } while (!exitMenu);
    }

    static void menuTransfer() {
        boolean exitMenu = false;
        do {
            System.out.println("----- Pilih Menu -----");
            System.out.println("1. Transfer");
            System.out.println("2. Lihat History Transfer");
            System.out.println("Input lainnya untuk keluar");
            System.out.print("Input: ");
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    transferFunction();
                    break;
                case 2:
                    historyTransfer.tampilHistory(currentDataNasabah.getHistoryTransfer());
                    break;
                default:
                    exitMenu = true;
                    break;
            }
        } while (!exitMenu);
    }

    static void menuAmbil() {
        boolean exitMenu = false;
        do {
            System.out.println("----- Pilih Menu -----");
            System.out.println("1. Ambil");
            System.out.println("2. Lihat History Ambil");
            System.out.println("Input lainnya untuk keluar");
            System.out.print("Input: ");
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    ambilFunction();
                    break;
                case 2:
                    historyAmbil.tampilAmbil(currentDataNasabah.getHistoryAmbil());
                    break;
                default:
                    exitMenu = true;
                    break;
            }
        } while (!exitMenu);
    }

    static void menuSetor() {
        boolean exitMenu = false;
        do {
            System.out.println("----- Pilih Menu -----");
            System.out.println("1. Setor");
            System.out.println("2. Lihat History Setoran");
            System.out.println("Input lainnya untuk keluar");
            System.out.print("Input: ");
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    setorFunction();
                    break;
                case 2:
                    historySetor.tampilSetor(currentDataNasabah.getHistorySetor());
                    break;
                default:
                    exitMenu = true;
                    break;
            }
        } while (!exitMenu);
    }

    static void transferFunction() {
        System.out.println("----- Transfer -----");
        System.out.print("Masukkan no rekening tujuan: ");
        int noRekTujuan = scanner.nextInt();
        System.out.print("Masukkan nominal: ");
        double nominal = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan catatan: ");
        String catatan = scanner.nextLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String tglSekarang = dtf.format(now).toString();

        HistoryTransfer transfer[] = new HistoryTransfer[2];
        if (currentDataNasabah.getHistoryTransfer() != null) {
            if (currentDataNasabah.getHistoryTransfer()[0] == null) {
                transfer[0] = new HistoryTransfer();
                transfer[0].setNoRekTujuan(noRekTujuan);
                transfer[0].setNominal(nominal);
                transfer[0].setTanggal(tglSekarang);
                transfer[0].setCatatan(catatan);
            } else {
                transfer[0] = new HistoryTransfer();
                transfer[0] = currentDataNasabah.getHistoryTransfer()[0];
                transfer[1] = new HistoryTransfer();
                transfer[1].setNoRekTujuan(noRekTujuan);
                transfer[1].setNominal(nominal);
                transfer[1].setTanggal(tglSekarang);
                transfer[1].setCatatan(catatan);
            }
        } else {
            transfer[0] = new HistoryTransfer();
            transfer[0].setNoRekTujuan(noRekTujuan);
            transfer[0].setNominal(nominal);
            transfer[0].setTanggal(tglSekarang);
            transfer[0].setCatatan(catatan);
            transfer[1] = new HistoryTransfer();

        }

        currentDataNasabah.setHistoryTransfer(transfer);
        double saldoBaru = currentDataNasabah.getSaldoNasabah() - nominal;
        currentDataNasabah.setSaldoNasabah(saldoBaru);
    }

    static void setorFunction() {
        System.out.println("----- Setor -----");
        System.out.print("Masukkan nominal: ");
        double nominal = scanner.nextDouble();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String tglSekarang = dtf.format(now).toString();

        HistorySetor Setor[] = new HistorySetor[2];
        if (currentDataNasabah.getHistorySetor() != null) {
            if (currentDataNasabah.getHistorySetor()[0] == null) {
                Setor[0] = new HistorySetor();
                Setor[0].setNominal(nominal);
                Setor[0].setTanggal(tglSekarang);
            } else {
                Setor[0] = new HistorySetor();
                Setor[0] = currentDataNasabah.getHistorySetor()[0];
                Setor[1] = new HistorySetor();
                Setor[1].setNominal(nominal);
                Setor[1].setTanggal(tglSekarang);
            }
        } else {
            Setor[0] = new HistorySetor();
            Setor[0].setNominal(nominal);
            Setor[0].setTanggal(tglSekarang);
            Setor[1] = new HistorySetor();

        }

        currentDataNasabah.setHistorySetor(Setor);
        double saldoBaru = currentDataNasabah.getSaldoNasabah() + nominal;
        currentDataNasabah.setSaldoNasabah(saldoBaru);
    }

    static void ambilFunction() {
        System.out.println("----- Ambil -----");
        System.out.print("Masukkan nominal: ");
        double nominal = scanner.nextDouble();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String tglSekarang = dtf.format(now).toString();

        HistoryAmbil Ambil[] = new HistoryAmbil[2];
        if (currentDataNasabah.getHistoryAmbil() != null) {
            if (currentDataNasabah.getHistoryAmbil()[0] == null) {
                Ambil[0] = new HistoryAmbil();
                Ambil[0].setNominal(nominal);
                Ambil[0].setTanggal(tglSekarang);
            } else {
                Ambil[0] = new HistoryAmbil();
                Ambil[0] = currentDataNasabah.getHistoryAmbil()[0];
                Ambil[1] = new HistoryAmbil();
                Ambil[1].setNominal(nominal);
                Ambil[1].setTanggal(tglSekarang);
            }
        } else {
            Ambil[0] = new HistoryAmbil();
            Ambil[0].setNominal(nominal);
            Ambil[0].setTanggal(tglSekarang);
            Ambil[1] = new HistoryAmbil();

        }

        currentDataNasabah.setHistoryAmbil(Ambil);
        double saldoBaru = currentDataNasabah.getSaldoNasabah() - nominal;
        currentDataNasabah.setSaldoNasabah(saldoBaru);
    }

    public static void main(String[] args) {
        initializeArray();
        initialSetup();

        boolean exitApp = false;
        do {
            int menu = initialMenu();
            switch (menu) {
                case 1:
                    int counter = 0;
                    boolean loginStop = false;
                    do {
                        loginStop = loginFunction() == null ? false : true;
                        counter += 1;
                    } while (!loginStop && counter <= 2);
                    if (loginStop) {
                        menuAfterLogin();
                    }
                    break;
                case 2:
                    registerFunction();
                    break;

                default:
                    exitApp = true;
                    break;
            }
        } while (!exitApp);

    }
}
