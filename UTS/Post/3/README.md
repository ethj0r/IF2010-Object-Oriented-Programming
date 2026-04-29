Nama File: SafeBox.zip

Para Nimon membutuhkan sistem penyimpanan data sementara yang fleksibel. Sistem ini harus mampu menyimpan berbagai tipe data, bilangan bulat, teks, maupun tipe lainnya, tanpa perlu membuat ulang kode untuk setiap tipe. Namun, setiap operasi yang salah harus ditangani dengan baik agar sistem tidak meledak!

Kamu diminta mengimplementasikan dua file header yang digunakan oleh main.cpp ( tidak boleh diubah):

SafeBoxException.hpp yang merupakan hierarki kelas exception untuk SafeBox
SafeBox.hpp yang merupakan template kelas SafeBox<T> dan template fungsi safeMerge
Spesifikasi

1. Hierarki SafeBoxException

Buat hierarki exception dengan SafeBoxException sebagai base class (turunan dari std::exception). Terdapat tiga turunan spesifik untuk kondisi error yang berbeda:

BoxFullException untuk operasi store ke box yang sudah penuh.
Menyimpan kapasitas maks (int).
what() → "Box penuh: kapasitas maks N"
BoxEmptyException untuk operasi retrieve, peek, dan reverse pada box yang kosong.
what() → "Box kosong"
InvalidItemException<T> untuk item yang tidak valid merupakan template class sehingga dapat menyimpan item bertipe apa saja.
Menyimpan item asli bertipe T.
what() → "Item tidak valid: <item>" (gunakan ostringstream untuk mengonversi T ke string)
2. Template Class SafeBox<T>

Kelas generik SafeBox<T> menyimpan elemen secara LIFO (Last In First Out) dengan kapasitas terbatas. Implementasikan method-method berikut:

SafeBox(int capacity, std::function<bool(const T&)> validator = nullptr): Konstruktor dengan kapasitas maksimum dan validator opsional. Jika diberikan, validator dipanggil di dalam store() untuk memeriksa keabsahan item sebelum menyimpannya.
void store(const T& item): Menyimpan item ke dalam box. Lempar InvalidItemException<T> jika validator ada dan item tidak lolos validasi. Lempar BoxFullException jika penuh
T retrieve(): Mengambil dan menghapus item teratas (LIFO). Lempar BoxEmptyException jika kosong
T peek() const: Melihat item teratas tanpa menghapusnya. Lempar BoxEmptyException jika kosong
void reverse(): Membalik urutan semua elemen dalam box. Lempar BoxEmptyException jika box kosong saat dipanggil
int size() const: Mengembalikan jumlah item saat ini
int capacity() const: Mengembalikan kapasitas maksimum
bool isEmpty() const: Mengembalikan true jika box kosong
operator<<: Overloading output stream untuk mencetak isi box dari bawah ke atas dalam format: [item_bawah, ..., item_atas]. Jika kosong, cetak [].
Implementasi dibebaskan selama memenuhi spesifikasi. Boleh menggunakan STL (misalnya std::stack) untuk penyimpanan internal.

3. Template Function safeMerge

Implementasikan fungsi global bertipe template:

int safeMerge(SafeBox<T>& src, SafeBox<T>& dst)
Fungsi ini memindahkan item dari src ke dst satu per satu (urutan LIFO), dengan ketentuan:

Hentikan pemindahan jika dst penuh, tangkap BoxFullException secara internal dan berhenti
Kembalikan jumlah item yang berhasil dipindahkan
Format Masukan

Baris pertama berisi tiga integer cap1 cap2 cap3: kapasitas box1 (int), box2 (int), dan sbox (string). Pada sbox, string yang memiliki panjang kurang dari 2 dianggap tidak valid dan akan ditolak oleh validator yang sudah dipasang pada konstruktornya. Baris kedua berisi integer Q. Selanjutnya Q baris perintah:

PUSH n v - store nilai v ke box ke-n (n=1: box1 int, n=2: box2 int, n=3: sbox string)
POP n - retrieve dari box ke-n
PEEK n - peek box ke-n
REVERSE n - reverse box ke-n
PRINT n - cetak isi box ke-n
SIZE n - cetak ukuran box ke-n
MERGE - panggil safeMerge(box1, box2)
Format Keluaran

Perintah	Kondisi	Keluaran
PUSH 1 / PUSH 2	berhasil	Tersimpan: v
PUSH 1 / PUSH 2	box penuh	BoxFullException::what()
PUSH 3	berhasil	Tersimpan: v
PUSH 3	panjang < 2 (ditolak validator)	InvalidItemException<string>::what()
PUSH 3	sbox penuh	BoxFullException::what()
POP n	berhasil	Diambil: v
POP n	box kosong	BoxEmptyException::what()
PEEK n	berhasil	nilai teratas
PEEK n	box kosong	BoxEmptyException::what()
REVERSE n	berhasil	Dibalik
REVERSE n	box kosong	BoxEmptyException::what()
PRINT n	—	[item_bawah, ..., item_atas] atau [] jika kosong
SIZE n	—	jumlah item (integer)
MERGE	—	Dipindahkan: N item
Contoh Masukan dan Keluaran

Masukan 1:

3 3 3 7 PUSH 1 1 PUSH 1 2 PUSH 1 3 PRINT 1 REVERSE 1 PRINT 1 POP 1
Keluaran 1:

Tersimpan: 1 Tersimpan: 2 Tersimpan: 3 [1, 2, 3] Dibalik [3, 2, 1] Diambil: 1
Masukan 2:

2 2 2 10 PUSH 3 A PUSH 3 Hi PUSH 3 OK PUSH 3 Yes PUSH 3 No PRINT 3 PEEK 3 REVERSE 3 PRINT 3 POP 3
Keluaran 2:

Item tidak valid: A Tersimpan: Hi Tersimpan: OK Box penuh: kapasitas maks 2 Box penuh: kapasitas maks 2 [Hi, OK] OK Dibalik [OK, Hi] Diambil: Hi

NOTE: JANGAN MASUKKAN FILE main.cpp KE DALAM ZIP