#include "RelicVault.hpp"
#include <cctype>

RelicVault::RelicVault(size_t capacity) : cap(capacity) {}

void RelicVault::validate(const string& name) const {
    if (name.size() < 3) {
        throw InvalidRelicException("Error: Nama relic tidak valid - nama terlalu pendek", name);
    }
    for (char c : name) {
        if (isdigit(c)) {
            throw InvalidRelicException("Error: Nama relic tidak valid - mengandung angka", name);
        }
    }
}

void RelicVault::push(const string& name) {
    validate(name);
    if (vault.size() >= cap) {
        throw FullVaultException(cap);
    }
    vault.push(name);
}

string RelicVault::pop() {
    if (vault.empty()) {
        throw EmptyVaultException();
    }
    string top = vault.top();
    vault.pop();
    return top;
}

string RelicVault::top() const {
    if (vault.empty()) {
        throw EmptyVaultException();
    }
    return vault.top();
}

size_t RelicVault::size() const {
    return vault.size();
}

size_t RelicVault::capacity() const {
    return cap;
}

bool RelicVault::empty() const {
    return vault.empty();
}
