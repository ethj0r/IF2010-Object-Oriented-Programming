#pragma once

#include <string>
using namespace std;

class VaultException {
public:
    virtual const char* what() const noexcept = 0;
    virtual ~VaultException() = default;
};

class EmptyVaultException : public VaultException {
public:
    const char* what() const noexcept override;
};

class FullVaultException : public VaultException {
private:
    size_t cap;
public:
    FullVaultException(size_t capacity);
    const char* what() const noexcept override;
    size_t getCapacity() const noexcept;
};

class InvalidRelicException : public VaultException {
private:
    string message;
    string relicName;
public:
    InvalidRelicException(const string& msg, const string& name);
    const char* what() const noexcept override;
    const string& getRelicName() const noexcept;
};
