#include "Hotel.hpp"

#define CURRENT_YEAR 2026

Hotel::Hotel(string name, string bintang, int openYear)
    : name(name), bintang(bintang), openYear(openYear) {}

Hotel::Hotel() : name("noname"), bintang("none"), openYear(1900) {}

Hotel::~Hotel() {}

Hotel& Hotel::operator=(const Hotel& other) {
    if (this != &other) {
        name = other.name;
        bintang = other.bintang;
        openYear = other.openYear;
    }
    return *this;
}

void Hotel::set_name(const string& name) {
    this->name = name;
}

string Hotel::get_name() const {
    return name;
}

void Hotel::set_bintang(const string& bintang) {
    this->bintang = bintang;
}

string Hotel::get_bintang() const {
    return bintang;
}

int Hotel::get_age() const {
    return CURRENT_YEAR - openYear;
}

void Hotel::displayInfo() const {
    cout << "Nama       : " << name << endl;
    cout << "Umur Hotel : " << get_age() << " tahun" << endl;
    cout << "Bintang    : " << bintang << endl;
    cout << "Room Rate  : " << rate() << endl;
}