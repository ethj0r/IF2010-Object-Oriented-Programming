public class LaciUtil {

    public static <T> void tukar(Laci<T> laci, int i, int j) {
        T a = laci.ambil(i);
        T b = laci.ambil(j);
        if (a == null || b == null) return;
        laci.set(i, b);
        laci.set(j, a);
    }

    public static <T extends Comparable<T>> T terbesar(Laci<T> laci) {
        if (laci.ukuran() == 0) return null;
        T best = laci.ambil(1);
        for (int k = 2; k <= laci.ukuran(); k++) {
            T cur = laci.ambil(k);
            if (cur.compareTo(best) > 0) best = cur;
        }
        return best;
    }
}
