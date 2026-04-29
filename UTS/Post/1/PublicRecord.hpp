#ifndef PUBLIC_RECORD_HPP
#define PUBLIC_RECORD_HPP

#include "BaseRecord.hpp"

class PublicRecord : public BaseRecord {
public:
	PublicRecord(const std::string &author, int key);
	int calculateClearance() const override;
};

#endif
