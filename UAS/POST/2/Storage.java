import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Storage<T> {
    private Map<String, T> data;
    private int capacity;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public void store(String id, T item) throws StorageFullException, DuplicateIdException {
        // TODO:
        // Tambahkan item ke dalam data dengan id sebagai key.
        // Jika kapasitas sudah penuh, lemparkan StorageFullException.
        // Jika kapasitas belum penuh namun id sudah ada di dalam data, lemparkan DuplicateIdException.
        if (data.size() == capacity) {
            throw new StorageFullException();
        }
        if (data.containsKey(id)) {
            throw new DuplicateIdException(id);
        }
        data.put(id, item);
    }

    public T retrieve(String id) throws DataNotFoundException {
        // TODO:
        // Kembalikan item yang sesuai dengan id.
        // Jika id tidak ditemukan, lemparkan DataNotFoundException.
        if (!data.containsKey(id)) {
            throw new DataNotFoundException(id);
        }
        return data.get(id);
    }
    
    public void remove(String id) throws DataNotFoundException {
        // TODO:
        // Hapus item dengan id dari dalam data.
        // Jika id tidak ditemukan, lemparkan DataNotFoundException.
        if (!data.containsKey(id)) {
            throw new DataNotFoundException(id);
        }
        data.remove(id);
    }

    public List<T> getAll() {
        // TODO:
        // Kembalikan semua item di dalam data dalam bentuk List.
        List<T> list = new ArrayList<>();
        for (T item : data.values()) {
            list.add(item);
        }
        return list;
    }
    
    public int getCapacity() {
        return this.capacity;
    }
    
    public int getSize() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }
}