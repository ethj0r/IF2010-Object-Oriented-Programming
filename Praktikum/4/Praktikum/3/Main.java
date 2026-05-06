// import tc.TrackerPengeluaran;

public class Main {
    public static void main(String[] args) {
        // TrackerPengeluaran catatanKebin = new TrackerPengeluaran();
        Umandana umandana = new Umandana();
        String kata = "aku sayang kamu";
        String kataUmandana = umandana.toUmandana(kata);
        System.out.println("Kata asli: " + kata);
        System.out.println("Kata dalam bahasa Umandana: " + kataUmandana);
        String kataNormal = umandana.deUmandana(kataUmandana);
        System.out.println("Kata setelah deUmandana: " + kataNormal);
    }
}