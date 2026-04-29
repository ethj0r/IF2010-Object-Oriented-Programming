#ifndef INTERNAL_RECORD_HPP
#define INTERNAL_RECORD_HPP

#include "BaseRecord.hpp"

class InternalRecord : protected BaseRecord {
public:
	InternalRecord(const std::string &author, int key);
	int peekSecurity() const;
};

#endif
