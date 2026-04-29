# CipherCloud
Anda adalah seorang Software Architect di CipherCloud, sebuah perusahaan infrastruktur cloud global. Sistem lama sering mengalami kebocoran data dan salah memberikan akses kepada publik karena hierarki dokumen yang berantakan.

CEO akhirnya menugaskan Anda untuk merombak total dua komponen paling krusial: CloudNode dan Hierarki Record. Arsitektur harus dibuat seketat mungkin agar developer lain tidak dapat secara sembarangan menyalahgunakan fungsi sistem.

Link Codebase. Anda dilarang memodifikasi file header BaseRecord.hpp, main.cpp, dan Formatter.hpp yang telah disediakan.

## Bagian 1: Manajemen CloudNode
Anda diminta untuk melengkapi deklarasi dan implementasi kelas CloudNode, dengan mematuhi spesifikasi berikut:

Komponen	
Atribut	
server_name (string): Nama dari node cloud.
used_gb (int): Jumlah GB yang sudah digunakan.
limit_gb (int): Batas maksimal GB yang dapat digunakan.
Constructor	Menerima parameter nama server dan limit GB, kemudian inisialisasi used_gb ke 0. Print pesan constructor dari Formatter.
Copy Constructor	Membuat backup dari CloudNode (other). Nama server diikuti "_backup" (append server_name other), limit_gb bernilai sama dari sumber asal, dan used_gb diinisialisasi ke 0. Print pesan copy constructor dari Formatter.
Copy Assignment Operator	Menyalin used_gb dari CloudNode lain ditambah 2, tetapi menyalinnya tidak boleh melebihi limit_gb target. Nilai limit_gb target dan tipe nama server tidak berubah. Print pesan assignment operator dari Formatter sebelum ekspresi return.
Destructor	Print pesan destructor dari Formatter.
Operator + (Int)	Menerima sebuah angka (int). Menambah limit_gb sebanyak n GB, dan mengembalikan CloudNode baru dengan perubahan tersebut.
Operator - (Int)	Menerima sebuah angka (int). Mengurangi used_gb sebanyak n GB, tidak boleh kurang dari 0 (set ke 0 jika hasilnya negatif). Mengembalikan CloudNode baru dengan perubahan tersebut.
Friend Function	friend void systemWipe(CloudNode &node): Menerima referensi ke CloudNode. Mengatur used_gb dan limit_gb node target seketika menjadi 0 tanpa mengubah namanya.

## Bagian 2: Record Hierarchy
Telah disediakan kelas dasar BaseRecord. Rancang dan implementasikan (buat file .hpp dan .cpp) kelas-kelas turunan berikut. Konstruktor dari setiap kelas turunan wajib meneruskan parameter author dan key ke konstruktor BaseRecord. Pahami deskripsi arsitektur berikut untuk menentukan Access Modifier Inheritance yang tepat. Spesifikasi:

Nama Kelas	Spesifikasi Pewarisan & Sifat Arsitektur	Daftar Implementasi Metode
PublicRecord	Semua fungsionalitas dan kode eksternal yang menerima BaseRecord wajib dapat menerima objek PublicRecord sebagai penggantinya (Dikenali secara eksplisit oleh dunia luar sebagai BaseRecord).	
Constructor: Meneruskan parameter secara standar.
calculateClearance(): Lakukan override pada fungsi ini sehingga selalu mereturn nilai konstanta 0.
InternalRecord	Identitas kelas ini tidak boleh diekspos sebagai BaseRecord ke sistem luar/publik. Akan tetapi, struktur harus extensible, developer di masa depan harus tetap bisa membuat subclass dari kelas ini, dan subclass tersebut harus tetap bisa mewarisi & mengakses fungsionalitas dari BaseRecord.	
Constructor: Meneruskan parameter secara standar.
peekSecurity(): Fungsi baru (publik) spesifik kelas ini yang mengembalikan nilai calculateClearance() milik turunan, lalu dikalikan 2.
SecureVaultRecord	Identitas kelas ini tidak boleh diekspos sebagai BaseRecord ke sistem luar/publik. Akan tetapi, struktur tidak extensible. Jika developer di masa depan membuat subclass dari kelas ini, subclass tersebut tidak bisa mewarisi & mengakses fungsionalitas dari BaseRecord.	
Constructor: Meneruskan parameter secara standar.
Tidak diperlukan fungsi/metode khusus tambahan.


### Contoh Keluaran main.cpp:

 CLOUD NODE BEHAVIOUR
 [CTOR] Node NodeA diinisialisasi. NodeA - used GB: 0, limit GB: 10
 [CCTOR] Backup NodeA_backup dibuat. NodeA_backup - used GB: 0, limit GB: 15
 [CTOR] Node NodeC diinisialisasi. 
 [ASSIGN] Node NodeC disinkronisasi. 
 [CCTOR] Backup NodeC_backup dibuat. NodeC - used GB: 2, limit GB: 50 NodeC - used GB: 0, limit GB: 0
 [DTOR] Node NodeC_backup dinonaktifkan. 
 [DTOR] Node NodeC dinonaktifkan. 
 [DTOR] Node NodeA_backup dinonaktifkan.
 [DTOR] Node NodeA dinonaktifkan. 
 RECORD HIERARCHY BEHAVIOUR 
 [PASS] PublicRecord mengembalikan clearance 0.
 [PASS] InternalRecord mengembalikan sekuritas operasional yang tepat (10).
 [PASS] SecureVaultRecord berhasil dibentuk dan dikompilasi!

Note: Jika Anda mendapatkan Runtime Error saat proses grading di olympia, perhatikan kembali penerapan prinsip enkapsulasi dan pemilihan Access Modifier Inheritance