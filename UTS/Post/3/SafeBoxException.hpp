#ifndef SAFE_BOX_EXCEPTION_HPP
#define SAFE_BOX_EXCEPTION_HPP

#include <exception>
#include <string>
#include <sstream>
using namespace std;

// Base class untuk semua exception SafeBox.
// Turunan dari std::exception override what() di setiap subclass.
class SafeBoxException : public exception {
public:
    virtual const char* what() const noexcept = 0;
    virtual ~SafeBoxException() = default;
};


class BoxFullException : public SafeBoxException {
public:
    explicit BoxFullException(int capacity) : cap(capacity) {
        msg = "Box penuh: kapasitas maks " + to_string(cap);
    }

    const char* what() const noexcept override { return msg.c_str(); }

private:
    int cap;
    string msg;
};


class BoxEmptyException : public SafeBoxException {
public:
    BoxEmptyException() : msg("Box kosong") {}

    const char* what() const noexcept override { return msg.c_str(); }

private:
    string msg;
};


// Template: item yang tidak valid dapat bertipe apa saja (int, string, dll.)
// Gunakan ostringstream untuk mengonversi T ke string di dalam what().
// Contoh penggunaan ostringstream:
// int x = 42;
// ostringstream oss;
// oss << "Nilai x: " << x;
// string msg = oss.str(); // msg = "Nilai x: 42"
template<typename T>
class InvalidItemException : public SafeBoxException {
public:
    explicit InvalidItemException(const T& item) : item(item) {
        ostringstream oss;
        oss << "Item tidak valid: " << this->item;
        msg = oss.str();
    }

    const char* what() const noexcept override { return msg.c_str(); }

private:
    T item;
    string msg;
};

#endif