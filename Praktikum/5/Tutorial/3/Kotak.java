import java.util.ArrayList;

public class Kotak<T extends Barang> {
    private ArrayList<T> items;
    private int kapasitas;

    public Kotak(int kapasitas) {
        this.items = new ArrayList<>();
        this.kapasitas = kapasitas;
    }

    public boolean tambah(T item) {
        if (penuh()) return false;
        items.add(item);
        return true;
    }

    public T ambil() {
        if (kosong()) return null;
        return items.remove(items.size()-1);
        // or
        // T out = items.size()-1;
        // items.remove(items.size()-1);
        // return out;
    }

    public T lihat(int index) {
        if (index < 0 || index > kapasitas) {
            return null;
        }
        return items.get(index);
    }

    public int jumlah() {
        return items.size();
    }

    public int kapasitas() {
        return this.kapasitas;
    }

    public boolean penuh() {
        return items.size() == kapasitas;
    }

    public boolean kosong() {
        return items.size() == 0;
    }
}
