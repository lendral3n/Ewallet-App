package ewalletapp;

// Class Customer merepresentasikan pelanggan dalam aplikasi Ewallet
public class Customer {
    private String nama;
    private String alamat;
    private Ewallet ewallet;

     // Constructor untuk menginisialisasi objek Customer dengan nama dan alamat
    public Customer(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
        this.ewallet = new Ewallet(this);
    }

    // Getter dan setter untuk nama dan alamat
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

     // Getter untuk Ewallet
    public Ewallet getEwallet() {
        return ewallet;
    }

    // Method untuk menampilkan profil customer
    public void cekProfil() {
        System.out.println("Nama: " + getNama());
        System.out.println("Alamat: " + getAlamat());
    }
}