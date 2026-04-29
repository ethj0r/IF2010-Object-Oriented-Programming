#include "PublicRecord.hpp"

PublicRecord::PublicRecord(const std::string &author, int key)
    : BaseRecord(author, key)
{
}

int PublicRecord::calculateClearance() const
{
    return 0;
}
