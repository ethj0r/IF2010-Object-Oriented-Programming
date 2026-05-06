public abstract class Pesan {
    protected String pesan;

    public Pesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public abstract String process();

    @Override
    public String toString() {
        String type = this.getClass().getSimpleName();
        if (type.equals("CapsMessage")) {
            type = "CAPS";
        } else if (type.equals("RepeatMessage")) {
            type = "REPEAT";
        } else if (type.equals("PangramMessage")) {
            type = "PANGRAM";
        }
        return "[" + type + "] " + pesan;
    }
}
