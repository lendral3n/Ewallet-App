package ewalletapp;

public class Topup extends Transaction {
    private String nomorReferensi;
    private String metodePembayaran;

    public Topup(double nominal, Customer customer, String nomorReferensi, String metodePembayaran) {
        super(nominal, customer);
        this.nomorReferensi = nomorReferensi;
        this.metodePembayaran = metodePembayaran;
    }

    @Override
    public void cetakInformasiTransaksi() {
        System.out.println("Topup: " + getNominal() + ", Referensi: " + nomorReferensi + ", Metode: " + metodePembayaran + ", Tanggal: " + getTanggal());
    }
}
