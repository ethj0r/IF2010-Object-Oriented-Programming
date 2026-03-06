#pragma once
#include "Vehicle.hpp"

class AirVehicle : private Vehicle {
    protected:
        int maxAltitude;
        string getBrandName() const;

    public:
        AirVehicle(string vehicleId, string brand, int maxSpeed, int maxAltitude);
        ~AirVehicle();

        virtual void fly(string destination) const;
        string showSpec() const;
};