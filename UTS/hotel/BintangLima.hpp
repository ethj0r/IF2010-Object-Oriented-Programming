#pragma once

#include "Hotel.hpp"

class BintangLima : public Hotel {
    private:
        int facility;
    public:
        BintangLima(string name, string bintang, int openYear, int facility);

        void set_facility(int facility);
        int get_facility() const;

        double calculateFacility() const;

        double rate() const override;
        void displayInfo() const override;
};