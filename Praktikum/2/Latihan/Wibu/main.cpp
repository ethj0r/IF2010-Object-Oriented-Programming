#include "A.hpp"
#include "B.hpp"

using namespace std;

int main() {
    B b;
    A a;

    // a.setMe(100);
    b.A::setMe(10);
    b.setMe(200);

    b.print();

    return 0;
}