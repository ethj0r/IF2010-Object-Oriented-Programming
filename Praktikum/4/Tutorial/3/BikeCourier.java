public class BikeCourier extends Courier {
    // Implementasi kelas BikeCourier di sini
    public BikeCourier(String name, int speed) {
        super(name, speed);
    }

    @Override
    public String toString() {
        return String.format("[Bike] %s", super.toString());
    }
}