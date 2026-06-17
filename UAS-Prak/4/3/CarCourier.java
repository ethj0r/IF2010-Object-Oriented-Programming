public class CarCourier extends Courier {
    // Implementasi kelas CarCourier di sini
    CarCourier(String name, int speed) {
        super(name, speed);
    }

    @Override
    public String toString() {
        String out = "[Car] " + super.toString();
        return out;
    }
}