public class TemperatureDisplay implements WeatherObserver {
    // Deklarasikan field private String name.
    private String name;

    public TemperatureDisplay(String name) {
        // Simpan nama yang diberikan ke field name.
        this.name = name;
    }

    @Override
    public void update(double temperature, double humidity) {
        // Cetak baris berikut ke System.out:
        // "Display <name>: Suhu <temperature>"
        //
        // Format temperature menggunakan satu angka desimal (%.1f).
        // Contoh: "Display TempA: Suhu 25.0"
        System.out.printf("Display %s: Suhu %.1f%n", name, temperature);
    }

    @Override
    public String getName() {
        return name;
    }
}
