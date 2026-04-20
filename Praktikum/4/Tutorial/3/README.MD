# Quick Delivery
Anda sedang mengembangkan modul logistik untuk startup pengiriman cepat. Sistem membutuhkan model objek sederhana untuk dua jenis kurir: sepeda dan mobil.

## Spesifikasi Kelas

### Nama Kelas	Spesifikasi

#### Courier	
Atribut: name (String), speed (int).
Konstruktor: Courier() dan Courier(String name, int speed).
Nilai default: name = "Unknown", speed = 10.
Method:
String deliver(String item) mengembalikan: name + " delivers " + item.
int getSpeed() mengembalikan speed.
toString() mengembalikan: name + " with speed " + speed + " is ready to deliver".

#### BikeCourier	
Turunan dari Courier.
Konstruktor: BikeCourier(String name, int speed).
Override toString() menjadi: "[Bike] " + super.toString().
CarCourier	
Turunan dari Courier.
Konstruktor: CarCourier(String name, int speed).
Override toString() menjadi: "[Car] " + super.toString().
Program Utama
Buatlah program utama dengan flow program sebagai berikut:

### Main
Baca bilangan bulat N (jumlah data courier).
Baca N baris, masing-masing berformat: type name speed item.
type bernilai:
B untuk BikeCourier
C untuk CarCourier
Simpan objek ke array Courier[] dan item ke array String[].
Untuk setiap courier sesuai urutan input, cetak:
System.out.println(courier[i])
System.out.println(courier[i].deliver(item[i]))
Penamaan variabel untuk array bebas (tidak harus courier dan item), yang penting output sesuai.
Di akhir, cetak:
Average speed: x, dengan x = rata-rata speed (2 angka desimal).
Fast? y, dengan y = true jika ada minimal satu speed > 40, selain itu false.
Jika N = 0, rata-rata dianggap 0.00 dan output hanya dua baris ringkasan akhir.
Program membaca input dari stdin dan mencetak output persis sesuai format. Jangan mencetak prompt seperti Masukkan N:.
Format Input
N
type_1 name_1 speed_1 item_1
type_2 name_2 speed_2 item_2
...
type_N name_N speed_N item_N
    
Format Output
(2 baris per courier, berulang sesuai N)
Average speed: <rata-rata dua desimal>
Fast? <true/false>
    
Contoh
Contoh Input	Contoh Output
3
B Rina 20 dokumen
C Bimo 50 laptop
B Tono 30 paket
[Bike] Rina with speed 20 is ready to deliver
Rina delivers dokumen
[Car] Bimo with speed 50 is ready to deliver
Bimo delivers laptop
[Bike] Tono with speed 30 is ready to deliver
Tono delivers paket
Average speed: 33.33
Fast? true