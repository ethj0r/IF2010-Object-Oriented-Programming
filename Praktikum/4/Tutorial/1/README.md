Gro, penjahat jenius yang kini beralih menjadi agen rahasia, memimpin pasukan Nimons-nya yang setia: Kebin, Stewart, Pop, dan Toto dalam sebuah misi penting. Dibantu oleh Luiy, mereka harus mengelola arsip pesan-pesan rahasia organisasi. Setiap pesan disimpan dalam bentuk gulungan (scroll) dengan jenis yang berbeda-beda: ada yang berisi teks biasa yang perlu dirapikan, ada yang tersandi dengan Caesar cipher agar tidak terbaca musuh, dan ada yang merupakan kode verifikasi berbentuk palindrom.

Sayangnya, para Nimons terlalu sibuk memakan pisang sehingga sistem manajemen arsip belum selesai dibuat. Tugasmu adalah membangun sistem tersebut agar Gro dan Nimons-nya bisa menjalankan misi dengan lancar!

File Main.java sudah disediakan dan tidak boleh diubah. Baca dan pahami bagaimana Main.java menggunakan kelas-kelas yang harus kalian buat. Tugasmu adalah mengimplementasikan kelas-kelas tersebut agar program dapat berjalan dengan benar.

## File yang Disediakan (tidak boleh diubah):
Main.java

## File yang Harus Dibuat:

- Scroll.java
- PlainScroll.java
- CipherScroll.java
- PalindromeScroll.java
- Academy.java

## Perilaku Gulungan

Ada tiga jenis gulungan dalam arsip Gro. Setiap gulungan menyimpan teks aslinya dan bisa diproses sesuai jenisnya. Pelajari Main.java untuk memahami bagaimana setiap gulungan dan arsip digunakan.

### Gulungan Biasa (PLAIN)

Ketika diproses, gulungan biasa merapikan teksnya: spasi berlebih di awal, akhir, maupun tengah dihilangkan, dan setiap kata diawali huruf kapital.

- Contoh: "  hello   world  " → "Hello World"

### Gulungan Sandi (CIPHER)

Gulungan sandi dibuat dengan teks dan sebuah angka pergeseran. Ketika diproses, teks dienkode menggunakan Caesar cipher setiap huruf digeser sebanyak shift posisi dalam alfabet. Huruf non-alfabet tidak berubah, dan kapitalisasi dipertahankan. Gulungan ini juga bisa didekode (pergeseran dibalik).

- Pergeseran bisa bernilai negatif atau lebih dari 26.
- Formula pergeseran satu karakter: (char)(((c - base + shift % 26 + 26) % 26) + base)

### Gulungan Palindrom (PALINDROME)

Ketika diproses, gulungan palindrom membalik teksnya karakter per karakter. Gulungan ini juga bisa mengecek apakah teksnya merupakan palindrom dengan mengabaikan spasi dan perbedaan huruf besar/kecil.

Contoh proses: "hello" → "olleh"
Contoh cek palindrom: "A man a plan a canal Panama" → setelah menghapus spasi dan lowercase → palindrom
Arsip (Academy)

Arsip menyimpan daftar gulungan secara berurutan. Arsip mendukung penambahan gulungan, pengambilan gulungan berdasarkan nomor urut (dimulai dari 1), pencarian gulungan berdasarkan kata kunci (tidak membedakan huruf besar/kecil), dan penghitungan total gulungan.

#### Format Input

N 
PERINTAH_1 
PERINTAH_2 
... 
PERINTAH_N
N — jumlah perintah

#### Format Output

Perintah	Kondisi	Output
ADD PLAIN <konten>	—	(tidak ada output)
ADD CIPHER <shift> <kata>	—	(tidak ada output)
ADD PALINDROME <konten>	—	(tidak ada output)
PROCESS <i>	—	Hasil pemrosesan gulungan ke-i
DECODE <i>	gulungan bertipe CIPHER	Hasil dekode
DECODE <i>	gulungan bukan tipe CIPHER	Gulungan bukan tipe CIPHER.
INFO <i>	—	[TIPE] konten
CHECK <i>	gulungan bertipe PALINDROME dan palindrom	"<konten>" adalah palindrom.
CHECK <i>	gulungan bertipe PALINDROME dan bukan palindrom	"<konten>" bukan palindrom.
CHECK <i>	gulungan bukan tipe PALINDROME	Gulungan bukan tipe PALINDROME.
SEARCH <kata_kunci>	—	Ditemukan: N gulungan mengandung "<kata_kunci>".
COUNT	—	Total: N gulungan.
Contoh Masukan dan Keluaran

Contoh Input:

15
ADD PLAIN   secret   message
ADD CIPHER 5 Hello
ADD PALINDROME racecar
ADD PALINDROME A man a plan a canal Panama
PROCESS 1
PROCESS 2
PROCESS 3
PROCESS 4
INFO 1
INFO 2
DECODE 2
CHECK 3
CHECK 4
SEARCH racecar
COUNT

Contoh Output:
Secret Message
Mjqqt
racecar
amanap lanac a nalp a nam A
[PLAIN]    secret   message
[CIPHER] Hello
Czqqd
"racecar" adalah palindrom.
"A man a plan a canal Panama" adalah palindrom.
Ditemukan: 1 gulungan mengandung "racecar".
Total: 4 gulungan.