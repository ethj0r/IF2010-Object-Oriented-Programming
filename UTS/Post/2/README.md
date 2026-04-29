# Football Manager

## Deskripsi Soal
Sebuah klub sepak bola profesional membutuhkan sistem manajemen anggota yang mampu merepresentasikan berbagai peran di dalam klub: pemain lapangan, penjaga gawang, pelatih kepala, fisioterapis, dan pemain-pelatih.

Kamu diminta untuk mengimplementasikan kelas ClubMember, Player, Staff, serta PlayerCoach dari hierarki kelas berikut. Selain itu, kamu juga perlu mengimplementasikan method di kelas Club.

Link Codebase

Petunjuk: Gunakan kelas Formatter untuk formatting output.

## Hierarki Kelas
              ClubMember
             /          \
         Player          Staff
           |   \        /   |
    Goalkeeper  PlayerCoach  HeadCoach
  OutfieldPlayer             Physio

## Spesifikasi Kelas
### ClubMember
Atribut protected:

string name
int age
string contractEnd
Method public:

Konstruktor: ClubMember(name, age, contractEnd)
Pure virtual: string getProfile()
Pure virtual: double calculateWage()
Pure virtual: void work()
Destruktor - mencetak: [~ClubMember] <name> contract record cleared.

### Player
Atribut protected tambahan:

string position
int stamina
double rating
Method public:

Konstruktor: Player(name, age, contractEnd, position, stamina, rating)
Method: double calculateWage()  dengan rumus rating * 10000.0
Pure virtual: double calculateRating()
Destuktor - mencetak: [~Player] <name> training log freed.

### Staff
Atribut protected tambahan:

string coachingLicense
string department
Method public:

Konstruktor: Staff(name, age, contractEnd, license, dept)
Method: double calculateWage()  dengan fixed return 50000.0
Pure virtual: string getSpecialty()
Destruktor - mencetak: [~Staff] <name> session record freed.

### PlayerCoach
Atribut private tambahan: int yearsAsPlayer, bool isCurrentlyPlaying

Konstruktor: PlayerCoach(name, age, contractEnd, position, stamina, rating, license, yearsAsPlayer, isCurrentlyPlaying) - department "Coaching"
void work() jika isCurrentlyPlaying: [PlayerCoach] <name> plays AND coaches from the pitch.; jika tidak: [PlayerCoach] <name> coaches from the touchline.
double calculateRating() dengan rumus rating * 0.7 + (yearsAsPlayer / 20.0) * 3.0
std::string getSpecialty() dengan output "Playing + Coaching (Player-Coach, <years> yrs exp)"
double calculateWage() → Penjulamahan dari calculateWage Player dan Staff (HARUS MEMANGGIL FUNGSI, TIDAK BOLEH DIHARDCODE!)
std::string getProfile() → format: PlayerCoach | <name> | Pos: <pos> | Lic: <license> | Specialty: <specialty> | Wage: $<W>/wk
Destruktor → [~PlayerCoach] <name> dual-role contract terminated.

### Club
Atribut private: std::string clubName, std::vector<ClubMember*> roster

Konstruktor: Club(name)
void addMember(ClubMember* member) - menambahkan anggota ke roster
void printSquadReport() const - mencetak header dan profil semua anggota
void runTraining() const - mencetak header dan memanggil work() semua anggota
Destruktor - mencetak header dan delete semua pointer
Kelas Pembantu — Formatter
Method	Deskripsi
Formatter::wage(double)	Menghasilkan string $<nilai>/wk (nilai dibulatkan ke integer)
Formatter::fixed(double, int)	Menghasilkan string angka dengan jumlah desimal tertentu
Formatter::makeRow(label, name, fields)	Membangun baris profil dengan label di-pad ke 15 karakter
Formatter::log(label, name, message)	Mencetak [label] name message ke stdout
Berkas Pengumpulan
Kumpulkan berkas-berkas dibawah ini dalam 1 zip!

Berkas
ClubMember.hpp / .cpp
Player.hpp / .cpp
Staff.hpp / .cpp
PlayerCoach.hpp / .cpp
Club.hpp / .cpp
