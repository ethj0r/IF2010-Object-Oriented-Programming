public class KotakUtils {

    // Upper-bounded wildcard: membaca dari Kotak yang berisi subtype Barang apapun
    public static void tampilkanSemua(Kotak<? extends Barang> kotak) {
        // TODO: implementasi
        // Cetak info() setiap item, satu per baris
        // Jika kosong, cetak "Kotak kosong"
        if (kotak.kosong()) {
            System.out.println("Kotak kosong");
        }
        for (int i=0; i<kotak.jumlah(); i++) {
            System.out.println(kotak.lihat(i).info());
        }
    }

    // Upper-bounded wildcard: menghitung total harga
    public static int totalHarga(Kotak<? extends Barang> kotak) {
        // TODO: implementasi
        // return 0;
        int totalHarga = 0;
        for (int i=0; i<kotak.jumlah(); i++) {
            totalHarga += kotak.lihat(i).getHarga();
        }
        return totalHarga;
    }

    // Upper-bounded wildcard: mencari item termahal
    public static Barang termahal(Kotak<? extends Barang> kotak) {
        // TODO: implementasi
        // Kembalikan null jika kosong
        if (kotak.kosong()) return null;
        Barang maxBarang = kotak.lihat(0);
        for (int i=0; i<kotak.jumlah(); i++) {
            Barang currBarang = kotak.lihat(i);
            if (maxBarang.getHarga() < currBarang.getHarga()) {
                maxBarang = currBarang;
            }
        }
        return maxBarang;
    }

    // Bounded wildcard dengan type parameter (PECS: Producer Extends, Consumer Super)
    // src menggunakan ? extends T (producer/pembaca), item diambil dari src
    // dst menggunakan ? super T (consumer/penulis), item ditambahkan ke dst
    public static <T extends Barang> int pindahkan(Kotak<? extends T> src, Kotak<? super T> dst) {
        // TODO: implementasi
        // Pindahkan item dari src ke dst secara LIFO
        // Berhenti jika src kosong atau dst penuh
        // Kembalikan jumlah item yang dipindahkan
        int i = 0;
        while (!src.kosong() && !dst.penuh()) {
            dst.tambah(src.ambil());
            i++;
        }
        return i;
    }

    // Unbounded wildcard: hanya perlu menghitung jumlah
    public static int hitungItem(Kotak<?> kotak) {
        return kotak.jumlah();
    }
}
