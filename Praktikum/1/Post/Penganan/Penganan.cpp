#include <stdio.h>
#include <iostream>
#include "Penganan.hpp"
using namespace std;

int Penganan::uang = 0;
int Penganan::n_rumah = 0;

Penganan::Penganan() {
    keik = 0;
    panekuk = 0;
}

Penganan::Penganan(int keik, int panekuk) {
    this->keik = keik;
    this->panekuk = panekuk;
}

int Penganan::GetKeik() const {
    return keik;
}

int Penganan::GetPanekuk() const {
    return panekuk;
}

void Penganan::SetKeik(int k) {
    keik = k;
}

void Penganan::SetPanekuk(int p) {
    panekuk = p;
}

Penganan operator+ (const Penganan& recent, const Penganan& stock) {
    Penganan res;
    res.keik = recent.keik+stock.keik;
    res.panekuk = recent.panekuk+stock.panekuk;
    Penganan::n_rumah++;
    return res;
}

Penganan operator- (const Penganan& sold, const Penganan& buy) {
    Penganan res;

    int keikSold = (buy.keik>sold.keik) ? sold.keik : buy.keik;
    int panekukSold = (buy.panekuk>sold.panekuk) ? sold.panekuk : buy.panekuk;

    res.keik = sold.keik - keikSold;
    res.panekuk = sold.panekuk - panekukSold;
    Penganan::uang += keikSold*51 + panekukSold*37;

    return res;
}

Penganan operator^ (const Penganan& p, const int n) {
    Penganan res;

    if (p.keik<n) {
        Penganan::uang -= (n-p.keik)*51;
        res.keik = 0;
    } else {
        res.keik = p.keik-n;
    }

    if (p.panekuk<n) {
        Penganan::uang -= (n-p.panekuk)*37;
        res.panekuk = 0;
    } else {
        res.panekuk = p.panekuk-n;
    }

    return res;
}

Penganan operator^ (const int n, const Penganan& p) {
    return p^n;
}

int Penganan::JumlahUang() {
    return uang;
}

int Penganan::HitungNRumah() {
    return n_rumah;
}

void Penganan::Print() {
    printf("%dkeik-%dpanekuk\n", keik, panekuk);
}
