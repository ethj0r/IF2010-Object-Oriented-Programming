#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

class Hewan {
    public:
        Hewan() {};
        ~Hewan() {};
        virtual void suara() {
            cout << "[HEWAN] ...\n";
        }
};

class Kucing : public Hewan {
    public:
        // Kucing();
        // ~Kucing();
        void suara() {
            cout << "[KUCING] MEOW\n";
        }
};

class Anjing : public Hewan {
    public:
        Anjing() {};
        ~Anjing() {};
        void suara() override {
            cout << "[ANJING] GUK\n";
        }
};

int main() {
    Hewan* a = new Anjing();
    a->suara();

    return 0;
}