package ewalletapp;

public class Transfer extends Transaction {
    private Customer penerima;

    public Transfer(double nominal, Customer pengirim, Customer penerima) {
        super(nominal, pengirim);
        this.penerima = penerima;
    }

    @Override
    public void cetakInformasiTransaksi() {
        System.out.println("Transfer: " + getNominal() + ", Dari: " + getCustomer().getNama() + ", Ke: " + penerima.getNama() + ", Tanggal: " + getTanggal());
    }
}