## Deskripsi Soal
Anda adalah seorang Backend Developer di sebuah platform livestreaming. Anda diminta untuk melengkapi sistem moderasi otomatis (CommentsManager) yang bertugas menyaring pesan, mendeteksi spam, mencari pemenang kuis, dan memprioritaskan chat dari penonton VIP. Sistem ini bergantung pada kelas Comment yang merepresentasikan setiap pesan yang masuk.

## Tugas Anda
Anda diwajibkan untuk menggunakan STL C++ dan memanfaatkan Lambda Expressions. Penggunaan for/while loop sangat dilarang dan tidak akan dinilai!

Berdasarkan CommentsManager.hpp, buatlah implementasi untuk 4 fungsi berikut:

void CommentsManager::kickSpammer(int threshold_score)
void CommentsManager::printViolation()
std::string CommentsManager::quizWinner(const std::set<std::string>& passwords)
void CommentsManager::upVIPComment()
Silakan buka dokumentasi cppreference atau handbook (lebih ringkas) berikut untuk keperluan STL. Pastikan anda menggunakan referensi sesuai dengan C++14 ke bawah agar bisa dijalankan olympia.

Berikut adalah file main.cpp dan outputnya

## Berkas Pengumpulan
Anda hanya perlu mengumpulkan file CommentsManager.cpp

### Ouput from main.cpp:

--- Chat Masuk ---
[Normal] budi_baik: s3m4ng4t ya ganteng mwah
[Normal] toxic_boy1: woy anjing bangsat
[Normal] spam_bot1: klik link ini
[VIP] sultan_99: s3mAng4t bang streamingnya
[Normal] toxic_boy: mainnya bodoh banget

--- Setelah Spammer Ditendang (Batas Skor > 100) ---
[Normal] budi_baik: s3m4ng4t ya ganteng mwah
[Normal] toxic_boy1: woy anjing bangsat
[VIP] sultan_99: s3mAng4t bang streamingnya
[Normal] toxic_boy: mainnya bodoh banget

--- Deteksi Kata Kasar ---
kata "anjing" oleh akun "toxic_boy1"
kata "bangsat" oleh akun "toxic_boy1"
kata "bodoh" oleh akun "toxic_boy"

--- Pengumuman Kuis ---
Pemenang: budi_baik

--- Mode Slowchat: VIP Naik Ke Atas ---
[VIP] sultan_99: s3mAng4t bang streamingnya
[Normal] budi_baik: s3m4ng4t ya ganteng mwah
[Normal] toxic_boy1: woy anjing bangsat
[Normal] toxic_boy: mainnya bodoh banget

--- Pengumuman Kuis ---
Pemenang: sultan_99