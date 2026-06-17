Latar Belakang

Dalam pengembangan perangkat lunak yang modular, seringkali kita ingin menambahkan fitur baru tanpa harus mengubah kode utama. Hal ini biasanya dilakukan dengan sistem Plugin. Program utama akan mencari dan memuat kelas-kelas plugin secara dinamis saat dijalankan.

Pada tugas ini, Anda diminta untuk mengimplementasikan sebuah PluginLoader sederhana menggunakan Java Reflection.

File yang Disediakan

File	Deskripsi
Plugin.java	Interface yang harus diimplementasikan oleh setiap plugin. Memiliki method void start().
PluginLoader.java	Kelas yang akan Anda lengkapi. Berisi method loadPlugin.
Main.java	Driver.


Tugas Anda

Lengkapi method berikut di dalam PluginLoader.java:

public static Plugin loadPlugin(String className) throws Exception
Spesifikasi:

Muat kelas berdasarkan className menggunakan Reflection.
Pastikan kelas tersebut merupakan implementasi dari interface Plugin.
Jika validasi pada poin 2 gagal, lempar IllegalArgumentException dengan pesan:
"Kelas <className> tidak mengimplementasikan interface Plugin"
Buat dan kembalikan instance dari kelas tersebut menggunakan default constructor.
Referensi Dokumentasi
Dokumentasi Kelas: java.lang.Class
Dokumentasi Kelas: java.lang.reflect.Constructor
Oracle Java Tutorial: The Reflection API
Format Pengumpulan

Kumpulkan file PluginLoader.java

Contoh Input & Output

Misalkan terdapat kelas ValidPlugin yang mengimplementasikan Plugin dan InvalidPlugin yang tidak.

Input (className)	Output / Exception
ValidPlugin	(Plugin berhasil dijalankan)
InvalidPlugin	java.lang.IllegalArgumentException: Kelas InvalidPlugin tidak mengimplementasikan interface Plugin
NonExistent	java.lang.ClassNotFoundException: NonExistent