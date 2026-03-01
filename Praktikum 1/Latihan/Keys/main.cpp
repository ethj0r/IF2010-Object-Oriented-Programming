#include <iostream>
#include "BunchOfKeys.hpp"
using namespace std;

int main() {
    BunchOfKeys myKeys;

    cout << "1. Shake tanpa kunci" << endl;
    myKeys.shake();

    cout << "\n2. Shake dengan 1 kunci" << endl;
    myKeys.add();
    myKeys.shake();

    cout << "\n3. Shake dengan 5 kunci" << endl;
    int t = 4;
    while (t--) {
        myKeys.add();
    }
    myKeys.shake();
}