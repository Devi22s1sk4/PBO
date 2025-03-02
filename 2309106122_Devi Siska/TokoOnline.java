import java.util.ArrayList;
import java.util.Scanner;

class Produk {
    private String id;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void tampilkanInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
        System.out.println("-----------------------------");
    }
}

class Pelanggan {
    private String id;
    private String nama;
    private String alamat;

    public Pelanggan(String id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void tampilkanInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("-----------------------------");
    }
}

class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Produk produk;
    private int jumlah;

    public Transaksi(String idTransaksi, Pelanggan pelanggan, Produk produk, int jumlah) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public void tampilkanInfo() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("Produk: " + produk.getNama());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Total Harga: Rp" + (produk.getHarga() * jumlah));
        System.out.println("-----------------------------");
    }
}

public class TokoOnline {
    private ArrayList<Produk> daftarProduk = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TokoOnline toko = new TokoOnline();
        toko.menu();
    }

    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Sistem Manajemen Toko Online ===");
            System.out.println("1. Kelola Produk");
            System.out.println("2. Kelola Pelanggan");
            System.out.println("3. Transaksi Pembelian");
            System.out.println("4. Laporan Penjualan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    kelolaProduk();
                    break;
                case 2:
                    kelolaPelanggan();
                    break;
                case 3:
                    transaksiPembelian();
                    break;
                case 4:
                    laporanPenjualan();
                    break;
                case 5:
                    running = false;
                    System.out.println("Program selesai. TERIMA KASIH");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        scanner.close();
    }

    private void kelolaProduk() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n=== Kelola Produk ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Daftar Produk");
            System.out.println("3. Cari Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    tampilkanDaftarProduk();
                    break;
                case 3:
                    cariProduk();
                    break;
                case 4:
                    hapusProduk();
                    break;
                case 5:
                    kembali = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private void tambahProduk() {
        System.out.print("Masukkan ID Produk: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Produk: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga Produk: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan Stok Produk: ");
        int stok = scanner.nextInt();
        scanner.nextLine();

        Produk produk = new Produk(id, nama, harga, stok);
        daftarProduk.add(produk);
        System.out.println("Produk berhasil ditambahkan.");
    }

    private void tampilkanDaftarProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Daftar produk kosong.");
        } else {
            System.out.println("\nDaftar Produk:");
            for (Produk produk : daftarProduk) {
                produk.tampilkanInfo();
            }
        }
    }

    private void cariProduk() {
        System.out.print("Masukkan ID atau Nama Produk: ");
        String keyword = scanner.nextLine();
        boolean ditemukan = false;

        for (Produk produk : daftarProduk) {
            if (produk.getId().equalsIgnoreCase(keyword) || produk.getNama().equalsIgnoreCase(keyword)) {
                System.out.println("\nProduk ditemukan:");
                produk.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private void hapusProduk() {
        System.out.print("Masukkan ID Produk yang ingin dihapus: ");
        String id = scanner.nextLine();
        boolean ditemukan = false;

        for (Produk produk : daftarProduk) {
            if (produk.getId().equalsIgnoreCase(id)) {
                daftarProduk.remove(produk);
                System.out.println("Produk berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk dengan ID '" + id + "' tidak ditemukan.");
        }
    }

    private void kelolaPelanggan() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n=== Kelola Pelanggan ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Tampilkan Daftar Pelanggan");
            System.out.println("3. Cari Pelanggan");
            System.out.println("4. Kembali");
            System.out.print("Pilih menu (1-4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahPelanggan();
                    break;
                case 2:
                    tampilkanDaftarPelanggan();
                    break;
                case 3:
                    cariPelanggan();
                    break;
                case 4:
                    kembali = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private void tambahPelanggan() {
        System.out.print("Masukkan ID Pelanggan: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Alamat Pelanggan: ");
        String alamat = scanner.nextLine();

        Pelanggan pelanggan = new Pelanggan(id, nama, alamat);
        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    private void tampilkanDaftarPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Daftar pelanggan kosong.");
        } else {
            System.out.println("\nDaftar Pelanggan:");
            for (Pelanggan pelanggan : daftarPelanggan) {
                pelanggan.tampilkanInfo();
            }
        }
    }

    private void cariPelanggan() {
        System.out.print("Masukkan ID atau Nama Pelanggan: ");
        String keyword = scanner.nextLine();
        boolean ditemukan = false;

        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getId().equalsIgnoreCase(keyword) || pelanggan.getNama().equalsIgnoreCase(keyword)) {
                System.out.println("\nPelanggan ditemukan:");
                pelanggan.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Pelanggan tidak ditemukan.");
        }
    }

    private void transaksiPembelian() {
        if (daftarPelanggan.isEmpty() || daftarProduk.isEmpty()) {
            System.out.println("Tidak dapat melakukan transaksi. Pastikan ada pelanggan dan produk terdaftar.");
            return;
        }

        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();
        Pelanggan pelanggan = null;

        for (Pelanggan p : daftarPelanggan) {
            if (p.getId().equalsIgnoreCase(idPelanggan)) {
                pelanggan = p;
                break;
            }
        }

        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan ID Produk: ");
        String idProduk = scanner.nextLine();
        Produk produk = null;

        for (Produk p : daftarProduk) {
            if (p.getId().equalsIgnoreCase(idProduk)) {
                produk = p;
                break;
            }
        }

        if (produk == null) {
            System.out.println("Produk tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan Jumlah Pembelian: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); 

        if (produk.getStok() < jumlah) {
            System.out.println("Stok produk tidak mencukupi.");
            return;
        }

        produk.setStok(produk.getStok() - jumlah);

        String idTransaksi = "TRX" + (daftarTransaksi.size() + 1);
        Transaksi transaksi = new Transaksi(idTransaksi, pelanggan, produk, jumlah);
        daftarTransaksi.add(transaksi);

        System.out.println("Transaksi berhasil dilakukan.");
        transaksi.tampilkanInfo();
    }

    private void laporanPenjualan() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            System.out.println("\nLaporan Penjualan:");
            for (Transaksi transaksi : daftarTransaksi) {
                transaksi.tampilkanInfo();
            }
        }
    }
}