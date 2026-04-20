public class Character {
    private String name;
    private int level;
    private double powerBase;

    public Character(String name, int level, double powerBase) {
        this.name = name;
        this.level = level;
        this.powerBase = powerBase;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public double getPowerBase() {
        return this.powerBase;
    }

    public double calculatePower() {
        return this.powerBase;
    }

    public void printInfo() {
        System.out.println("Nama: " + this.name);
        System.out.println("Nama Kapital: " + this.name.toUpperCase());

        String initial = this.name.isEmpty() ? "" : String.valueOf(this.name.charAt(0));
        System.out.println("Inisial: " + initial);
        System.out.println("Panjang Nama: " + this.name.length());
        System.out.println("Level: " + this.level);
        System.out.println("Power Akhir: " + calculatePower());
    }
}
