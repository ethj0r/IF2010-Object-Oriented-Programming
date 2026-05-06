public class Elektronik extends Barang {
    private int watt;

    public Elektronik(String nama, int harga, int watt) {
        super(nama, harga);
        this.watt = watt;
    }

    public int getWatt() {
        return this.watt;
    }

    @Override
    public String info() {
        // Format: "[Elektronik] nama - harga IDR (wattW)"
        return "[Elektronik] " + nama + " - " + harga + " IDR (" + this.watt + "W)";
    }
}
