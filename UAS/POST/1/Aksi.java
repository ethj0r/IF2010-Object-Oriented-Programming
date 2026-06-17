import java.util.Optional;

public interface Aksi {
    public void atas(Optional<Integer> steps);
    public void bawah(Optional<Integer> steps);
    public void kanan(Optional<Integer> steps);
    public void kiri(Optional<Integer> steps);
    public void bawahKanan(Optional<Integer> steps);
    public void bawahKiri(Optional<Integer> steps);
    public void atasKanan(Optional<Integer> steps);
    public void atasKiri(Optional<Integer> steps);
}