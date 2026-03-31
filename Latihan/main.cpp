// #pragma once

#include <iostream>
using namespace std;

class Pecahan {
    private:
        int num;
        int den;
    public:
        Pecahan(int n, int d) : num(n), den(d) {}

        Pecahan operator+(const Pecahan& rhs) const {
            return Pecahan(num*rhs.den + rhs.num*den, den*rhs.den);
        }

        friend ostream& operator<<(ostream& os, const Pecahan& f);
};

ostream& operator<<(ostream& os, const Pecahan& f) {
    os << f.num << "/" << f.den;
    return os;
}

int main() {
    Pecahan a(1, 2);
    Pecahan b(3, 4);
    
    cout << a << " + " << b << " = " << (a + b) << endl;

    return 0;
}