package ewalletapp;

import java.util.Scanner;

// Class App merupakan titik masuk utama aplikasi Ewallet CLI
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama Anda: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat Anda: ");
        String alamat = scanner.nextLine();
        Customer customer = new Customer(nama, alamat);

        while (true) { // Loop while untuk memastikan menu terus ditampilkan
            System.out.println("\nPilih opsi:");
            System.out.println("1. Cek saldo");
            System.out.println("2. Topup");
            System.out.println("3. Transfer");
            System.out.println("4. Cek history transaksi");
            System.out.println("5. Cek profil");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    System.out.println();
                    customer.getEwallet().cekSaldo();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Masukkan jumlah topup: ");
                    double topupAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Masukkan nomor referensi: ");
                    String nomorReferensi = scanner.nextLine();
                    System.out.print("Masukkan metode pembayaran: ");
                    String metodePembayaran = scanner.nextLine();
                    customer.getEwallet().topup(topupAmount, nomorReferensi, metodePembayaran);
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Masukkan nama penerima: ");
                    String namaPenerima = scanner.nextLine();
                    System.out.print("Masukkan jumlah transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    Customer penerima = new Customer(namaPenerima, ""); // Dummy alamat
                    customer.getEwallet().transfer(penerima, transferAmount);
                    break;
                case 4:
                    System.out.println();
                    customer.getEwallet().cekHistory();
                    break;
                case 5:
                    System.out.println();
                    customer.cekProfil();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan Ewallet App.");
                    scanner.close();
                    return; // Keluar dari loop dan akhiri program
                default:
                    System.out.println();
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    System.out.println();
            }
            System.out.println();
        }
    }
}
