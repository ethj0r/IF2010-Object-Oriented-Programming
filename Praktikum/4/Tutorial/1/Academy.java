import java.util.ArrayList;
import java.util.List;

public class Academy {
    private List<Scroll> scrolls;

    public Academy() {
        this.scrolls = new ArrayList<>();
    }

    public void addScroll(Scroll scroll) {
        this.scrolls.add(scroll);
    }

    public Scroll getScroll(int index) {
        return this.scrolls.get(index - 1);
    }

    public int search(String keyword) {
        String needle = keyword.toLowerCase();
        int count = 0;
        for (Scroll s : this.scrolls) {
            if (s.getContent().toLowerCase().contains(needle)) {
                count++;
            }
        }
        return count;
    }

    public int count() {
        return this.scrolls.size();
    }
}
