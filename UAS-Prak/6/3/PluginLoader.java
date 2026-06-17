public class PluginLoader {

    /**
     * Me-load kelas plugin secara dinamis berdasarkan nama kelas yang diberikan.
     * Kelas yang di-load harus merupakan implementasi dari interface Plugin.
     * Jika kelas tersebut tidak mengimplementasikan interface Plugin, method ini
     * harus melempar IllegalArgumentException dengan pesan:
     * "Kelas <className> tidak mengimplementasikan interface Plugin"
     * 
     * @param className Nama lengkap kelas yang akan di-load.
     * @return Instance dari kelas plugin yang berhasil di-load.
     * @throws Exception Jika terjadi error saat proses pemuatan kelas atau instansiasi.
     */
    public static Plugin loadPlugin(String className) throws Exception {
        // muat kelas based on className
        Class<?> clazz = Class.forName(className);

        // cek apakah kelas tersebut implementasi plugin
        if (!Plugin.class.isAssignFrom(clazz)) {
            throw new IllegalArgumentException (
                "Kelas " + className + " tidak mengimplementasikan interface Plugin"
            );
        }

        // buat instance pakai default ctor
        return (Plugin) clazz.getDeclaredConstructor().newInstance();
    }
}