import java.utils.List;

public class DapurJus {

    private DapurJus() {}

    static void cekBahan(List<? extends Buah> daftarBahan) {
        for (Buah bahan : daftarBahan) {
            System.out.println(bahan.deskripsi());
        }
    }

    static int hitungTotalManis(List<? extends Buah> daftarBahan) {
        int total = 0;
        for (Buah bahan : daftarBahan) {
            total += bahan.getTingkatManis();
        }
        return total;
    }

    static void buatJusApelDefault(List<? super JusApel> daftarMinuman) {
        daftarMinuman.add(new JusApel("Jus Apel Original"));
        daftarMinuman.add(new JusApel("Jus Apel Madu"));
    }

    static void cetakRakUmum(List<?> rak) {
        for (Object item : rak) {
            System.out.println(item);
        }
    }
}