#include <stdio.h>
#include <string>
using namespace std;

class Mahasiswa {
    public:
        static int counter;

    private:
        string name;
        string nim;
        double ipk;
        int total_sks;

    public:
        Mahasiswa() {
            name = "NPC";
            nim = "135" + to_string(counter++);
            ipk = 0;
            total_sks = 0;
        }

        Mahasiswa(string name) {
            this->name = name;
            nim = "135" + to_string(counter++);
            ipk = 0;
            total_sks = 0;
        }

        void tambahNilai(double nilai, int sks) {
            ipk = (ipk * total_sks + nilai * sks) / (total_sks + sks);
            total_sks += sks;
        }

        void info() {
            printf("INFORMASI MAHASISWA\n");
            printf("Nama: %s\n", name.c_str());
            printf("NIM: %s\n", nim.c_str());
            printf("IPK: %.2f\n", ipk);
            printf("SKS: %d\n", total_sks);
        }
};

int Mahasiswa::counter = 0;
