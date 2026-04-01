#include "Player.hpp"
#include "GachaException.hpp"

Player::Player(std::string name, int initialGems) : name(name), gems(initialGems) {}

std::string Player::getName() const {
    return name;
}

int Player::getGems() const {
    return gems;
}

void Player::addGems(int amount) {
    gems += amount;
}

void Player::deductGems(int amount) {
    if (gems < amount) {
        throw InsufficientGemsException();
    }
    gems -= amount;
}
