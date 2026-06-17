import java.util.ArrayList;

public class Laci<T> {
    private ArrayList<T> items;
    private String label;
    private int capacity;

    Laci(String label) {
        this.capacity = 10;
        this.items = new ArrayList<>(capacity);
        this.label = label;
    }

    public boolean simpan(T item) {
        if (items.size() == capacity) return false;
        items.add(item);
        return true;
    }

    public T ambil(int i) {
        if (i > items.size() || i < 1) return null;
        return items.get(i-1);
    }

    public void set(int i, T item) {
        if (i > items.size() || i < 1) return;
        items.set(i-1, item);
    }

    public int ukuran() {
        return this.items.size();
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        String out = "Laci[" + label + "]: [";
        for (int i=0; i<items.size(); i++) {
            if (i != 0) out += ", ";
            out += items.get(i).toString();
        }
        out += "]";
        return out;
    }
}