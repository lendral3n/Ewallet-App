package ewalletapp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

// Class Ewallet merepresentasikan ewallet customer
public class Ewallet {
    private double saldo;
    private List<Transaction> transactions;
    private Customer owner;
    
    public Ewallet() {
        this.saldo = 0;
        this.transactions = new ArrayList<>();
    }

     // Constructor untuk menginisialisasi Ewallet dengan pemiliknya
    public Ewallet(Customer owner) {
        this.saldo = 0;
        this.transactions = new ArrayList<>();
        this.owner = owner;
    }

      // Getter untuk saldo
    public double getSaldo() {
        return saldo;
    }

     // Method untuk mengecek saldo 
    public void cekSaldo() {
        String saldoFormatted = String.format("%,.0f", saldo);
        System.out.println("Saldo saat ini: " + saldoFormatted);
    }

    // Format saldo ke dalam format lokal Indonesia tanpa simbol mata uang
    public void topup(double amount, String nomorReferensi, String metodePembayaran) {
        Topup topup = new Topup(amount, owner, nomorReferensi, metodePembayaran);
        this.saldo += amount;
        this.transactions.add(topup);
        System.out.println("Topup berhasil. Saldo saat ini: " + getSaldo());
    }

    // Method untuk melakukan transfer saldo ke pelanggan lain
    public void transfer(Customer penerima, double amount) {
        if (this.saldo >= amount) {
            Transfer transfer = new Transfer(amount, owner, penerima);
            this.saldo -= amount;
            penerima.getEwallet().saldo += amount; // Menambah saldo penerima
            this.transactions.add(transfer);
            System.out.println("Transfer berhasil. Saldo saat ini: " + getSaldo());
        } else {
            System.out.println("Saldo tidak cukup untuk transfer.");
        }
    }

     public void cekHistory() {
        System.out.println("History Transaksi:");
        for (Transaction t : transactions) {
            t.cetakInformasiTransaksi();
        }
    }
}