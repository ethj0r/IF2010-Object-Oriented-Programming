Gro sedang membangun sistem penyimpanan data untuk gudang risetnya. Gudangnya memiliki tiga laci khusus: satu untuk bilangan bulat (integer), satu untuk bilangan desimal (double), dan satu untuk kata-kata (string).

Yang membuatnya menarik: semua laci ini berbagi struktur yang sama, hanya tipe datanya yang berbeda. Dinda ingin menggunakan Java Generics agar kode tidak perlu ditulis ulang untuk setiap tipe.

File Main.java sudah disediakan dan tidak boleh diubah. Tugasmu adalah mengimplementasikan kelas-kelas generik yang digunakan oleh Main.java.

File yang Disediakan (tidak boleh diubah):

Main.java
File yang Harus Dibuat:

Laci.java
LaciAngka.java
LaciUtil.java
Spesifikasi Kelas

1. Kelas Generik Laci<T>

Kelas generik yang menyimpan item bertipe T dalam array dengan kapasitas tetap 10. Implementasikan method-method berikut:

Laci(String label) — konstruktor, simpan label laci
boolean simpan(T item) — tambah item ke laci. Kembalikan true jika berhasil, false jika laci sudah penuh
T ambil(int i) — kembalikan item pada indeks ke-i (dimulai dari 1). Kembalikan null jika indeks tidak valid
void set(int i, T item) — ganti item pada indeks ke-i (dimulai dari 1). Abaikan jika indeks tidak valid
int ukuran() — kembalikan jumlah item saat ini
String getLabel() — kembalikan label laci
String toString() — format: Laci[label]: [item1, item2, ...]
2. Kelas Generik LaciAngka<T extends Number>

Kelas turunan dari Laci<T> yang khusus untuk tipe angka (Integer, Double, dsb.). Gunakan bounded type parameter T extends Number agar bisa mengakses method doubleValue(). Implementasikan:

LaciAngka(String label) — konstruktor
double total() — jumlahkan semua item, kembalikan sebagai double
double rataRata() — kembalikan rata-rata semua item sebagai double. Kembalikan 0.0 jika laci kosong
3. Kelas Utilitas LaciUtil

Kelas dengan method static generik. Perhatikan tipe parameter pada setiap method:

static <T> void tukar(Laci<T> laci, int i, int j) — tukar posisi item pada indeks ke-i dan ke-j (1-based).
Tidak perlu tahu tipe spesifik T, cukup pakai tipe parameter generik.
static <T extends Comparable<T>> T terbesar(Laci<T> laci) kembalikan item terbesar dalam laci. Kembalikan null jika laci kosong.
Bounded type parameter memastikan item bisa dibandingkan satu sama lain.
Format Output

Perintah	Kondisi	Output
SIMPAN INT <val>	—	Disimpan: val
SIMPAN DBL <val>	—	Disimpan: val
SIMPAN STR <val>	—	Disimpan: val
AMBIL INT/DBL/STR <i>	indeks valid	nilai item ke-i
AMBIL INT/DBL/STR <i>	indeks tidak valid	null
TOTAL INT/DBL	—	Total: X.X
RATA INT/DBL	—	Rata-rata: X.X
TUKAR INT/STR <i> <j>	—	(tidak ada output)
TERBESAR INT/STR	laci tidak kosong	nilai item terbesar
TERBESAR INT/STR	laci kosong	Laci kosong
INFO INT/DBL/STR	—	Laci[label]: [item1, item2, ...]

Contoh Masukan
26
TERBESAR INT
SIMPAN INT 42
SIMPAN INT 17
SIMPAN INT 88
SIMPAN DBL 3.5
SIMPAN DBL 1.5
SIMPAN STR durian
SIMPAN STR apel
SIMPAN STR mangga
INFO INT
INFO DBL
INFO STR
AMBIL INT 2
AMBIL DBL 1
AMBIL STR 3
AMBIL INT 99
TOTAL INT
TOTAL DBL
RATA INT
RATA DBL
TERBESAR INT
TERBESAR STR
TUKAR INT 1 3
TUKAR STR 1 2
INFO INT
INFO STR

Contoh Keluaran
Laci kosong
Disimpan: 42
Disimpan: 17
Disimpan: 88
Disimpan: 3.5
Disimpan: 1.5
Disimpan: durian
Disimpan: apel
Disimpan: mangga
Laci[Integer]: [42, 17, 88]
Laci[Double]: [3.5, 1.5]
Laci[String]: [durian, apel, mangga]
17
3.5
mangga
null
Total: 147.0
Total: 5.0
Rata-rata: 49.0
Rata-rata: 2.5
88
mangga
Laci[Integer]: [88, 17, 42]
Laci[String]: [apel, durian, mangga]