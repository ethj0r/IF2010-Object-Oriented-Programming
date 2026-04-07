#pragma once

#include <string>
#include <iostream>
using namespace std;

class Hotel {
    protected:
        string name;
        string bintang;
        int openYear;
    public:
        //CTOR
        //user-defined ctor
        Hotel(string name, string bintang, int openYear);
        //default ctor
        Hotel();

        //copy ctor
        Hotel(const Hotel& other);

        //dtor
        virtual ~Hotel();

        //operator assignment
        Hotel& operator=(const Hotel& other);

        void set_name(const string& name);
        string get_name() const;

        void set_bintang(const string& bintang);
        string get_bintang() const;

        int get_age() const;
        
        virtual void displayInfo() const;
        virtual double rate() const = 0;
};

