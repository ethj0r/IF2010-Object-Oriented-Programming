#include "VaultException.hpp"

const char* EmptyVaultException::what() const noexcept {
    return "Error: Vault kosong";
}



FullVaultException::FullVaultException(size_t capacity) : cap(capacity) {}

const char* FullVaultException::what() const noexcept {
    return "Error: Vault sudah penuh";
}

size_t FullVaultException::getCapacity() const noexcept {
    return cap;
}



InvalidRelicException::InvalidRelicException(const string& msg, const string& name) : message(msg), relicName(name) {}

const char* InvalidRelicException::what() const noexcept {
    return message.c_str();
}

const string& InvalidRelicException::getRelicName() const noexcept {
    return relicName;
}