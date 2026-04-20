#include <iostream>
using namespace std;

class Kendaraan {
    public:
        virtual void info() {
            cout << "Ini adalah kendaraan" << endl;
        }
};

class Mobil : virtual public Kendaraan {
    public:
        virtual void info() {
            cout << "Ini adalah kendaraan mobil" << endl;
        }
};

class Motor : virtual public Kendaraan {
    public:
        virtual void info() {
            cout << "Ini adalah kendaraan motor" << endl;
        }
};

class BatMobile : public Mobil, public Motor {
    public:
        void info() {
            cout << "Ini adalah kendaraan mobil motor BatMobile" << endl;
        }
};

int main() {
    Kendaraan kendaraan;
    Mobil mobil;
    Motor motor;
    BatMobile batmobile;

    Kendaraan* obj1 = &kendaraan;
    obj1->info();
    obj1 = &mobil;
    obj1->info();
    obj1 = &motor;
    obj1->info();
    obj1 = &batmobile;
    obj1->info();
    cout << "\n";
    Kendaraan obj2 = kendaraan;
    obj2.info();
    obj2 = mobil;
    obj2.info();
    obj2 = motor;
    obj2.info();
    obj2 = batmobile;
    obj2.info();

    return 0;
}