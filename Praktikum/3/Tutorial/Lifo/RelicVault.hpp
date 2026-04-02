#pragma once

#include <string>
#include <stack>
#include "VaultException.hpp"

using namespace std;

class RelicVault {
private:
    stack<string> vault;
    size_t cap;

    void validate(const string& name) const;

public:
    RelicVault(size_t capacity);

    void push(const string& name);
    string pop();
    string top() const;
    size_t size() const;
    size_t capacity() const;
    bool empty() const;
};
