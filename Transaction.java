package ewalletapp;

import java.util.Date;

public abstract class Transaction {
    private double nominal;
    private Date tanggal;
    private Customer customer;

    public Transaction(double nominal, Customer customer) {
        this.nominal = nominal;
        this.tanggal = new Date();
        this.customer = customer;
    }

    public double getNominal() {
        return nominal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract void cetakInformasiTransaksi();
}