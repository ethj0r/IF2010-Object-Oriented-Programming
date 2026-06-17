public class LaciUtil {

    public static <T> void tukar(Laci<T> laci, int i, int j) {
        T item_i = laci.ambil(i);
        T item_j = laci.ambil(j);
        if (item_i == null || item_j == null) return;
        laci.set(i, item_j);
        laci.set(j, item_i);
    }

    public static <T extends Comparable<T>> T terbesar(Laci<T> laci) {
        if (laci.ukuran() == 0) return null;
        T best = laci.ambil(1);
        for (int i=2; i<=laci.ukuran(); i++) {
            T current = laci.ambil(i);
            if (current.compareTo(best) > 0) best = current;
        }
        return best;
    }
}