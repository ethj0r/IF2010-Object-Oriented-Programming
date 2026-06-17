public class BikeCourier extends Courier {
    BikeCourier(String name, int speed) {
        super(name, speed);
    }
    @Override
    public String toString() {
        String out = "[Bike] " + super.toString();
        return out;
    }
}