# Game Moba
Setelah Kebin dan Stewart puas bermain monopoli, mereka malah iseng mengembangkan prototype game moba terbaru. Game moba tersebut membutuhkan karakter sederhana untuk dua jenis role: Mage dan Fighter.

## Spesifikasi Kelas

### Character	
Atribut: name (String), level (int), powerBase (double).
Konstruktor: Character(String name, int level, double powerBase).
Method:
- String getName() mengembalikan atribut name.
- int getLevel() mengembalikan atribut level.
- double getPowerBase() mengembalikan atribut powerBase.
- double calculatePower() mengembalikan atribut powerBase.
- void printInfo() mencetak info sebagai berikut:
    - "Nama: name"
    - "Nama Kapital: NAME (yang telah dikapital)"
    - "Inisial: Huruf pertama dari name"
    - "Panjang Nama: Panjang dari name"
    - "Level: level"
    - "Power Akhir: Hasil penghitungan akhir power"

### Mage	
Turunan dari Character.
Atribut: magicalAtk (int).
Konstruktor: Mage(String name, int level, double powerBase, int magicalAtk).
Method:
- int getMagicalAtk() mengembalikan atribut magicalAtk.
- Override calculatePower() menjadi: powerBase + (magicalAtk * 0.5).
- Override void printInfo() dengan menambah info
    - "Jenis: Mage"

### Fighter	
Turunan dari Character.
Atribut: physicalAtk (int).
Konstruktor: Fighter(String name, int level, double powerBase, int physicalAtk).
Method:
- int getPhysicalAtk() mengembalikan atribut physicalAtk.
- Override calculatePower() menjadi: powerBase + (physicalAtk * 0.7).
- Override void printInfo() dengan menambah info
    - "Jenis: Fighter"


Untuk memudahkan pengujian class, berikut program Main yang dapat Anda coba dengan memasukkan contoh input dan ekspektasi output sebagai berikut:

### Contoh
#### Contoh Input
2
F
Timurs
5
50
40
X
Rex
3
40
M
Luna
4
32.5
50


#### Contoh Output
Unknown Character Role

=== Character List ===
Nama: Timurs
Nama Kapital: TIMURS
Inisial: T
Panjang Nama: 6
Level: 5
Power Akhir: 78.0
Jenis: Fighter

Nama: Luna
Nama Kapital: LUNA
Inisial: L
Panjang Nama: 4
Level: 4
Power Akhir: 57.5
Jenis: Mage


#### Format Pengumpulan
Kumpulkan file: Character.java, Mage.java, Fighter.java.
Pastikan program dapat dikompilasi dengan javac *.java dan dijalankan dengan java Main.