#pragma once

#include <iostream>
#include <string>
using namespace std;

class Vehicle {
    private:
        int no;
        string kategori;
        string merk;
        int tahun;
    
    public:
        // OPERATOR 4 SEKAWAN
        // default ctor
        Vehicle() : no(0), kategori("mobil"), merk("XXX"), tahun(0) {};
        // user defined ctor
        Vehicle(int no, string kategori, string merk, int tahun)
            : no(no), kategori(kategori), merk(merk), tahun(tahun) {};
        // copy constructor
        Vehicle(const Vehicle& other)
            : no(other.no), kategori(other.kategori), merk(other.merk), tahun(other.tahun) {};
        // destructor
        ~Vehicle() {};
        // copy assignment
        Vehicle& operator=(const Vehicle& other) {
            if (this != &other) {
                no = other.no;
                kategori = other.kategori;
                merk = other.merk;
                tahun = other.tahun;
            }
            return *this;
        }

        // METHODS
        void printInfo() {
            cout << "[VEHICLE's INFO] No: " << no << " | Kategori: " << kategori << " | Merk: " << merk <<" | Tahun: " << tahun << endl;
        }

        int biayaSewa(int lamaSewa) {
            if (kategori == "Bus") return 1000000000 * lamaSewa;
            else if (kategori == "Minibus") {
                if (lamaSewa >= 0 && lamaSewa <=5) return 5000000000;
                else return 5000000000 + 500000 * (lamaSewa-5);
            } else if (kategori == "Mobil") return 500000 * lamaSewa;
        }
};