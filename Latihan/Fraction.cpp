#include <stdio.h>
#include <iostream>
using namespace std;

class Fraction {
    public:
        Fraction(int pembilang, int penyebut) {
            this->pembilang = pembilang;
            this->penyebut = penyebut;
        }

        friend Fraction operator+ (const Fraction& a, const Fraction& b) {
            return Fraction(a.pembilang*b.penyebut + b.pembilang*a.penyebut, a.penyebut*b.penyebut);
        }

        friend Fraction operator* (const Fraction& a, const Fraction& b){
            return Fraction(a.pembilang*b.pembilang, a.penyebut*b.penyebut);
        }

        Fraction operator+= (const Fraction& b){
            *this = *this + b;
            return *this;
        }

        void print() {
            cout << pembilang << "/" << penyebut << endl;
        }

    private:
        int pembilang;
        int penyebut;
};

int main() {
    Fraction myObject(1,2);
    Fraction myObject2(1,3);

    Fraction myObject3 = myObject + myObject2;
    myObject3.print();

    Fraction myObject4 = myObject * myObject2;
    myObject4.print();

    myObject += myObject2;
    myObject.print();
}