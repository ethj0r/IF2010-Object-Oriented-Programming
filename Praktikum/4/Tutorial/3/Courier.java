public class Courier {
    private String  name;
    private int speed;

    public Courier() {
        this.name = "Unknown";
        this.speed = 10;
    }

    public Courier(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String deliver(String item) {
        return String.format("%s delivers %s", this.name, item);
    }

    public int getSpeed() {
        return this.speed;
    }

    public String toString() {
        return String.format("%s with speed %d is ready to deliver", this.name, this.speed);
    }

}