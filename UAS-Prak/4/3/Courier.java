public class Courier {
    // Implementasi kelas Courier di sini
    private String name;
    private int speed;

    Courier() {
        this.name = "Unknown";
        this.speed = 10;
    }
    Courier(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String deliver(String item) {
        String out = "" + name + " delivers " + item;
        return out;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name + " with speed " + speed + " is ready to deliver";
    }
}