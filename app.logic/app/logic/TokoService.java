package app.logic;

import app.data.Buku;
import app.data.Database;

import java.util.ArrayList;
import java.util.List;

public class TokoService {

    public List<BukuInfo> getDaftarBuku() {

        List<BukuInfo> hasil = new ArrayList<>();

        for (Buku buku : Database.getDaftarBuku()) {

            hasil.add(
                    new BukuInfo(
                            buku.getJudul(),
                            buku.getHarga(),
                            buku.getStok()
                    )
            );
        }

        return hasil;
    }

    public double beliBuku(int index,
                           int jumlah) {

        Buku buku =
                Database.getDaftarBuku()
                        .get(index);

        if (jumlah > buku.getStok()) {
            return -1;
        }

        double total =
                buku.getHarga() * jumlah;

        if (total > 100000) {
            total -= total * 0.1;
        }

        buku.kurangiStok(jumlah);

        return total;
    }
}