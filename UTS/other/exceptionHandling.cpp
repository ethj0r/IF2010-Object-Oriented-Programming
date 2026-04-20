#include <exception>
#include <iostream>

int main() {
    try {
        int* arr = new int[100000000000]; // mungkin gagal
    }
    catch (std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    return 0;
}