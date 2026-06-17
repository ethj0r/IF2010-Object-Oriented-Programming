import java.util.Optional;
public class Knight extends Bidak implements Aksi {
    public Knight(int x, int y, int id) { 
        super(x, y, 'K', id);
        actions.add("2. Atas Kanan");
        actions.add("4. Atas Kiri");
        actions.add("6. Bawah Kanan");
        actions.add("8. Bawah Kiri");
     }
    public Knight(Knight b) { }

    @Override
    public void atasKanan(Optional<Integer> steps) {
        this.x += 1; this.y -= 2;
    }

    @Override
    public void atasKiri(Optional<Integer> steps) {
        this.x -= 1; this.y -= 2;
    }

    @Override
    public void bawahKanan(Optional<Integer> steps) {
        this.x += 1; this.y += 2;
    }

    @Override
    public void bawahKiri(Optional<Integer> steps) {
        this.x -= 1; this.y += 2;
    }
    // atasKanan
    // this.x += 1; this.y -= 2;

    // atasKiri
    // this.x -= 1; this.y -= 2;

    // bawahKanan
    // this.x += 1; this.y += 2;

    // bawahKiri
    // this.x -= 1; this.y += 2;
    @Override
    public void atas(Optional<Integer> steps) {
        System.out.println("[X] Gerakan tidak valid untuk bidak ini!");
    }
    @Override
    public void bawah(Optional<Integer> steps) {
        System.out.println("[X] Gerakan tidak valid untuk bidak ini!");
    }
    @Override
    public void kiri(Optional<Integer> steps) {
        System.out.println("[X] Gerakan tidak valid untuk bidak ini!");
    }
    @Override
    public void kanan(Optional<Integer> steps) {
        System.out.println("[X] Gerakan tidak valid untuk bidak ini!");
    }
}