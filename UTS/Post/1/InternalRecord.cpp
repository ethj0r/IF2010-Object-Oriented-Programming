#include "InternalRecord.hpp"

InternalRecord::InternalRecord(const std::string &author, int key)
    : BaseRecord(author, key)
{
}

int InternalRecord::peekSecurity() const
{
    return calculateClearance() * 2;
}
