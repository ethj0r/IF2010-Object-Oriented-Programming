import java.util.ArrayList;

public class Laci<T> {
    private ArrayList<T> items;
    private String label;
    private int capacity;

    public Laci(String label) {
        this.capacity = 10;
        this.items = new ArrayList<>(10);
        this.label = label;
    }

    public boolean simpan(T item) {
        if (this.items.size() == capacity) return false;
        this.items.add(item);
        return true;
    }

    public T ambil(int i) {
        if (i < 1 || i > this.items.size()) return null;
        return this.items.get(i - 1);
    }

    public void set(int i, T item) {
        if (i < 1 || i > this.items.size()) return;
        this.items.set(i - 1, item);
    }

    public int ukuran() {
        return this.items.size();
    }

    public String getLabel() {
        return this.label;
    }

    public String toString() {
        String out = "Laci[" + this.label + "]: [";
        for (int i = 0; i < this.items.size(); i++) {
            if (i != 0) out += ", ";
            out += this.items.get(i).toString();
        }
        out += "]";
        return out;
    }
}
