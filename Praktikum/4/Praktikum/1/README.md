Gro membangun papan pesan digital untuk komunitas di kotanya. Warga bisa mengirim tiga jenis pesan ke papan tersebut: pesan yang ditulis dalam huruf kapital semua (caps), pesan yang kata-katanya diulang berkali-kali (repeat), dan pesan yang merupakan kalimat lengkap mencakup seluruh huruf alfabet (pangram).

Sayangnya, sistem papan pesan Gro belum selesai dibuat. Tugasmu adalah membangun sistem tersebut agar warga kota bisa mengirim dan melihat pesan-pesan mereka!

File Main.java sudah disediakan dan tidak boleh diubah. Baca dan pahami bagaimana Main.java menggunakan kelas-kelas yang harus kalian buat. Tugasmu adalah mengimplementasikan kelas-kelas tersebut agar program dapat berjalan dengan benar.

File yang Disediakan (tidak boleh diubah):

Main.java
File yang Harus Dibuat:

Pesan.java
CapsMessage.java
RepeatMessage.java
PangramMessage.java
Arsip.java
Perilaku Pesan

Ada tiga jenis pesan di papan Gro. Setiap pesan menyimpan teks aslinya dan bisa diproses sesuai jenisnya. Pelajari Main.java untuk memahami bagaimana setiap pesan dan arsip digunakan.

Pesan Kapital (CAPS)

Ketika diproses, pesan kapital mengubah seluruh teks menjadi huruf kapital.

Contoh: "Hello World" → "HELLO WORLD"
Pesan ini juga bisa menghitung jumlah huruf vokal (a, e, i, o, u) dalam konten aslinya, tidak membedakan huruf besar/kecil.

Contoh: "Hello World" → 3 vokal (e, o, o)
Pesan Ulang (REPEAT)

Pesan ulang dibuat dengan teks dan sebuah angka pengulangan n. Ketika diproses, setiap kata dalam teks diulang sebanyak n kali, dipisahkan spasi, sebelum dilanjutkan ke kata berikutnya.

Contoh: "hello world" dengan n=3 → "hello hello hello world world world"
Pesan Pangram (PANGRAM)

Ketika diproses, pesan pangram membalik urutan kata-kata dalam teksnya (kata pertama menjadi terakhir, dan sebaliknya).

Contoh: "the quick brown fox" → "fox brown quick the"
Pesan ini juga bisa mengecek apakah teksnya merupakan pangram — kalimat yang mengandung setiap huruf alfabet (a-z) minimal satu kali, tidak membedakan huruf besar/kecil.

Contoh: "The quick brown fox jumps over the lazy dog" → pangram
Contoh: "hello world" → bukan pangram.
Arsip

Arsip menyimpan daftar pesan secara berurutan menggunakan array dengan kapasitas 100 pesan. Arsip mendukung penambahan pesan, pengambilan pesan berdasarkan nomor urut (dimulai dari 1), pencarian pesan berdasarkan kata kunci (tidak membedakan huruf besar/kecil), dan penghitungan total pesan.

Format Input


  N 
PERINTAH_1 
PERINTAH_2 
... 
PERINTAH_N
Format Output

Perintah	Kondisi	Output
ADD CAPS <konten>	—	(tidak ada output)
ADD REPEAT <n> <konten>	—	(tidak ada output)
ADD PANGRAM <konten>	—	(tidak ada output)
PROCESS <i>	—	Hasil pemrosesan pesan ke-i
INFO <i>	—	[TIPE] konten
VOKAL <i>	pesan bertipe CAPS	Vokal: N.
VOKAL <i>	pesan bukan tipe CAPS	Pesan bukan tipe CAPS.
ULANG <i>	pesan bertipe REPEAT	Pengulang: N.
ULANG <i>	pesan bukan tipe REPEAT	Pesan bukan tipe REPEAT.
CEK <i>	pesan bertipe PANGRAM dan merupakan pangram	Pangram!
CEK <i>	pesan bertipe PANGRAM dan bukan pangram	Bukan pangram.
CEK <i>	pesan bukan tipe PANGRAM	Pesan bukan tipe PANGRAM.
SEARCH <kata_kunci>	—	Ditemukan: N pesan mengandung "<kata_kunci>".
COUNT	—	Total: N pesan.

Contoh Input dan Output

INPUT
14
ADD CAPS Hello World
ADD REPEAT 3 hello world
ADD PANGRAM The quick brown fox jumps over the lazy dog
ADD PANGRAM bukan pangram ini
PROCESS 1
PROCESS 2
PROCESS 3
INFO 1
INFO 2
VOKAL 1
VOKAL 2
ULANG 2
CEK 3
CEK 4


OUTPUT
HELLO WORLD
hello hello hello world world world
dog lazy the over jumps fox brown quick The
[CAPS] Hello World
[REPEAT] hello world
Vokal: 3.
Pesan bukan tipe CAPS.
Pengulang: 3.
Pangram!
Bukan pangram.