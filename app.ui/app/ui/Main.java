package app.ui;

import app.logic.BukuInfo;
import app.logic.TokoService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TokoService service = new TokoService();

        while (true) {

            System.out.println("\n===== TOKO BUKU DIGITAL =====");

            List<BukuInfo> daftar =
                    service.getDaftarBuku();

            for (int i = 0; i < daftar.size(); i++) {

                BukuInfo buku =
                        daftar.get(i);

                System.out.println(
                        (i + 1) + ". "
                                + buku.getJudul()
                                + " | Rp "
                                + buku.getHarga()
                                + " | Stok "
                                + buku.getStok()
                );
            }

            System.out.println("0. Keluar");

            System.out.print("Pilih Buku : ");
            int pilih = input.nextInt();

            if (pilih == 0) {
                break;
            }

            System.out.print("Jumlah : ");
            int jumlah = input.nextInt();

            double total =
                    service.beliBuku(
                            pilih - 1,
                            jumlah);

            if (total == -1) {

                System.out.println(
                        "Stok tidak cukup");

            } else {

                System.out.println(
                        "Total Bayar = Rp "
                                + total);
            }
        }

        System.out.println("Terima kasih.");
    }
}