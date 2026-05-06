public class Arsip {
    private Pesan[] messages;
    private int count;

    public Arsip() {
        messages = new Pesan[100];
        count = 0;
    }

    public void tambah(Pesan pesan) {
        if (count<100) {
            messages[count++] = pesan;
        }
    }

    public Pesan get(int idx) {
        return messages[idx-1];
    }

    public int cari(String keyword) {
        int found = 0;
        String keywordLower = keyword.toLowerCase();
        for (int i=0; i<count; i++) {
            if (messages[i].getPesan().toLowerCase().contains(keywordLower)) {
                found++;
            }
        }
        return found;
    }

    public int jumlah() {
        return count;
    }
}
