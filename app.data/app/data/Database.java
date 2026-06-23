package app.data;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final List<Buku> daftarBuku =
            new ArrayList<>();

    static {

        daftarBuku.add(
                new Buku(
                        "Laskar Pelangi",
                        90000,
                        10));

        daftarBuku.add(
                new Buku(
                        "Atomic Habits",
                        120000,
                        5));

        daftarBuku.add(
                new Buku(
                        "Bumi",
                        85000,
                        8));
    }

    public static List<Buku> getDaftarBuku() {
        return daftarBuku;
    }
}