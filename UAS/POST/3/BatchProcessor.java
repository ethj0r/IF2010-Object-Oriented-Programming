import java.util.List;
import java.util.Locale;

// Kelas yang mengimplementasikan Runnable dan memproses sebagian dari daftar batch secara paralel.
public class BatchProcessor implements Runnable {
    private final List<DataBatch<? extends Number>> batches;
    private final int threadIndex;
    private final String[] logs;
    private final int[] totalItems;
    private final Object lock;

    public BatchProcessor(List<DataBatch<? extends Number>> batches, int threadIndex,
                          String[] logs, int[] totalItems, Object lock) {
        this.batches = batches;
        this.threadIndex = threadIndex;
        this.logs = logs;
        this.totalItems = totalItems;
        this.lock = lock;
    }

    @Override
    public void run() {
        ThreadTracker.mark();

        StringBuilder sb = new StringBuilder();
        sb.append("Thread ").append(threadIndex).append(":");

        int count = 0;
        for (DataBatch<? extends Number> batch : batches) {
            sb.append(String.format(Locale.US, "%nBatch %s: sum = %.1f", batch.getLabel(), batch.sum()));
            count += batch.getItems().size();
        }

        logs[threadIndex] = sb.toString();

        synchronized (lock) {
            totalItems[0] += count;
        }
    }
}
