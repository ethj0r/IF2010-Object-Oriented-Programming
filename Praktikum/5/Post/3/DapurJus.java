import java.util.List;

public class DapurJus {

    private DapurJus() {}

    static void cekBahan(List<? extends Buah> daftarBahan) {
        for (Buah b : daftarBahan) {
            System.out.println(b.deskripsi());
        }
    }

    static int hitungTotalManis(List<? extends Buah> daftarBahan) {
        int total = 0;
        for (Buah b : daftarBahan) {
            total += b.getTingkatManis();
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
