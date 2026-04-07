#pragma once

#include "Hotel.hpp"

class BintangEmpat : public Hotel {
    private:
        int star; //jml star layanan
    public:
        BintangEmpat(string name, int openYear);
        BintangEmpat(string name, int openYear, int star);

        void set_star(int star);
        int get_star() const;
        
        double rate() const override;
        void displayInfo() const override;
};
